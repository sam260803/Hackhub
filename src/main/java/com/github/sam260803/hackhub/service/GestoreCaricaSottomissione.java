package com.github.sam260803.hackhub.service;

import com.github.sam260803.hackhub.builder.SottomissioneBuilder;
import com.github.sam260803.hackhub.entity.Hackathon;
import com.github.sam260803.hackhub.entity.Sottomissione;
import com.github.sam260803.hackhub.repository.HackathonRepository;
import com.github.sam260803.hackhub.repository.SottomissioneRepository;
import com.github.sam260803.hackhub.state.Bozza;
import com.github.sam260803.hackhub.state.InCorso;
import java.time.LocalDateTime;

/**
 * Gestore del caso d'uso "Carica Sottomissione".
 */
public class GestoreCaricaSottomissione {
    private final SottomissioneRepository sottomissioneRepository;
    private final HackathonRepository hackathonRepository;

    public GestoreCaricaSottomissione(SottomissioneRepository sottomissioneRepository,
                                      HackathonRepository hackathonRepository) {
        this.sottomissioneRepository = sottomissioneRepository;
        this.hackathonRepository = hackathonRepository;
    }

    /**
     * Carica (o sovrascrive) la sottomissione in stato BOZZA per l'hackathon indicato.
     */
    public void caricaSottomissione(SottomissioneBuilder data) {
        if (data == null) {
            throw new IllegalArgumentException("Dati della sottomissione mancanti");
        }

        Sottomissione bozza = data.build();
        if (bozza.getHackathon() == null) {
            throw new IllegalArgumentException("Hackathon della sottomissione mancante");
        }

        Hackathon hackathon = hackathonRepository.getHackathon(bozza.getHackathon());
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon inesistente");
        }

        // Solo un hackathon IN CORSO accetta caricamenti.
        if (!(hackathon.getStato() instanceof InCorso)) {
            throw new IllegalStateException("L'hackathon non è in corso: caricamento non consentito");
        }

        // Il file deve rispettare formato e dimensione richiesti.
        if (!validaSottomissione(bozza)) {
            throw new IllegalArgumentException("La sottomissione non rispetta formato o dimensione");
        }

        // La sottomissione caricata è sempre una BOZZA.
        Sottomissione sottomissione = new SottomissioneBuilder()
                .materiale(bozza.getMateriale())
                .dataCaricamento(bozza.getDataCaricamento() != null
                        ? bozza.getDataCaricamento()
                        : LocalDateTime.now())
                .stato(new Bozza())
                .autore(bozza.getAutore())
                .team(bozza.getTeam())
                .hackathon(hackathon)
                .build();

        sottomissioneRepository.salva(sottomissione);
    }

    /**
     * Verifica che la sottomissione contenga un materiale valido.
     */
    public boolean validaSottomissione(Sottomissione s) {
        return s != null && s.getMateriale() != null && !s.getMateriale().isBlank();
    }
}
