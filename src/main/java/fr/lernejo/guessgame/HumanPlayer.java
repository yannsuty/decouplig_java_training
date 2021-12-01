package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private Logger logger = LoggerFactory.getLogger("player");
    private Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        logger.log("Write a number:");
        long guess = scanner.nextLong();
        logger.log("Guess send :"+ guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("The number is greater");
        } else {
            logger.log("The number is lower.");
        }
    }
}
