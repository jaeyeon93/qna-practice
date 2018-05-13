package com.qna2.qna2.web;

import com.qna2.qna2.domain.QnA;
import com.qna2.qna2.domain.QnARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QnARepository qnARepository;

    @GetMapping("/form")
    public String getForm() {
        return "/qna/form";
    }

    @PostMapping("")
    public String create(QnA qna) {
        qnARepository.save(qna);
        return "redirect:/questions";
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("questions", qnARepository.findAll());
        return "qna/list";
    }

    @GetMapping("/{id}")
    public String getQnA(@PathVariable Long id, Model model) {
        model.addAttribute("questions", qnARepository.findOne(id));
        return "/qna/show";
    }
}
