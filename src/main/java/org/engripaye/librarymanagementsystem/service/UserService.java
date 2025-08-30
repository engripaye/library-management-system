package org.engripaye.librarymanagementsystem.service;

import lombok.AllArgsConstructor;
import org.engripaye.librarymanagementsystem.model.AppUser;
import org.engripaye.librarymanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<AppUser> list(){
        return userRepository.findAll();
    }

    public AppUser create(AppUser create){
        return userRepository.save(create);
    }

    public AppUser get(Long id){
        return userRepository.findById(id).orElseThrow();
    }
}
