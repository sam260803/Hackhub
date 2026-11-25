package com.github.sam260803.hackhub.builder;

import com.github.sam260803.hackhub.entity.Hackathon;
import com.github.sam260803.hackhub.entity.Sottomissione;
import com.github.sam260803.hackhub.entity.Team;
import com.github.sam260803.hackhub.entity.Utente;
import com.github.sam260803.hackhub.state.StatoSottomissione;
import java.time.LocalDateTime;

public class SottomissioneBuilder {
    private final Sottomissione sottomissione;

    public SottomissioneBuilder() {
        this.sottomissione = new Sottomissione();
    }

    public SottomissioneBuilder materiale(String m) {
        sottomissione.setMateriale(m);
        return this;
    }

    public SottomissioneBuilder dataCaricamento(LocalDateTime d) {
        sottomissione.setDataCaricamento(d);
        return this;
    }

    public SottomissioneBuilder dataInvio(LocalDateTime d) {
        sottomissione.setDataInvio(d);
        return this;
    }

    public SottomissioneBuilder stato(StatoSottomissione s) {
        sottomissione.setStato(s);
        return this;
    }

    public SottomissioneBuilder autore(Utente u) {
        sottomissione.setAutore(u);
        return this;
    }

    public SottomissioneBuilder team(Team t) {
        sottomissione.setTeam(t);
        return this;
    }

    public SottomissioneBuilder hackathon(Hackathon h) {
        sottomissione.setHackathon(h);
        return this;
    }

    public Sottomissione build() {
        return sottomissione;
    }
}
