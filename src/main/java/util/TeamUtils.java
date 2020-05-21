package util;

import lombok.Data;
import lombok.Getter;
import model.Team;

@Getter
@Data
public class TeamUtils {

    public static boolean whichTeamIsBetter(Team team1, Team team2) {
        System.out.print("Czy drużyna " + team1.getType() + " jest lepsza od drużyny " + team2.getType() + "? ");
        return team1.getTeamPower() > team2.getTeamPower();
    }
}

