package com.example.internshipapp.controller;

import com.example.internshipapp.entity.User;
import com.example.internshipapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    UserRepository userRepository;
    @GetMapping("")
    public String main(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        System.out.println(users);
        return "index.html";
    }
}
