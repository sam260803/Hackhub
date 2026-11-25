package com.github.sam260803.hackhub.state;

import com.github.sam260803.hackhub.entity.Hackathon;

public class Concluso implements StatoHackathon {
    @Override
    public void avanza(Hackathon hackathon) {
        throw new IllegalStateException("L'hackathon è concluso: nessuna ulteriore transizione è prevista");
    }
}
