package com.github.sam260803.hackhub.state;

import com.github.sam260803.hackhub.entity.Sottomissione;

public interface StatoSottomissione {
    void invia();

    default void impostaContesto(Sottomissione sottomissione) {
    }
}
