package model;

import exception.InvalidHeroTeamException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
@EqualsAndHashCode
@ToString

public class Team {

    @Getter
    private TeamType type;
    @Getter
    List<AbstractHero> heroes;
    @Getter
    AbstractHero teamLeader;

    private boolean isTeamBuff;
    Side side;


    public Team(TeamType type) {
        this.type = type;
        this.heroes = new ArrayList<>();
        this.isTeamBuff =false;
    }

    private void checkSideUsingPower() {
        int superHeroesPower = this.heroes.stream()
                .filter(hero -> hero instanceof SuperHero)
                .mapToInt(AbstractHero::getPower)
                .sum();

        int villainPower = this.heroes.stream()
                .filter(hero -> hero instanceof Villain)
                .mapToInt(AbstractHero::getPower)
                .sum();

       setTeamSide(superHeroesPower, villainPower);
    }

    public void setTeamSide(long superHeroesValue, long villainValue) {
        if (superHeroesValue > villainValue) {
            this.side = Side.GOOD;
        } else if(superHeroesValue < villainValue) {
            this.side = Side.EVIL;
        }else {
            this.side = Side.UNKNOWN;
        }
    }

    public int getTeamPower() {
        return this.heroes
                .stream()
                .mapToInt(AbstractHero::getPower)
                .sum();
    }

    public boolean isAnyHeroeStillAlive() {
        return this.heroes.stream()
                .anyMatch(AbstractHero::isAlive);
    }

    public AbstractHero getRandomAliveHero() {
        List<AbstractHero> aliveHeros = this.heroes.stream()
                .filter(AbstractHero::isAlive)
                .collect(Collectors.toList());

        Random random = new Random();
        int randomNumber = random.nextInt(aliveHeros.size());

        return aliveHeros.get(randomNumber);
    }

    public boolean addHeroToTeam(AbstractHero hero) throws InvalidHeroTeamException {
        if (hero.getType().equals(this.type)) {
            if (this.heroes.isEmpty()
                    || this.teamLeader.getPower() < hero.getPower()) {
                this.teamLeader = hero;
            }

            this.heroes.add(hero);
            this.checkSideUsingPower();
            return true;
        }
        throw new InvalidHeroTeamException(this, hero);
    }
}