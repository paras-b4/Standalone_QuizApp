package com.paras.quizapp.controller;

import com.paras.quizapp.model.QuestionWrapper;
import com.paras.quizapp.model.Response;
import com.paras.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController
{
    @Autowired
    private QuizService quizservice;
    @PostMapping("/create")
    public String CreateQuiz(@RequestParam String category ,@RequestParam String title,@RequestParam int numQ)
    {
        return quizservice.CreateQuiz(category,title,numQ);

    }
    @GetMapping("/get/{id}")
    public List<QuestionWrapper> getQuizQuestion(@PathVariable int id)
    {
        return quizservice.getQuizQuestion(id);
    }
    @PostMapping("/submit/{id}")
    public Integer calculateResult(@PathVariable int id,@RequestBody List<Response> response)
    {
        return quizservice.calculateResult(id,response);
    }


}
/*
Here quiz app is a monolithic application .
monolithic application is built as a single unified unit . the primary advantage is fast development speed due to the simplicity of having an application based on one code base .
entire application is built with the same programing language .

@.Advantages of monolithic application .
1.Easy deployment
2.Development fast in case of smaller project .
3.performance
4.Easy debugging
5.simplified testing

# Disadvantages of Monolithic application
1.slower development speed in case of large project .
2.scalability:- you cannot scale individual application .

and modules are tightly coupled with each other or dependent on each other .
 */