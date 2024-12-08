pipeline {
    agent any

    environment {
        GITHUB_REPO = 'https://github.com/stage51/api-service.git'
        DOCKER_IMAGE = 'api-service'
        DOCKER_TAG = 'latest'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main', url: "${GITHUB_REPO}"
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker run -d -p 8888:8888 --name api-service api-service:latest'
                sh 'docker exec api-service curl http://localhost:8888/users'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
        always {
            cleanWs()
        }
    }
}
