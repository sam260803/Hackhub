package com.github.sam260803.hackhub.service;

import com.github.sam260803.hackhub.builder.InvitoBuilder;
import com.github.sam260803.hackhub.builder.TeamBuilder;
import com.github.sam260803.hackhub.entity.Invito;
import com.github.sam260803.hackhub.entity.Team;
import com.github.sam260803.hackhub.entity.Utente;
import com.github.sam260803.hackhub.repository.InvitoRepository;
import com.github.sam260803.hackhub.repository.TeamRepository;
import com.github.sam260803.hackhub.repository.UtenteRepository;
import com.github.sam260803.hackhub.state.Pendente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestore del caso d'uso "Crea Team".
 */
public class GestoreCreaTeam {
    private final TeamRepository teamRepository;
    private final UtenteRepository utenteRepository;
    private final InvitoRepository invitoRepository;

    public GestoreCreaTeam(TeamRepository teamRepository,
                           UtenteRepository utenteRepository,
                           InvitoRepository invitoRepository) {
        this.teamRepository = teamRepository;
        this.utenteRepository = utenteRepository;
        this.invitoRepository = invitoRepository;
    }

    /**
     * Crea il team, registra il creatore come primo membro e invia gli inviti.
     */
    public void creaTeam(TeamBuilder data) {
        if (data == null) {
            throw new IllegalArgumentException("Dati del team mancanti");
        }

        Team team = data.build();
        Utente creatore = team.getCreatore();
        if (team.getNome() == null || team.getNome().isBlank()) {
            throw new IllegalArgumentException("Il nome del team è obbligatorio");
        }
        if (creatore == null) {
            throw new IllegalArgumentException("Il creatore del team è obbligatorio");
        }

        // Il nome del team deve essere disponibile.
        if (teamRepository.getTeam(team.getNome()) != null) {
            throw new IllegalArgumentException("Il nome del team è già in uso");
        }

        // Il creatore non deve appartenere a un altro team.
        if (utenteRepository.getUserTeam(creatore.getId()) != null) {
            throw new IllegalArgumentException("L'utente appartiene già a un team");
        }

        // Gli utenti selezionati devono esistere; il creatore non viene invitato.
        List<Utente> invitati = new ArrayList<>();
        for (Utente selezionato : membriSelezionati(team)) {
            Utente invitato = utenteRepository.getUser(selezionato.getId());
            if (invitato == null) {
                throw new IllegalArgumentException("Utente invitato inesistente");
            }
            if (invitato.getId() != creatore.getId()) {
                invitati.add(invitato);
            }
        }

        // Il creatore è il primo (e unico) membro del nuovo team.
        team.setMembri(new ArrayList<>(List.of(creatore)));
        teamRepository.salva(team);
        creatore.setTeam(team);

        // Un invito in stato PENDENTE per ciascun utente selezionato.
        for (Utente invitato : invitati) {
            Invito invito = new InvitoBuilder()
                    .dataInvito(LocalDateTime.now())
                    .stato(new Pendente())
                    .perUtente(invitato)
                    .daUtente(creatore)
                    .daTeam(team)
                    .build();
            invitoRepository.salva(invito);
            clearInvites(creatore);
        }
    }

    /**
     * Annulla gli inviti ancora pendenti destinati all'utente indicato.
     */
    public void clearInvites(Utente u) {
        if (u == null || u.getInviti() == null) {
            return;
        }
        for (Invito invito : u.getInviti()) {
            if (invito.getStato() instanceof Pendente) {
                invito.getStato().annulla();
                invitoRepository.salva(invito);
            }
        }
    }

    // Utenti selezionati nel form, usati come destinatari degli inviti.
    private List<Utente> membriSelezionati(Team team) {
        return team.getMembri() == null ? List.of() : team.getMembri();
    }
}
