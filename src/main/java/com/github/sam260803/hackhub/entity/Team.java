package com.github.sam260803.hackhub.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Team {
    private int id;
    private String nome;
    private LocalDateTime dataCreazione;
    private Utente creatore;
    private List<Utente> membri;
    private List<Invito> inviti;
    private List<Sottomissione> sottomissioni;
    private List<Hackathon> hackathons;

    public void setNome(String nome) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void getAttributi() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}