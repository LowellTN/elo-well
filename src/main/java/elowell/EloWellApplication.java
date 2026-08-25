package elowell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import elowell.player.Player;
import elowell.utils.Elo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SpringBootApplication
public class EloWellApplication {
    private static final Logger log = LogManager.getLogger(EloWellApplication.class);
    private static final Elo elo = new Elo();
    public static void main(String[] args) {
        SpringApplication.run(EloWellApplication.class, args);
        Player p1 = new Player("Player 1", 1500, 40);
        Player p2 = new Player("Player 2", 1600, 40);
        
        log.info("=== Before Match ===");
        log.info("Elo {} rating = {}", p1.getName(), p1.getRating());
        log.info("Elo {} rating = {}", p2.getName(), p2.getRating());

        elo.updateRating(p1, p2, 1);

        log.info("=== After Match ===");
        log.info("Elo {} rating = {}", p1.getName(), p1.getRating());
        log.info("Elo {} rating = {}", p2.getName(), p2.getRating());

    }
}
