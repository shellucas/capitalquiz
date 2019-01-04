package com.shellucas.quiz.questions;

import java.util.ArrayList;

class QuestionList extends ArrayList<Question> {

    private static QuestionList QUESTIONLIST = new QuestionList();

    private QuestionList() {
    }

    public static QuestionList getQUESTIONLIST() {
        return QUESTIONLIST;
    }

    @Override
    public boolean add(Question question) {
        // To check if the question isn't already in the list.
        if (this.contains(question)) return false;
        return super.add(question);
    }
}
