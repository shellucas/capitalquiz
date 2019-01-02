package com.shellucas.quiz.questions;

import java.util.Map;

public class Question {

    private static int nrQuestions = 0;
    private int number;
    private QuestionType type;
    private Map<String, String> continent;
    private String country;

    public Question(QuestionType type, Map<String, String> continent, String country) {
        this.number = ++nrQuestions;
        this.type = type;
        this.continent = continent;
        this.country = country;
    }

    public int getNumber() {
        return number;
    }

    public QuestionType getType() {
        return type;
    }

    public Map<String, String> getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Question: " + number + "\n" +
                "Type: " + type + "\n" +
                "Country: " + country + "\n" +
                "City: " + continent.get(country);
    }
}
