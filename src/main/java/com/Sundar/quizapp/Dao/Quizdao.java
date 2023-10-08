package com.Sundar.quizapp.Dao;
import com.Sundar.quizapp.model.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Quizdao  extends JpaRepository<Quizz, Integer> {

}
