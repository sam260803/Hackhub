package com.github.sam260803.hackhub.repository;

import com.github.sam260803.hackhub.entity.Invito;

public interface InvitoRepository {
    Invito getInvito(Invito i);

    void salva(Invito i);
}
