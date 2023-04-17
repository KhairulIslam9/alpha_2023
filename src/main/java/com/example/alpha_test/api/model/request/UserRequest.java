package com.example.alpha_test.api.model.request;

import com.example.alpha_test.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private String firstname;
    private String lastname;

    public static User toUser(UserRequest request) {
        User newUser = new User();
        newUser.setFirstname(request.getFirstname());
        newUser.setLastname(request.getLastname());

        return newUser;
    }
}
