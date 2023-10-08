package com.Sundar.quizapp.Services;

import com.Sundar.quizapp.Dao.QuestionDao;
import com.Sundar.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity< List<Question>> getAllQuestion() {
        try {return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity< List<Question> >getQuestionsByCategory(String category) {
        try {return new ResponseEntity<>(questionDao.findBycategory(category),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

           }

    public ResponseEntity<String> addQuestions(Question question){

       questionDao.save(question);
       return new ResponseEntity<>("success",HttpStatus.CREATED);

    }
}
