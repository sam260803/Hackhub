package com.github.sam260803.hackhub.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Utente {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private LocalDateTime dataRegistrazione;
    private Team team;
    private List<Invito> inviti = new ArrayList<>();

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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(LocalDateTime dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Invito> getInviti() {
        return inviti;
    }

    public void setInviti(List<Invito> inviti) {
        this.inviti = inviti;
    }
}
