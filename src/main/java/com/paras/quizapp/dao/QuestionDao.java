package com.paras.quizapp.dao;

import com.paras.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(value= "SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ ",nativeQuery = true )
    List<Question> findquestionBycategory (String category ,int numQ );


}
