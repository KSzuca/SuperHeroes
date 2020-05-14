package model;

import exception.InvalidHeroTeamException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
        this.heroes = new ArrayList<AbstractHero>();
        this.isTeamBuff =false;
        this.side = Side.UNKNOWN;
    }

//    public boolean addHeroToTeam(AbstractHero hero) throws InvalidHeroTeamException {
//        if (hero.getType().equals(this.type)) {
//            if (this.heroes.isEmpty()
//                    || this.teamLeader.getPower() < hero.getPower()) {
//                this.teamLeader = hero;
//            }
//
//            this.heroes.add(hero);
//            //this.checkSide();
//            this.checkSideUsingPower();
//            return true;
//        }
//        return false;
//    }

    public boolean addHeroToTeam(AbstractHero hero) throws InvalidHeroTeamException{
        if (hero.getType().equals(this.type)) {
            if (this.heroes.isEmpty()
                    || this.teamLeader.getPower() < hero.getPower()) {
                this.teamLeader = hero;
            }

            this.heroes.add(hero);
            //this.checkSide();
            this.checkSideUsingPower();
            return true;
        }
        throw new InvalidHeroTeamException(this, hero);
    }

    private void checkSide() {
      long superHeroesCount = getSuperHeroStream().count();

        long villainCount = this.heroes.size() - superHeroesCount;

      setTeamSide(superHeroesCount, villainCount);

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

    private void setTeamSide(long superHeroesValue, long villainValue) {
        if (superHeroesValue > villainValue) {
            this.side = Side.GOOD;
        } else if(superHeroesValue < villainValue) {
            this.side = Side.EVIL;
        }else {
            this.side = Side.UNKNOWN;
        }
    }

//    public AbstractHero getTeamLeader() {
//        Optional<AbstractHero> foundHero = this.heroes
//                .stream()
//                .sorted((hero1, hero2) -> {
//                    int hero1Power = hero1.getPower();
//                    int hero2Power = hero2.getPower();
//
//                    if (hero1Power < hero2Power) {
//                        return 1;
//                    } else if (hero1Power > hero2Power) {
//                        return -1;
//                    }
//                    return 0;
//                })
//                .findFirst();
//
//        return foundHero.orElse(null);
//    }

    public int getTeamPower() {
        return this.heroes
                .stream()
                .mapToInt(AbstractHero::getPower)
                .sum();
    }

    public void buffTeamPower() {
        if (!isTeamBuff) {
            this.isTeamBuff = true;

            getSuperHeroStream()
                    .forEach(hero -> hero.getStats().increaseDefense(10));

          getVillainStream()
                    .forEach(hero -> hero.getStats().increaseHealth(10));
          this.teamLeader = getTeamLeader();
        }
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

    private Stream<AbstractHero> getSuperHeroStream() {
        return this.heroes.stream()
                .filter(hero -> hero instanceof SuperHero);
    }

    private Stream<AbstractHero> getVillainStream() {
        return this.heroes.stream()
                .filter(hero -> hero instanceof Villain);
    }
}