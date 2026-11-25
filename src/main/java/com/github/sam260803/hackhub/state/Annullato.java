package com.github.sam260803.hackhub.state;

public class Annullato implements StatoInvito {
    @Override
    public void accetta() {
        throw new IllegalStateException("Un invito annullato non può essere accettato");
    }

    @Override
    public void rifiuta() {
        throw new IllegalStateException("Un invito annullato non può essere rifiutato");
    }

    @Override
    public void annulla() {
        throw new IllegalStateException("L'invito è già stato annullato");
    }
}
