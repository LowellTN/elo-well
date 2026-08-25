package elowell.elo;

import elowell.player.Player;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class RatingCalculator {
    private Player player1;
    private Player player2;
}