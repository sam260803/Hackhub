package com.github.sam260803.hackhub.state;

import com.github.sam260803.hackhub.entity.Hackathon;

public class InValutazione implements StatoHackathon {
    @Override
    public void avanza(Hackathon hackathon) {
        if (hackathon == null) {
            throw new IllegalArgumentException("L'hackathon non può essere null");
        }
        hackathon.setStato(new Concluso());
    }
}
