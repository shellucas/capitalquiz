package com.shellucas.quiz.questions;

import com.shellucas.data.WorldData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Random;

import static com.shellucas.quiz.questions.QuestionType.OPEN;

public class QuestionTest {

    private WorldData worldData;

    @Before
    public void setUp() throws Exception {
        worldData = WorldData.getWORLD_DATA();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testOpenQuestion() {
        QuestionList questionList = QuestionList.getQUESTIONLIST();
        Map<String, String> continent = worldData.getAfrica();
        String[] countries = continent.keySet().toArray(new String[0]);
        String[] cities = continent.values().toArray(new String[0]);
        for (int i = 0; i < 10; i++) {
            questionList.add(new Question(OPEN, continent, countries[getRandomQuestion(countries.length)]));
        }
        System.out.println(questionList);
    }

    private static int getRandomQuestion(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

}