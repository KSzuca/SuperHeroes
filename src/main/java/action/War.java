package action;

import lombok.Data;
import model.AbstractHero;
import model.Team;

@Data
public class War {

    private Team teamDC;
    private Team teamMarvel;

    public War(Team teamDC, Team teamMarvel) { }
    public Team startWar(Team team1, Team team2) {
        while (team1.isAnyHeroeStillAlive() && team2.isAnyHeroeStillAlive()) {
            AbstractHero hero1 = team1.getRandomAliveHero();
            AbstractHero hero2 = team2.getRandomAliveHero();
            
           duel(hero1, hero2);
        }
        return getWinnerTeam(team1, team2);
    }

    
    private void duel(AbstractHero hero1, AbstractHero hero2) {

        if (hero1.getPower() > hero2.getPower()) {
            System.out.println(hero1 + " won over " + hero2);
            hero2.killHero();
        } else if (hero1.getPower() < hero2.getPower()) {
            System.out.println(hero2 + " won over " + hero1);
            hero1.killHero();
        } else {
            System.out.println(hero1 + " and " + hero2 + " killed each other.");
            hero2.killHero();
            hero1.killHero();
        }
    }
    
    private Team getWinnerTeam(Team team1, Team team2) {
        if (team1.isAnyHeroeStillAlive()) {
            return team1;
        } else if (team2.isAnyHeroeStillAlive()) {
            return team2;
        } else {
            return null;
        }
    }
}
