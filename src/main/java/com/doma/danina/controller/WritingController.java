package com.doma.danina.controller;

import com.doma.danina.entity.User;
import com.doma.danina.entity.Writing;
import com.doma.danina.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WritingController {
    private final WritingService writingService;
    List<Writing> writingList;

    @PostMapping("/writing/insert")
    @CrossOrigin("*")
    public String insert(@RequestParam("title") String title, @RequestParam("body") String body, @RequestParam("name") String name) {
        if (writingService.insert(title, body, name)) {
            return name + "'s essay is successfully posted.";
        } else {
            return "Wrong approach.";
        }
    }

    @PostMapping("/writing/modify")
    @CrossOrigin("*")
    public String modify(@RequestParam("id") long id, @RequestParam("newTitle") String newTitle, @RequestParam("newBody") String newBody) {
        if (writingService.modify(id, newTitle, newBody)) {
            return "Successfully changed";
        } else {
            return "Wrong approach";
        }
    }
//
    @PostMapping("/writing/delete")
    @CrossOrigin("*")
    public String deleteUserById(@RequestParam("id") long id) {
        if (writingService.deleteWritingById(id)) {
            return "Deleted";
        } else {
            return "Wrong approach";
        }
    }

    @GetMapping("/writing/all")
    @CrossOrigin("*")
    public List<Writing> getWritings() {
        return writingService.getWritings();
    }

    @GetMapping("/writing/get")
    @CrossOrigin("*")
    public Writing getWritingById(long id) {
        return writingService.getWritingById(id);
    }

    @GetMapping("/writing/name")
    @CrossOrigin("*")
    public List<Writing> getWritingByName(String name) {
        return writingService.getWritingsByName(name);
    }

}
