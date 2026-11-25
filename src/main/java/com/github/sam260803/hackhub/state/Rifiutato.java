package com.github.sam260803.hackhub.state;

public class Rifiutato implements StatoInvito {
    @Override
    public void accetta() {
        throw new IllegalStateException("Un invito rifiutato non può essere accettato");
    }

    @Override
    public void rifiuta() {
        throw new IllegalStateException("L'invito è già stato rifiutato");
    }

    @Override
    public void annulla() {
        throw new IllegalStateException("Un invito già rifiutato non può essere annullato");
    }
}
