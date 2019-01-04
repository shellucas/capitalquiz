package com.shellucas.quiz.questions;

import java.util.Map;
import java.util.Random;

public class Question {

    private static int nrQuestions = 0;
    private int number;
    private QuestionType type;
    private Map<String, String> continent;
    private String country;

    /**
     * To create a random question.
     *
     * @param type
     * @param continent
     */
    public Question(QuestionType type, Map<String, String> continent) {
        this(type, continent, (String) continent.keySet().toArray()[new Random().nextInt(continent.keySet().size())]);
    }

    /**
     * To create a question with a specified country
     *
     * @param type
     * @param continent
     * @param country
     */
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

    public boolean answer(String city) {
        return continent.get(country).equals(city);
    }

    public String getAnswer() {
        return continent.get(country);
    }

    public String[] generateAnswers(int answers) {
        if (type == QuestionType.OPEN) return null;
        String[] fakes = new String[answers];
        Random random = new Random();
        for (int i = 0; i < answers; i++) {
            // TODO remove duplicate answers
            String answer;
            while ((answer = (String) continent.values().toArray()[random.nextInt(continent.size())]).equals(continent.get(country)));
            fakes[i] = answer;
        }
        return fakes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Question) {
            Question question = (Question) obj;
            return this.type == question.type
                    && this.continent == question.continent
                    && this.country.equals(question.country);
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Question: " + number + "\n" +
                "Type: " + type + "\n" +
                "Country: " + country + "\n" +
                "City: " + continent.get(country);
    }
}
