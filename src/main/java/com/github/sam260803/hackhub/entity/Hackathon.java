package com.github.sam260803.hackhub.entity;

import com.github.sam260803.hackhub.state.StatoHackathon;
import java.time.LocalDateTime;

public class Hackathon {
    private int id;
    private String nome;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private String regolamento;
    private LocalDateTime scadenzaIscrizioni;
    private String luogo;
    private double premio;
    private int numMaxTeam;
    private StatoHackathon stato;

    public StatoHackathon getStato() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setStato(StatoHackathon stato) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean validateSottomissione(Sottomissione s) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setNome(String nome) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getRegolamento() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}