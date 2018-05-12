package com.qna2.qna2.web;

import com.qna2.qna2.domain.User;
import com.qna2.qna2.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public String create(User usr) {
        userRepository.save(usr);
        return "redirect:/users";
        // redirect:/url로 이동을 하게된다.
        // static에 있는 index.html이 아니라, templates에 있는 index.html을 호출을 한다.
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/user/list";
    }

//    @RequestMapping("/users/{userId}")
//    public String getUser(@PathVariable String userId , Model model) {
//            for (User user : users)
//                if (user.getUserId().equals(userId))
//                    model.addAttribute("user", user);
//            return "profile";
//    }
}
