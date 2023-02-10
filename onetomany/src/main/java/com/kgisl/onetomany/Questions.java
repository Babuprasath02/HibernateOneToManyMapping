package com.kgisl.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="question_table")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String question;
   
    @JoinColumn(name="qid")
    @OrderColumn(name = "type")
    @OneToMany(cascade= CascadeType.ALL)
    private List<Answers> answer;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public List<Answers> getAnswer() {
        return answer;
    }
    public void setAnswer(List<Answers> answer) {
        this.answer = answer;
    }
    

    
    
}
