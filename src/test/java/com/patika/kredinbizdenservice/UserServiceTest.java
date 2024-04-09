package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.Repository.UserRepository;
import com.patika.kredinbizdenservice.Service.UserService;
import com.patika.kredinbizdenservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testSave() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.save(user);

        assertEquals(user, result);
    }

    @Test
    public void testGetAll() {
        List<User> users = new ArrayList<>();
        users.add(new User());

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAll();

        assertEquals(users.size(), result.size());
    }

    @Test
    public void testGetByEmail() {
        User user = new User();
        user.setEmail("test@example.com");

        doReturn(Optional.of(user)).when(userRepository).findByEmail(user.getEmail());

        User result = userService.getByEmail(user.getEmail());

        assertEquals(user, result);
    }


    @Test
    public void testUpdate() {
        User user = new User();
        user.setEmail("test@example.com");

        doReturn(Optional.of(user)).when(userRepository).findByEmail(user.getEmail());
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.update(user.getEmail(), user);

        assertEquals(user, result);
    }
}
