package com.Sundar.quizapp.Services;

import com.Sundar.quizapp.Dao.QuestionDao;
import com.Sundar.quizapp.Dao.Quizdao;
import com.Sundar.quizapp.model.Question;
import com.Sundar.quizapp.model.QuestionWrapper;
import com.Sundar.quizapp.model.Quizz;
import com.Sundar.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Quizservice {
    @Autowired
    Quizdao quizdao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quizz quiz=new Quizz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizdao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED) ;

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
      Optional<Quizz> quizz=  quizdao.findById(id);
      List <Question> questionfromdb=quizz.get().getQuestion();
      List<QuestionWrapper>questionsforUser=new ArrayList<>();
      for (Question q:questionfromdb)
      {
          QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
          questionsforUser.add(qw);
      }
      return  new ResponseEntity<>(questionsforUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quizz quizz=quizdao.findById(id).get();
        List<Question> questions=quizz.getQuestion();
        int right =0;
        int i=0;
        for (Response response:responses){
            if (response.getResponse().equals(questions.get(i).getRightanswer()))
                right++;
            i++;}
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
