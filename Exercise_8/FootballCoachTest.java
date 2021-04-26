package com.company;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class FootballCoachTest {

    private ArrayList<String> get_m_activePlayers(FootballCoach coach) {
        try {
            ArrayList<String> m_activePlayers = null;
            Field privateStringField = null;
            privateStringField = FootballCoach.class.
                    getDeclaredField("m_activePlayers");
            privateStringField.setAccessible(true);
            m_activePlayers = (ArrayList<String>) privateStringField.get(coach);

            return m_activePlayers;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> get_m_benchPlayers(FootballCoach coach) {
        try {
            ArrayList<String> m_benchPlayers = null;
            Field privateStringField = null;
            privateStringField = FootballCoach.class.
                    getDeclaredField("m_benchPlayers");
            privateStringField.setAccessible(true);
            m_benchPlayers = (ArrayList<String>) privateStringField.get(coach);

            return m_benchPlayers;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String get_m_playersFormation(FootballCoach coach) {
        try {
            String m_playersFormation = null;
            Field privateStringField = null;
            privateStringField = FootballCoach.class.
                    getDeclaredField("m_playersFormation");
            privateStringField.setAccessible(true);
            m_playersFormation = (String) privateStringField.get(coach);

            return m_playersFormation;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test_sendPlayerToBench_positive_flow() throws InvalidCoachAction, InvalidPlayerException {
        FootballCoach footballCoach = new FootballCoach();

        ArrayList<String> m_benchPlayers = get_m_benchPlayers(footballCoach);
        ArrayList<String> m_activePlayers = get_m_activePlayers(footballCoach);
        m_activePlayers.add("David Beckham");

        footballCoach.sendPlayerToBench("David Beckham");

        assertEquals(m_benchPlayers.get(0),"David Beckham");
    }

    @Test (expected = InvalidCoachAction.class)
    public void test_sendPlayerToBench_InvalidCoachAction() throws InvalidCoachAction, InvalidPlayerException {
        FootballCoach footballCoach = new FootballCoach();

        footballCoach.sendPlayerToBench("David Beckham");
    }

    @Test (expected = InvalidPlayerException.class)
    public void test_sendPlayerToBench_InvalidPlayerException() throws InvalidCoachAction, InvalidPlayerException {
        FootballCoach footballCoach = new FootballCoach();
        String player = null;
        footballCoach.sendPlayerToBench(player);
    }

    @Test
    public void test_sendPlayerToField_positive_flow() throws InvalidCoachAction, InvalidPlayerException {
        FootballCoach footballCoach = new FootballCoach();

        ArrayList<String> m_benchPlayers = get_m_benchPlayers(footballCoach);
        ArrayList<String> m_activePlayers = get_m_activePlayers(footballCoach);
        m_benchPlayers.add("David Beckham");

        footballCoach.sendPlayerToField("David Beckham");

        assertEquals(m_activePlayers.get(0),"David Beckham");
    }

    @Test (expected = InvalidCoachAction.class)
    public void test_sendPlayerToField_InvalidCoachAction() throws InvalidCoachAction, InvalidPlayerException {
        FootballCoach footballCoach = new FootballCoach();

        footballCoach.sendPlayerToField("David Beckham");
    }

    @Test (expected = InvalidPlayerException.class)
    public void test_sendPlayerToField_InvalidPlayerException() throws InvalidCoachAction, InvalidPlayerException {
        FootballCoach footballCoach = new FootballCoach();
        String player = null;
        footballCoach.sendPlayerToField(player);
    }

    @Test
    public void test_changePlayersFormation_positive_flow() throws NotEnoughPlayersException {
        FootballCoach footballCoach = new FootballCoach();

        ArrayList<String> m_benchPlayers = get_m_benchPlayers(footballCoach);
        ArrayList<String> m_activePlayers = get_m_activePlayers(footballCoach);

        for (int i = 1; i <= 10; i++){
            m_activePlayers.add("Buffon");
        }

        footballCoach.changePlayersFormation("1-4-5");

        String playersFormation = get_m_playersFormation(footballCoach);

        assertEquals(playersFormation, "1-4-5");
    }

    @Test (expected = NotEnoughPlayersException.class)
    public void test_changePlayersFormation_NotEnoughPlayersException() throws NotEnoughPlayersException {
        FootballCoach footballCoach = new FootballCoach();
        ArrayList<String> m_activePlayers = get_m_activePlayers(footballCoach);

        for (int i = 1; i <= 11; i++){
            m_activePlayers.add("David Beckham");
        }
        footballCoach.changePlayersFormation("2-4-4");
    }
}
