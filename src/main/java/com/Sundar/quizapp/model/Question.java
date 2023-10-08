package com.Sundar.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id

    private int id;
    private String questiontitle;
    private String option1;


    private String option2;

    private String option3;

    private String option4;

    private String rightanswer;

    private String difficultylevel;

    private String category;

}

