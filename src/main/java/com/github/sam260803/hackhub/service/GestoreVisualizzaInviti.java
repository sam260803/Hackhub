package com.github.sam260803.hackhub.service;

import com.github.sam260803.hackhub.entity.Invito;
import com.github.sam260803.hackhub.entity.Utente;
import com.github.sam260803.hackhub.repository.UtenteRepository;
import com.github.sam260803.hackhub.state.Pendente;
import java.util.List;

/**
 * Gestore del caso d'uso "Visualizza Inviti".
 */
public class GestoreVisualizzaInviti {
    private final UtenteRepository utenteRepository;

    public GestoreVisualizzaInviti(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    /**
     * Restituisce gli inviti in stato PENDENTE destinati all'utente indicato.
     */
    public List<Invito> visualizzaInviti(Utente utente) {
        if (utente == null) {
            throw new IllegalArgumentException("Utente mancante");
        }

        List<Invito> inviti = utenteRepository.getInviti(utente, new Pendente());

        // Nessun invito: la boundary mostrerà "nessun invito ricevuto".
        if (inviti == null) {
            return List.of();
        }
        return inviti;
    }
}
