package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    private final long MAX_TOUR;
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;
    private int counter;

    public Simulation(Player player, long max_tour) {
        this.player=player;
        this.counter =0;
        this.MAX_TOUR=max_tour;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess=numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        logger.log("Guess receive :" + guess);
        if (guess>numberToGuess) {
            player.respond(false);
        } else if (guess<numberToGuess){
            player.respond(true);
        }
        return numberToGuess == guess;
    }

    public void loopUntilPlayerSucceed() {
        long start = System.currentTimeMillis();
        boolean stop;
        do {
            logger.log("New round :"+counter);
            stop = nextRound();
            logger.log(!stop?"Next round:":"");
            counter++;
        } while (!stop&& counter <MAX_TOUR);
        long end = System.currentTimeMillis();
        logger.log("Time spent :" + (new SimpleDateFormat("mm:ss.SS").format(new Date(end-start))));
        if (stop) {
            logger.log("Well done little pirate!");
        } else if(counter==MAX_TOUR || !stop) {
            logger.log("You didn't found my age!");
        }
    }
}
