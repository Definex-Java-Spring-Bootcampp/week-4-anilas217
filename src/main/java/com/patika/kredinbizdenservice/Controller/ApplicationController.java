package com.patika.kredinbizdenservice.Controller;

import com.patika.kredinbizdenservice.Service.IApplicationService;
import com.patika.kredinbizdenservice.Service.IUserService;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Application create(@RequestBody Application application) {
        System.out.println("applicationService: " + applicationService.hashCode());
        return applicationService.save(application);
    }

}
