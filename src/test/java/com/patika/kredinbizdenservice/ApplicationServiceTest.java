package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.Repository.ApplicationRepository;
import com.patika.kredinbizdenservice.Service.ApplicationService;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationService applicationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAplication() {
        // Create a user
        User user = new User();
        user.setId(1L);

        // Create a list of applications
        List<Application> applications = new ArrayList<>();
        applications.add(new Application());
        applications.add(new Application());

        // Mock the repository method
        when(applicationRepository.findByUserId(user.getId())).thenReturn(applications);

        // Call the service method
        List<Application> result = applicationService.getAllAplication("test@example.com", user);

        // Verify the result
        assertEquals(applications.size(), result.size());
    }

    @Test
    public void testSave() {
        // Create a user
        User user = new User();
        user.setId(1L);

        // Create a new application
        Application newApplication = new Application();
        newApplication.setUser(user);

        // Mock the repository method to return an empty list (no existing applications)
        when(applicationRepository.findByUserId(user.getId())).thenReturn(new ArrayList<>());

        // Mock the repository save method
        when(applicationRepository.save(newApplication)).thenReturn(newApplication);

        // Call the service method
        Application result = applicationService.save(newApplication);

        // Verify the result
        assertEquals(newApplication, result);
    }
}
