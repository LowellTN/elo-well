package elowell.player;

import elowell.club.Club;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    // private Club club;
    private int rating;
    private int K;
}