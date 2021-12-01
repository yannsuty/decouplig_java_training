package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Simulation simulation;
        Logger log = LoggerFactory.getLogger("launcher");
        log.log("Start application");
        SecureRandom random = new SecureRandom();
        if (args.length==0) {
            System.out.println("Usage : [-interactive|-auto]");
        } else {
            switch (args[0]) {
                case "-interactive":
                    simulation = new Simulation(new HumanPlayer(),Long.MAX_VALUE);
                    simulation.initialize(random.nextInt(100));
                    simulation.loopUntilPlayerSucceed();
                    break;
                case "-auto":
                    simulation = new Simulation(new ComputerPlayer(),1000l);
                    simulation.initialize(Long.parseLong(args[1]));
                    simulation.loopUntilPlayerSucceed();
            }
        }
    }
}
