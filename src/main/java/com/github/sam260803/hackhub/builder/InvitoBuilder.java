package com.github.sam260803.hackhub.builder;

import com.github.sam260803.hackhub.entity.Invito;
import com.github.sam260803.hackhub.entity.Team;
import com.github.sam260803.hackhub.entity.Utente;
import com.github.sam260803.hackhub.state.StatoInvito;
import java.time.LocalDateTime;

public class InvitoBuilder {
    private final Invito invito;

    public InvitoBuilder() {
        this.invito = new Invito();
    }

    public InvitoBuilder dataInvito(LocalDateTime d) {
        invito.setDataInvito(d);
        return this;
    }

    public InvitoBuilder stato(StatoInvito s) {
        invito.setStato(s);
        return this;
    }

    public InvitoBuilder perUtente(Utente u) {
        invito.setPerUtente(u);
        return this;
    }

    public InvitoBuilder daUtente(Utente u) {
        invito.setDaUtente(u);
        return this;
    }

    public InvitoBuilder daTeam(Team t) {
        invito.setDalTeam(t);
        return this;
    }

    public Invito build() {
        return invito;
    }
}
