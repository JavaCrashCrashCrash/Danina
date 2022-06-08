package com.doma.danina.service;

import com.doma.danina.entity.User;
import com.doma.danina.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public boolean insert(String name, String pwd) {
        try {
            String encodePassword = passwordEncoder.encode(pwd);
            User user = User.builder()
                    .name(name)
                    .pwd(encodePassword)
                    .build();
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("err : " + e.getMessage());
            return false;
        }
    }

    public String signIn(String name, String pwd) {
        User user = userRepository.getUserByName(name);
        boolean check = passwordEncoder.matches(pwd, user.getPwd());
        return check ? "okay" : "fail";
    }

    @Transactional
    public boolean modify(long id, String newPwd) {
        if (userRepository.modify(id, newPwd) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean deleteUserById(long id) {
        if (userRepository.deleteUserById(id) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

}
