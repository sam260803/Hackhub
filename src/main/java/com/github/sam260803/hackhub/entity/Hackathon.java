package com.github.sam260803.hackhub.entity;

import com.github.sam260803.hackhub.state.Iscrizione;
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

    public Hackathon() {
        this.stato = new Iscrizione();
    }

    public boolean validateSottomissione(Sottomissione s) {
        return s != null && s.getMateriale() != null && !s.getMateriale().isBlank();
    }

    public void avanza(Hackathon h) {
        if (stato == null) {
            throw new IllegalStateException("Stato dell'hackathon non impostato");
        }
        stato.avanza(h);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public String getRegolamento() {
        return regolamento;
    }

    public void setRegolamento(String regolamento) {
        this.regolamento = regolamento;
    }

    public LocalDateTime getScadenzaIscrizioni() {
        return scadenzaIscrizioni;
    }

    public void setScadenzaIscrizioni(LocalDateTime scadenzaIscrizioni) {
        this.scadenzaIscrizioni = scadenzaIscrizioni;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public int getNumMaxTeam() {
        return numMaxTeam;
    }

    public void setNumMaxTeam(int numMaxTeam) {
        this.numMaxTeam = numMaxTeam;
    }

    public StatoHackathon getStato() {
        return stato;
    }

    public void setStato(StatoHackathon stato) {
        this.stato = stato;
    }
}
