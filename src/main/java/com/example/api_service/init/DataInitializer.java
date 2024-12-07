package com.example.api_service.init;

import com.example.api_service.models.Book;
import com.example.api_service.models.User;
import com.example.api_service.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        List<User> users = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("User " + i);

            List<Book> books = new ArrayList<>();
            for (int j = 1; j <= 3; j++) {
                Book book = new Book();
                book.setTitle("Book " + j + " of User " + i);
                book.setUser(user);
                books.add(book);
            }

            user.setBooks(books);
            users.add(user);
        }

        userRepository.saveAll(users);
    }
}
