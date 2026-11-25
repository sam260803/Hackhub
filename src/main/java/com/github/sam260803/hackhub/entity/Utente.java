package com.github.sam260803.hackhub.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Utente {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private LocalDateTime dataRegistrazione;
    private Team team;
    private List<Invito> inviti;

    public Team getTeam() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setTeam(Team team) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}