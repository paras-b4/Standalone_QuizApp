package com.paras.quizapp.service;
import com.paras.quizapp.dao.QuestionDao;
import com.paras.quizapp.dao.QuizDao;
import com.paras.quizapp.model.Question;
import com.paras.quizapp.model.QuestionWrapper;
import com.paras.quizapp.model.Quiz;
import com.paras.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizdao;
    @Autowired
    private QuestionDao questionDao;

    public String CreateQuiz(String category, String title, int numQ) {
        List<Question> question = questionDao.findquestionBycategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizdao.save(quiz);
        return "created";

    }

    public List<QuestionWrapper> getQuizQuestion(int id)
    {
       Quiz quiz=quizdao.findById(id).get();
       List<Question> questionfromdb= quiz.getQuestions();
       List<QuestionWrapper> questionsForUser=new ArrayList<>();
       for(Question q: questionfromdb)
       {
           QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
           questionsForUser.add(qw);
       }
       return questionsForUser;

    }
    public Integer calculateResult(int id, List<Response> response) {
        Quiz quiz=quizdao.findById(id).get();
        List<Question> question =quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response j:response)
        {
            if(j.getResponse().equals(question.get(i).getRightAnswer()))
                right++;
            i++;

        }
        return  right;




    }
}

