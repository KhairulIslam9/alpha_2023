package com.example.alpha_test.api.controller;

import com.example.alpha_test.api.model.request.UserRequest;
import com.example.alpha_test.model.User;
import com.example.alpha_test.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("{userId}")
    public User getById(@PathVariable Integer userId) {
        return userService.getById(userId);
    }

    @PostMapping("/create")
    public User create(@RequestBody UserRequest request)  {
        return this.userService.saveOrUpdate(UserRequest.toUser(request));
    }

    @PutMapping("{userId}")
    public User update(@PathVariable Integer userId, @RequestBody User modified) {
        User retval = null;

        if (userId != null && modified != null) {
            User original = userService.getById(userId);
            original.apply(modified);

            retval = userService.saveOrUpdate(original);

            if (retval == null) {
                throw new RuntimeException("Error while updating user: " + userId);
            }
        }
        return retval;
    }

    @DeleteMapping("{userId}")
    public boolean delete(@PathVariable Integer userId) {
        return userService.delete(userId);
    }
}
