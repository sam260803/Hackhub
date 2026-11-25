package com.github.sam260803.hackhub.entity;

import com.github.sam260803.hackhub.state.StatoSottomissione;
import java.time.LocalDateTime;

public class Sottomissione {
    private int id;
    private String materiale;
    private LocalDateTime dataCaricamento;
    private LocalDateTime dataInvio;
    private StatoSottomissione stato;
    private Team team;
    private Hackathon hackathon;
    private Utente autore;

    public void setDataInvio(LocalDateTime data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setStato(StatoSottomissione stato) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setMateriale(String materiale) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}