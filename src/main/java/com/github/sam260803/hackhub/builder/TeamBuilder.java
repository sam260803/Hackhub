package com.github.sam260803.hackhub.builder;

import com.github.sam260803.hackhub.entity.Hackathon;
import com.github.sam260803.hackhub.entity.Invito;
import com.github.sam260803.hackhub.entity.Sottomissione;
import com.github.sam260803.hackhub.entity.Team;
import com.github.sam260803.hackhub.entity.Utente;
import java.time.LocalDateTime;
import java.util.List;

public class TeamBuilder {
    private final Team team;

    public TeamBuilder() {
        this.team = new Team();
    }

    public TeamBuilder nome(String n) {
        team.setNome(n);
        return this;
    }

    public TeamBuilder creatore(Utente u) {
        team.setCreatore(u);
        return this;
    }

    public TeamBuilder dataCreazione(LocalDateTime d) {
        team.setDataCreazione(d);
        return this;
    }

    public TeamBuilder membri(List<Utente> m) {
        team.setMembri(m);
        return this;
    }

    public TeamBuilder inviti(List<Invito> i) {
        team.setInviti(i);
        return this;
    }

    public TeamBuilder sottomissioni(List<Sottomissione> s) {
        team.setSottomissioni(s);
        return this;
    }

    public TeamBuilder hackathons(List<Hackathon> h) {
        team.setHackathons(h);
        return this;
    }

    public Team build() {
        return team;
    }
}
