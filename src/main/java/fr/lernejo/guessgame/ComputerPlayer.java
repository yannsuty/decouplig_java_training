package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private Logger logger = LoggerFactory.getLogger("player");
    private int min;
    private int max;
    private int guess;

    public ComputerPlayer() {
        min=0;
        max=100;
    }
    @Override
    public long askNextGuess() {
        guess=min+((max-min)/2);
        logger.log("guess send: "+guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("greater");
            this.min=this.guess;
        } else {
            logger.log("lower");
            this.max=this.guess;
        }
    }
}
