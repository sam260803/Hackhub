package com.github.sam260803.hackhub.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String nome;
    private LocalDateTime dataCreazione;
    private Utente creatore;
    private List<Utente> membri = new ArrayList<>();
    private List<Invito> inviti = new ArrayList<>();
    private List<Sottomissione> sottomissioni = new ArrayList<>();
    private List<Hackathon> hackathons = new ArrayList<>();

    public void getAttributi() {
        // Gli attributi del team sono esposti dai getter tipizzati.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Utente getCreatore() {
        return creatore;
    }

    public void setCreatore(Utente creatore) {
        this.creatore = creatore;
    }

    public List<Utente> getMembri() {
        return membri;
    }

    public void setMembri(List<Utente> membri) {
        this.membri = membri;
    }

    public List<Invito> getInviti() {
        return inviti;
    }

    public void setInviti(List<Invito> inviti) {
        this.inviti = inviti;
    }

    public List<Sottomissione> getSottomissioni() {
        return sottomissioni;
    }

    public void setSottomissioni(List<Sottomissione> sottomissioni) {
        this.sottomissioni = sottomissioni;
    }

    public List<Hackathon> getHackathons() {
        return hackathons;
    }

    public void setHackathons(List<Hackathon> hackathons) {
        this.hackathons = hackathons;
    }
}
