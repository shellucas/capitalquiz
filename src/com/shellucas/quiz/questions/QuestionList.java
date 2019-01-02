package com.shellucas.quiz.questions;

import java.util.ArrayList;

class QuestionList extends ArrayList<Question> {

    private static QuestionList QUESTIONLIST = new QuestionList();

    static QuestionList getQUESTIONLIST() {
        return QUESTIONLIST;
    }
}
