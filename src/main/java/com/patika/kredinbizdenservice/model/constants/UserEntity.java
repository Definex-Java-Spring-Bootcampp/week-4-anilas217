package com.patika.kredinbizdenservice.model.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class UserEntity {

    public static final String name = "name";

    public static final String surname = "surname";
    public static final String birth_date = "birth_date";
    public static final String email = "email";
    public static final String password = "password";
    public static final String phoneNumber = "phoneNumber";
    public static final String isActive = "isActive";
}
