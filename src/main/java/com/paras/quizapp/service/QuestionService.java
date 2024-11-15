package com.paras.quizapp.service;

import com.paras.quizapp.dao.QuestionDao;
import com.paras.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;
    public List<Question> getallQuestion()
    {
       return questionDao.findAll();

    }


    public List<Question> getQuestionByCategory(String category) 
    {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "succes";

    }

    public String UpdateQuestion(int id, Question question) {
        questionDao.save(question);
        return "Updated";
    }

    public String deleteQuestion(int id) {
        questionDao.deleteById(id);
        return "deleted";
    }
}
