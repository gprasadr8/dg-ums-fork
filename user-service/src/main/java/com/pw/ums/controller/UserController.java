package com.pw.ums.controller;

import com.pw.ums.entity.DGUser;
import com.pw.ums.model.UserRequest;
import com.pw.ums.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<DGUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public DGUser addUser(@Valid @RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }
    @GetMapping("/{id}")
    public DGUser getUser(@Min(value = 1,message = "invalid user Id") @PathVariable("id") long userId){
        return userService.findByUserId(userId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
