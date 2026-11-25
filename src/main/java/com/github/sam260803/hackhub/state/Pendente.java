package com.github.sam260803.hackhub.state;

import com.github.sam260803.hackhub.entity.Invito;

public class Pendente implements StatoInvito {
    private Invito invito;

    @Override
    public void impostaContesto(Invito invito) {
        this.invito = invito;
    }

    @Override
    public void accetta() {
        Invito corrente = verificaContesto();
        corrente.setStato(new Accettato());
    }

    @Override
    public void rifiuta() {
        Invito corrente = verificaContesto();
        corrente.setStato(new Rifiutato());
    }

    @Override
    public void annulla() {
        Invito corrente = verificaContesto();
        corrente.setStato(new Annullato());
    }

    private Invito verificaContesto() {
        if (invito == null) {
            throw new IllegalStateException("Stato non collegato a un invito");
        }
        return invito;
    }
}
