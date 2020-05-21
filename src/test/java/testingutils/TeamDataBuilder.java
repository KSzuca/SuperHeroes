package testingutils;

import exception.InvalidHeroTeamException;
import model.AbstractHero;
import model.Team;
import model.TeamType;

import java.util.ArrayList;
import java.util.List;

public class TeamDataBuilder{

    private TeamType type;
    private List<AbstractHero> heroes;

    public TeamDataBuilder() {
        this.type = TeamType.BLUE;
        this.heroes = new ArrayList<>();
    }

    public TeamDataBuilder withHero(AbstractHero hero) {
        heroes.add(hero);
        return this;
    }

    public Team build() {
        Team team =  new Team(type);
        heroes.stream()
                .forEach(hero -> {
                    try {
                        team.addHeroToTeam(hero);
                    } catch (InvalidHeroTeamException e) {
                        e.printStackTrace();
                    }
                });
        return team;
    }


    public Team buildPowerfulTeam() {
        return this
                .withHero(new AbstractHeroDataBuilder()
                    .biuldPowerfulHero()
                    .withType(this.type)
                    .buildSuperHero())
                .build();
    }
}
