package com.github.sam260803.hackhub.entity;

import com.github.sam260803.hackhub.state.Pendente;
import com.github.sam260803.hackhub.state.StatoInvito;
import java.time.LocalDateTime;

public class Invito {
    private int id;
    private LocalDateTime dataInvito;
    private StatoInvito stato;
    private Utente daUtente;
    private Utente perUtente;
    private Team dalTeam;

    public Invito() {
        setStato(new Pendente());
    }

    public StatoInvito getStato() {
        return stato;
    }

    public void setStato(StatoInvito stato) {
        this.stato = stato;
        if (stato != null) {
            stato.impostaContesto(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataInvito() {
        return dataInvito;
    }

    public void setDataInvito(LocalDateTime dataInvito) {
        this.dataInvito = dataInvito;
    }

    public Utente getDaUtente() {
        return daUtente;
    }

    public void setDaUtente(Utente daUtente) {
        this.daUtente = daUtente;
    }

    public Utente getPerUtente() {
        return perUtente;
    }

    public void setPerUtente(Utente perUtente) {
        this.perUtente = perUtente;
    }

    public Team getDalTeam() {
        return dalTeam;
    }

    public void setDalTeam(Team dalTeam) {
        this.dalTeam = dalTeam;
    }
}
