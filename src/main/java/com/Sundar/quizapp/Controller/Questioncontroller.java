package com.Sundar.quizapp.Controller;

import com.Sundar.quizapp.model.Question;
import com.Sundar.quizapp.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class Questioncontroller {
    @Autowired
    QuestionService questionService;
    @GetMapping("allquestions")
    public ResponseEntity<List<Question> >Quiz(){
        return questionService.getAllQuestion();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question> >getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String >addQuestion(@RequestBody Question question){
       return questionService.addQuestions(question);
        System.out.println("Maverick")


    }


}
