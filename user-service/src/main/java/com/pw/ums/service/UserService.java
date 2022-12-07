package com.pw.ums.service;

import com.pw.ums.entity.DGUser;
import com.pw.ums.model.UserRequest;
import com.pw.ums.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<DGUser> getAllUsers(){
        return userRepository.findAll();
    }

    public DGUser addUser(UserRequest userRequest) {
        DGUser newDGUser = new DGUser();
        newDGUser.setFirstName(userRequest.getFirstName());
        newDGUser.setLastName(userRequest.getLastName());
        newDGUser.setEmail(userRequest.getEmail());
        newDGUser.setActive(true);
        newDGUser.setCreatedOn(Instant.now());
        return userRepository.save(newDGUser);
    }

    public DGUser findByUserId(long userId) {
        Optional<DGUser> user = userRepository.findById(userId);
        //TODO: UserNotFoundException Add Custom Exception Handling
        //1. https://www.toptal.com/java/spring-boot-rest-api-error-handling
        //2. https://www.baeldung.com/exception-handling-for-rest-with-spring

        return user.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found for the give id:"+userId));

    }
}
