package com.github.sam260803.hackhub.repository;

import com.github.sam260803.hackhub.entity.Team;

public interface TeamRepository {
    Team getTeam(String nome);

    void salva(Team t);
}
