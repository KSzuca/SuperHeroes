package util;

import lombok.Data;
import lombok.Getter;
import model.Team;

@Getter
@Data
public class TeamUtils {

    public static boolean whichTeamIsBetter(Team team1, Team team2) {

        if (team1.getTeamPower() > team2.getTeamPower()) {
            return true;
        }
        return false;
    }


    public static boolean betterTeamBuffed(Team team1, Team team2) {
        team1.buffTeamPower();
        team2.buffTeamPower();

        return whichTeamIsBetter(team1, team2);
    }
}

