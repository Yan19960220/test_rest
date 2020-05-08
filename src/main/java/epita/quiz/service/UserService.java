package epita.quiz.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import epita.quiz.model.User;
import epita.quiz.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
