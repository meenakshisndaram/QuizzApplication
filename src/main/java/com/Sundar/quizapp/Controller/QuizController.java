package com.Sundar.quizapp.Controller;

import com.Sundar.quizapp.Services.Quizservice;
import com.Sundar.quizapp.model.QuestionWrapper;
import com.Sundar.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    Quizservice quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title){
        System.out.println("Hello god im sundar");
        return quizService.createQuiz(category,numQ,title);
               
        
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id){

   return   quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);

    }
}
