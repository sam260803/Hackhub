package com.github.sam260803.hackhub.state;

public class Accettato implements StatoInvito {
    @Override
    public void accetta() {
        throw new IllegalStateException("L'invito è già stato accettato");
    }

    @Override
    public void rifiuta() {
        throw new IllegalStateException("Un invito già accettato non può essere rifiutato");
    }

    @Override
    public void annulla() {
        throw new IllegalStateException("Un invito già accettato non può essere annullato");
    }
}
