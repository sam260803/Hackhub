package com.github.sam260803.hackhub.service;

import com.github.sam260803.hackhub.entity.Invito;
import com.github.sam260803.hackhub.entity.Team;
import com.github.sam260803.hackhub.entity.Utente;
import com.github.sam260803.hackhub.repository.InvitoRepository;
import com.github.sam260803.hackhub.repository.TeamRepository;
import com.github.sam260803.hackhub.repository.UtenteRepository;
import com.github.sam260803.hackhub.state.Pendente;
import java.util.ArrayList;

/**
 * Gestore del caso d'uso "Accetta Invito".
 */
public class GestoreAccettaInvito {
    private final InvitoRepository invitoRepository;
    private final UtenteRepository utenteRepository;
    private final TeamRepository teamRepository;

    public GestoreAccettaInvito(InvitoRepository invitoRepository,
                                UtenteRepository utenteRepository,
                                TeamRepository teamRepository) {
        this.invitoRepository = invitoRepository;
        this.utenteRepository = utenteRepository;
        this.teamRepository = teamRepository;
    }

    /**
     * Accetta l'invito indicato, aggiunge l'utente al team e rifiuta gli altri inviti pendenti.
     */
    public void accettaInvito(Invito invito) {
        if (invito == null) {
            throw new IllegalArgumentException("Invito mancante");
        }

        Invito corrente = invitoRepository.getInvito(invito);
        if (corrente == null) {
            throw new IllegalArgumentException("Invito inesistente");
        }

        // L'invito deve essere ancora PENDENTE.
        if (!(corrente.getStato() instanceof Pendente)) {
            throw new IllegalStateException("L'invito non è più pendente");
        }

        Utente perUtente = corrente.getPerUtente();
        if (perUtente == null) {
            throw new IllegalStateException("Destinatario dell'invito mancante");
        }
        Utente utente = utenteRepository.getUser(perUtente.getId());
        if (utente == null) {
            throw new IllegalArgumentException("Utente inesistente");
        }

        // L'utente non deve essere entrato nel frattempo in un altro team.
        if (utente.getTeam() != null) {
            throw new IllegalStateException("L'utente appartiene già a un team");
        }

        Team team = corrente.getDalTeam();
        if (team == null) {
            throw new IllegalStateException("Team dell'invito mancante");
        }

        // L'utente entra nel team che ha inviato l'invito.
        utente.setTeam(team);
        if (team.getMembri() == null) {
            team.setMembri(new ArrayList<>());
        }
        if (!team.getMembri().contains(utente)) {
            team.getMembri().add(utente);
        }
        teamRepository.salva(team);

        // L'invito passa allo stato ACCETTATO tramite lo State pattern.
        corrente.getStato().accetta();
        invitoRepository.salva(corrente);

        // Gli altri inviti pendenti dell'utente vengono rifiutati.
        rejectInvites(utente, corrente);
    }

    private void rejectInvites(Utente utente, Invito accettato) {
        if (utente.getInviti() == null) {
            return;
        }
        for (Invito invito : utente.getInviti()) {
            if (invito != accettato && invito.getStato() instanceof Pendente) {
                invito.getStato().rifiuta();
                invitoRepository.salva(invito);
            }
        }
    }
}
