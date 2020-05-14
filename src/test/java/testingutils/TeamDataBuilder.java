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

    public TeamDataBuilder withType(TeamType type) {
        this.type = type;
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

    public TeamDataBuilder withWeakHeroes() {
        return this
                .withHero(new AbstractHeroDataBuilder()
                    .buildWeakHero()
                    .withType(this.type)
                    .buildSuperHero());
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
