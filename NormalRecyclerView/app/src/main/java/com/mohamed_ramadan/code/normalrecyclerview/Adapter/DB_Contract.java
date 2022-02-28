package com.mohamed_ramadan.code.normalrecyclerview.Adapter;

import android.provider.BaseColumns;

public final class DB_Contract  {

    private DB_Contract(){}


    public class Quiz_DB implements BaseColumns {

        public static final String DATABASE_NAME="Quiz_DATABASE";
        public static final int DB_VERSION =1;
        public static final String TABLE_NAME="Quiz_Table";

        public static final String QUESTION_COLUMN="QUESTION";
        public static final String OPTION1_COLUMN="OPTION1";
        public static final String OPTION2_COLUMN="OPTION2";
        public static final String OPTION3_COLUMN="OPTION3";

        public static final String ANSWER_NO_COLUMN="ANSWER_NO";
        public static final String QUIZ_CODE_COLUMN ="CODE";

    }
}
