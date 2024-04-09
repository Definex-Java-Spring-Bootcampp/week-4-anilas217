package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    User save(User user);

    List<User> getAll();

    User getByEmail(String email);

    User update(String email, User user);

    ResponseEntity<List<Application>> applicationVIAbankName(String bankName, User user);
}
