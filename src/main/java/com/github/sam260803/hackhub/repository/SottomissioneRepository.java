package com.github.sam260803.hackhub.repository;

import com.github.sam260803.hackhub.entity.Sottomissione;

public interface SottomissioneRepository {
    Sottomissione getSottomissione(int id);

    void salva(Sottomissione s);
}
