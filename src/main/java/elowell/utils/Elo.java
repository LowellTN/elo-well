package elowell.utils;

import elowell.player.Player;
import lombok.AllArgsConstructor;
import java.lang.Math;

@AllArgsConstructor
public class Elo {
    
    public double relativeStrength(Player player1, Player player2) {
        double p = 0;
        double elo1 = (double) player1.getRating();
        double elo2 = (double) player2.getRating();

        if(elo1 != 0 && elo2 != 0) {
            p = elo1 / (elo2 + elo1);
        } else {
            p = 0.5f;
        }
        return p/(1-p);
    }

    public double probaGain(Player player1, Player player2) {
        return relativeStrength(player1, player2) / (1 + relativeStrength(player2, player1));
    }

    public double Diff(Player player1, Player player2) {
        return 400*Math.log10(relativeStrength(player1, player2));
    }

    public double probaDiff(Player player1, Player player2) {
        return 1 / (1 + Math.pow(10,-Diff(player1, player2) / 400)); // FIXME: 400 should be a parameter
    }

    public void updateRating(Player player1, Player player2, double result) {
        player1.setRating((int) (player1.getRating() + player1.getK() * (result - probaDiff(player1, player2))));
        System.out.println(player1.getK() * (result - probaDiff(player1, player2)));
        player2.setRating((int) (player2.getRating() + player2.getK() * (1 - result - probaDiff(player2, player1))));
    }
}