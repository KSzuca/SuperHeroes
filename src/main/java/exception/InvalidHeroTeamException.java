package exception;

import model.AbstractHero;
import model.Team;

public class InvalidHeroTeamException extends Exception {


    public InvalidHeroTeamException(String message) {
        super (message);
    }

    public InvalidHeroTeamException(Team team, AbstractHero hero) {
        super("Different team types encountered while adding hero with type " + hero.getType()
        + " to team with type " + team.getType());
    }
}
