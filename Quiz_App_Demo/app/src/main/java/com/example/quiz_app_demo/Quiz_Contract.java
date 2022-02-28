package com.example.quiz_app_demo;

import android.provider.BaseColumns;

public final class Quiz_Contract {

    public Quiz_Contract(){}

    public static class QuestionsTable implements BaseColumns {

        public static final String TABLE_NAME="quiz_questions";
        public static final String COLUMN_QUESTION ="question";
        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_ANSWER_NO="answer_no";



    }

}
