package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.Repository.UserRepository;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.patika.kredinbizdenservice.Config.MailConfig;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    private final EmailService emailService;


    @Override
    @Transactional
    public User save(User user) {
        User savedUser = userRepository.save(user);
        log.info("User saved: {}", savedUser);
        emailService.sendSimpleMessage(user.getEmail(),"Hoşgeldiniz","Kredinzbiden uygulamasında hesabınız açıldı hoş geldiniz");
        return savedUser;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    @Transactional
    public User update(String email, User user) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setEmail(user.getEmail());
            // Diğer alanları da güncelleme
            User updatedUser = userRepository.save(existingUser);
            log.info("User updated: {}", updatedUser);
            emailService.sendSimpleMessage(updatedUser.getEmail(), "Bilgi Güncelleme", "Bilgileriniz başarıyla güncellendi.");
            return updatedUser;
        } else {
            log.error("User not found with email: {}", email);
            return null;
        }
    }


    public ResponseEntity<List<Application>> applicationVIAbankName(String bankName, User user) {
       return null;
    }
}

