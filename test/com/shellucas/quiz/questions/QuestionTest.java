package com.shellucas.quiz.questions;

import com.shellucas.data.WorldData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.shellucas.quiz.questions.QuestionType.MULTIPLE;
import static com.shellucas.quiz.questions.QuestionType.OPEN;
import static org.junit.Assert.*;

public class QuestionTest {

    private QuestionList questionList;
    private WorldData worldData;

    @Before
    public void setUp() {
        worldData = WorldData.getWORLD_DATA();
        questionList = QuestionList.getQUESTIONLIST();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAnswer() {
        Map<String, String> continent = worldData.getAfrica();
        String[] countries = continent.keySet().toArray(new String[0]);
        String[] cities = continent.values().toArray(new String[0]);

        boolean promise = questionList.add(new Question(OPEN, continent, countries[0]));
        assertTrue(promise);
        String[] answers = questionList.get(0).generateAnswers(4);
        assertNull(answers);
        assertTrue(questionList.get(0).answer(cities[0]));
        assertFalse(questionList.get(0).answer(cities[1]));

        promise = questionList.add(new Question(OPEN, continent, countries[5]));
        assertTrue(promise);
        assertTrue(questionList.get(1).answer(cities[5]));
        assertFalse(questionList.get(1).answer(cities[1]));

        promise = questionList.add(new Question(MULTIPLE, continent, countries[3]));
        assertTrue(promise);
        assertTrue(questionList.get(2).answer(cities[3]));
        assertFalse(questionList.get(2).answer(cities[19]));

        promise = questionList.add(new Question(OPEN, continent, countries[20]));
        assertTrue(promise);
        assertTrue(questionList.get(3).answer(cities[20]));
        assertFalse(questionList.get(3).answer(cities[30]));

        assertEquals(4, questionList.size());

        questionList.clear();

        assertEquals(0, questionList.size());

        promise = questionList.add(new Question(MULTIPLE, continent, countries[3]));
        assertTrue(promise);
        answers = questionList.get(0).generateAnswers(4);
        assertEquals(4, answers.length);
        for (int i = 0; i < 100; i++) {
            answers = questionList.get(0).generateAnswers(4);
            for (String answer : answers) {
                assertNotEquals(questionList.get(0).getAnswer(), answer);
            }
        }
        assertTrue(questionList.get(0).answer(cities[3]));
        assertFalse(questionList.get(0).answer(cities[19]));

        questionList.clear();
        for (String country : countries) {
            promise = questionList.add(new Question(OPEN, continent, country));
            assertTrue(promise);
        }

        promise = questionList.add(new Question(OPEN, continent));
        assertFalse(promise);
    }

}