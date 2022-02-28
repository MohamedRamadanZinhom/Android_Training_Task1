package com.mohamed_ramadan.code.normalrecyclerview.Model;

public class Quiz {

    private String Question;
    private String Option1;
    private String Option2;
    private String Option3;
    private int Answer_No;
    private int Quiz_Code;

    public Quiz(String question, String option1, String option2, String option3, int answer_No, int quiz_Code) {
        Question = question;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Answer_No = answer_No;
        Quiz_Code = quiz_Code;
    }

    public Quiz(int quiz_Code) {
        Quiz_Code = quiz_Code;
    }

    public Quiz() {
    }


    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public int getAnswer_No() {
        return Answer_No;
    }

    public void setAnswer_No(int answer_No) {
        Answer_No = answer_No;
    }

    public int getQuiz_Code() {
        return Quiz_Code;
    }

    public void setQuiz_Code(int quiz_Code) {
        Quiz_Code = quiz_Code;
    }
}
