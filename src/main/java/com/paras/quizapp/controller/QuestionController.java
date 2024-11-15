package com.paras.quizapp.controller;

import com.paras.quizapp.model.Question;
import com.paras.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionservice ;

    @GetMapping("/allquestion")
    public List<Question> getallQuestion()
    {
        return questionservice.getallQuestion();
    }
    @GetMapping("{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category)
    {
        return questionservice.getQuestionByCategory(category);
    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question)
    {
        return questionservice.addQuestion(question);

    }
    @PutMapping("/update/{id}")
    public String UpdateQuestion(@PathVariable int id,@RequestBody Question question)
    {
        return questionservice.UpdateQuestion(id,question);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id )
    {
        return questionservice.deleteQuestion(id);
    }

}
