package com.doma.danina.controller;

import com.doma.danina.entity.User;
import com.doma.danina.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    List<User> userList;

    @PostMapping("/user/insert")
    @CrossOrigin("*")
    public String insert(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        System.out.println("inser!");
        if (userService.insert(name, pwd)) {
            return name + " registered";
        } else {
            return "ID already exists";
        }
    }

    @PostMapping("/user/signin")
    public String signIn(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        return userService.signIn(name, pwd);
    }

    @PostMapping("/user/modify")
    @CrossOrigin("*")
    public String modify(@RequestParam("id") long id, @RequestParam("newPwd") String newPwd) {
        if (userService.modify(id, newPwd)) {
            return "Successfully changed";
        } else {
            return "Wrong approach";
        }
    }

    @PostMapping("/user/delete")
    @CrossOrigin("*")
    public String deleteUserById(@RequestParam("id") long id) {
        if (userService.deleteUserById(id)) {
            return "Deleted";
        } else {
            return "Wrong approach";
        }
    }

    @GetMapping("/user/all")
    @CrossOrigin("*")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/get")
    @CrossOrigin("*")
    public User getUserById(long id) {
        return userService.getUserById(id);
    }

}
