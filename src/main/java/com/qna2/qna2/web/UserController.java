package com.qna2.qna2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    List<User> users = new ArrayList<>();

    @PostMapping("/create")
    public String create(User usr) {
        System.out.println("User : " + usr);
        users.add(usr);
        return "redirect:/users";
        // redirect:/url로 이동을 하게된다.
        // static에 있는 index.html이 아니라, templates에 있는 index.html을 호출을 한다.
    }

    @GetMapping("/users")
    public String list(Model model) {
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable String userId ,Model model) {
            model.addAttribute("user", userId);
            return "profile";
        }
    }
