package ru.netology.springBootAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.springBootAuth.exception.InvalidCredentials;
import ru.netology.springBootAuth.exception.UnauthorizedUser;
import ru.netology.springBootAuth.model.Authorities;
import ru.netology.springBootAuth.repository.UserRepository;

import java.util.List;


@Service
public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public AuthorizationService() {
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    public String addNewUser(String login, String password) {
        return userRepository.addUser(login, password);

    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}