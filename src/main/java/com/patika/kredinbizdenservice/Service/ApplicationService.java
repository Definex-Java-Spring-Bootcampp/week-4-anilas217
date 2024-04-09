package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.Repository.ApplicationRepository;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class ApplicationService implements IApplicationService {

    private static final Logger log = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> getAllAplication(String email, User user) {
        List<Application> applicationList = (List<Application>) applicationRepository.findByUserId(user.getId());
        if (!applicationList.isEmpty()) {
            return applicationList;
        } else {
            log.error("No application found for user with id: {}", user.getId());
            return Collections.emptyList();
        }
    }

    @Override
    public Application save(Application application) {
        List<Application> existingApplications = applicationRepository.findByUserId(application.getUser().getId());
        if (existingApplications.isEmpty()) {
            return applicationRepository.save(application);
        } else {
            log.error("Application already exists for user with id: {}", application.getUser().getId());
            return existingApplications.get(0); // Return the first existing application
        }
    }
}
