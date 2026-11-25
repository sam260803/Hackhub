package com.github.sam260803.hackhub.state;

import com.github.sam260803.hackhub.entity.Sottomissione;

public class Bozza implements StatoSottomissione {
    private Sottomissione sottomissione;

    @Override
    public void impostaContesto(Sottomissione sottomissione) {
        this.sottomissione = sottomissione;
    }

    @Override
    public void invia() {
        if (sottomissione == null) {
            throw new IllegalStateException("Stato non collegato a una sottomissione");
        }
        sottomissione.setStato(new Inviata());
    }
}
