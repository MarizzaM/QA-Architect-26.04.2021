package com.company;

import java.util.ArrayList;

public class FootballCoach {

    private ArrayList<String> m_activePlayers = new ArrayList<>();
    private ArrayList<String> m_benchPlayers = new ArrayList<>();
    private String m_playersFormation;

    public void sendPlayerToBench(String player) throws InvalidCoachAction, InvalidPlayerException {
        if (!m_activePlayers.contains(player) && player != null)
            throw new InvalidCoachAction(String.format("%s is not playing on the field", player));
        if (player == null)
            throw new InvalidPlayerException("Input of the player is incorrect");
        m_benchPlayers.add(0,player);
    }

    public void sendPlayerToField(String player) throws InvalidCoachAction, InvalidPlayerException {
        if (!m_benchPlayers.contains(player) && player != null)
            throw new InvalidCoachAction(String.format("%s is not sitting on the bench", player));
        if (player == null)
            throw new InvalidPlayerException("Input of the player is incorrect");
        m_activePlayers.add(0,player);
    }

    public void changePlayersFormation(String playersFormation) throws NotEnoughPlayersException {
        if (m_activePlayers.size() < 11){
            m_playersFormation = playersFormation;
        } else {
            throw new NotEnoughPlayersException("Not Enough Players");
        }


    }






}
