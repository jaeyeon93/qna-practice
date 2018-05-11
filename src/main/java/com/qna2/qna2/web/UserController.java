package com.qna2.qna2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    List<User> users = new ArrayList<>();

    @PostMapping("/create")
    public String create(User usr) {
        System.out.println("User : " + usr);
        users.add(usr);
        return "redirect:/list";
        // redirect:/url로 이동을 하게된다.
        // static에 있는 index.html이 아니라, templates에 있는 index.html을 호출을 한다.
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", users);
        return "list";
    }
}
