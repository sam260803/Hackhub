package com.github.sam260803.hackhub.entity;

import com.github.sam260803.hackhub.state.Bozza;
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

    public Sottomissione() {
        setStato(new Bozza());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public LocalDateTime getDataCaricamento() {
        return dataCaricamento;
    }

    public void setDataCaricamento(LocalDateTime dataCaricamento) {
        this.dataCaricamento = dataCaricamento;
    }

    public LocalDateTime getDataInvio() {
        return dataInvio;
    }

    public void setDataInvio(LocalDateTime dataInvio) {
        this.dataInvio = dataInvio;
    }

    public StatoSottomissione getStato() {
        return stato;
    }

    public void setStato(StatoSottomissione stato) {
        this.stato = stato;
        if (stato != null) {
            stato.impostaContesto(this);
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Hackathon getHackathon() {
        return hackathon;
    }

    public void setHackathon(Hackathon hackathon) {
        this.hackathon = hackathon;
    }

    public Utente getAutore() {
        return autore;
    }

    public void setAutore(Utente autore) {
        this.autore = autore;
    }
}
