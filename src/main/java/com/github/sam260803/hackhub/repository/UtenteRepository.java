package com.github.sam260803.hackhub.repository;

import com.github.sam260803.hackhub.entity.Invito;
import com.github.sam260803.hackhub.entity.Team;
import com.github.sam260803.hackhub.entity.Utente;
import com.github.sam260803.hackhub.state.StatoInvito;
import java.util.List;

public interface UtenteRepository {
    Utente getUser(int id);

    Team getTeam(int id);

    Team getUserTeam(int id);

    List<Invito> getInviti(Utente utente, StatoInvito stato);
}
