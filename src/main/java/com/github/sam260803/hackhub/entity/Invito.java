package com.github.sam260803.hackhub.entity;

import com.github.sam260803.hackhub.state.StatoInvito;
import java.time.LocalDateTime;

public class Invito {
    private int id;
    private LocalDateTime dataInvito;
    private StatoInvito stato;
    private Utente daUtente;
    private Utente perUtente;
    private Team dalTeam;

    public StatoInvito getStato() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setStato(StatoInvito stato) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getId() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setId(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public LocalDateTime getDataInvito() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setDataInvito(LocalDateTime dataInvito) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Utente getDaUtente() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setDaUtente(Utente daUtente) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Utente getPerUtente() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setPerUtente(Utente perUtente) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Team getDalTeam() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setDalTeam(Team dalTeam) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}