package com.github.sam260803.hackhub.service;

import com.github.sam260803.hackhub.entity.Hackathon;
import com.github.sam260803.hackhub.entity.Sottomissione;
import com.github.sam260803.hackhub.entity.Team;
import com.github.sam260803.hackhub.repository.HackathonRepository;
import com.github.sam260803.hackhub.repository.SottomissioneRepository;
import com.github.sam260803.hackhub.repository.TeamRepository;
import com.github.sam260803.hackhub.state.InCorso;
import com.github.sam260803.hackhub.state.StatoHackathon;
import java.time.LocalDateTime;

/**
 * Gestore del caso d'uso "Invia Sottomissione".
 */
public class GestoreInviaSottomissione {
    private final SottomissioneRepository sottomissioneRepository;
    private final HackathonRepository hackathonRepository;
    private final TeamRepository teamRepository;

    public GestoreInviaSottomissione(SottomissioneRepository sottomissioneRepository,
                                     HackathonRepository hackathonRepository,
                                     TeamRepository teamRepository) {
        this.sottomissioneRepository = sottomissioneRepository;
        this.hackathonRepository = hackathonRepository;
        this.teamRepository = teamRepository;
    }

    /**
     * Invia la sottomissione indicata, registrando data/ora di invio.
     */
    public void inviaSottomissione(Sottomissione data) {
        if (data == null) {
            throw new IllegalArgumentException("Dati della sottomissione mancanti");
        }
        if (data.getHackathon() == null) {
            throw new IllegalArgumentException("Hackathon della sottomissione mancante");
        }
        if (data.getTeam() == null) {
            throw new IllegalArgumentException("Team della sottomissione mancante");
        }

        Hackathon hackathon = hackathonRepository.getHackathon(data.getHackathon());
        if (hackathon == null) {
            throw new IllegalArgumentException("Hackathon inesistente");
        }
        StatoHackathon stato = hackathon.getStato();

        Team team = teamRepository.getTeam(data.getTeam().getNome());
        if (team == null) {
            throw new IllegalArgumentException("Team inesistente");
        }

        Sottomissione sottomissione = sottomissioneRepository.getSottomissione(data.getId());

        // L'invio è consentito solo se l'hackathon è IN CORSO.
        if (!(stato instanceof InCorso)) {
            throw new IllegalStateException("L'hackathon non è in corso: invio non consentito");
        }

        // Nessuna bozza presente: occorre prima caricare una sottomissione.
        if (sottomissione == null) {
            throw new IllegalArgumentException("Nessuna bozza presente: eseguire prima Carica Sottomissione");
        }

        // Registra data/ora di invio e passa la sottomissione allo stato INVIATA.
        sottomissione.setDataInvio(LocalDateTime.now());
        sottomissione.getStato().invia();
        sottomissioneRepository.salva(sottomissione);
    }
}
