package org.engripaye.librarymanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.engripaye.librarymanagementsystem.model.AppUser;
import org.engripaye.librarymanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<AppUser> list(){
        return userService.list();
    }

    @PostMapping
    public AppUser create(@Valid @RequestBody AppUser create) {
        return userService.create(create);
    }

    @GetMapping("/{id}")
    public AppUser get(@PathVariable Long id){
        return userService.get(id);
    }
}
