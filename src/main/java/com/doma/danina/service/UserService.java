package com.doma.danina.service;

import com.doma.danina.entity.User;
import com.doma.danina.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean insert(String name, String pwd) {
        User user = User.builder()
                .name(name)
                .pwd(pwd)
                .build();
        userRepository.save(user);
        return true;
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
