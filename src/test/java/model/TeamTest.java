package model;

import exception.InvalidHeroTeamException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//UNIT TEST - test jednostkowy
class TeamTest {

    @Test
    public void shouldReturnTrueIfHeroHasTheSameTypeAsTeam() throws InvalidHeroTeamException {
        //1.inicjacja danych testowych
        SuperHero hero = new SuperHero(
                "hero",
                new HeroStatistics(1,2,3),
                TeamType.BLUE);

        Team team =  new Team(TeamType.BLUE);

        //2. wywołanie metody, którą chcemy przetestować
        boolean result = team.addHeroToTeam(hero);

        //3. sprawdzenie wyniku
        assertTrue(result);
        assertTrue(team.getHeroes().contains(hero));
    }

    @Test
    public void shouldReturnFalseIfHeroHasDifferentTypeThanTeam(){
        SuperHero hero = new SuperHero(
                "hero",
                new HeroStatistics(1,2,3),
                TeamType.RED);

        Team team =  new Team(TeamType.BLUE);

        assertThrows(InvalidHeroTeamException.class, () -> team.addHeroToTeam(hero));
        assertFalse(team.getHeroes().contains(hero));
    }

    @Test
    public void shouldReturnMostPowerfulHeroAsTeamLeader() throws InvalidHeroTeamException {
        SuperHero weakHero = new SuperHero(
                "hero1",
                new HeroStatistics(1,1,1),
                TeamType.RED);

        SuperHero powerfulHero = new SuperHero(
                "hero2",
                new HeroStatistics(10,20,30),
                TeamType.RED);

        Team team = new Team(TeamType.RED);

        team.addHeroToTeam(powerfulHero);
        team.addHeroToTeam(weakHero);


        AbstractHero teamLeader = team.getTeamLeader();

        assertEquals(powerfulHero, teamLeader);
    }

    @Test
    public void shouldBuffedTeamOnlyOnce() throws InvalidHeroTeamException {

        SuperHero superHero = new SuperHero(
                "hero1",
                new HeroStatistics(1,1,1),
                TeamType.RED);

        SuperHero villain = new SuperHero(
                "hero2",
                new HeroStatistics(100,20,30),
                TeamType.RED);

        Team team = new Team(TeamType.RED);

        team.addHeroToTeam(superHero);
        team.addHeroToTeam(villain);

        team.buffTeamPower();
        team.buffTeamPower();

        assertEquals(11, superHero.getStats().getDefense());
        assertEquals(150, villain.getStats().getHealth());
    }
}