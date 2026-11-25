package com.github.sam260803.hackhub.state;

import com.github.sam260803.hackhub.entity.Invito;

public interface StatoInvito {
    void accetta();

    void rifiuta();

    void annulla();

    default void impostaContesto(Invito invito) {
    }
}
