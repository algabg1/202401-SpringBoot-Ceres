package com.example.demo.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum RoleUser {
    ADMIN("admin"),
    USER("user");

    private String role;

    RoleUser(String role){
        this.role = role;
    }

}
