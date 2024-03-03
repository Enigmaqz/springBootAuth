package ru.netology.springBootAuth.repository;


import org.springframework.stereotype.Repository;
import ru.netology.springBootAuth.model.Authorities;
import ru.netology.springBootAuth.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class UserRepository {

    List<User> userRepository = new ArrayList<>();


    public List<Authorities> getUserAuthorities(String login, String password) {
        for (User user : userRepository) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return Arrays.asList(Authorities.values());
            }
        }
        return new ArrayList<>();
    }

    public String addUser(String login, String password) {
        User newUser = new User(login, password);
        userRepository.add(newUser);
        return newUser.toString();
    }
}