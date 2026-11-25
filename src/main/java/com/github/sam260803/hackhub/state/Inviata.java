package com.github.sam260803.hackhub.state;

public class Inviata implements StatoSottomissione {
    @Override
    public void invia() {
        throw new IllegalStateException("La sottomissione è già stata inviata");
    }
}
