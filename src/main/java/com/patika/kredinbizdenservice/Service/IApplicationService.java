package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;

import java.util.List;

public interface IApplicationService {
    List<Application> getAllAplication(String email, User user);

    Application save(Application application);
}
