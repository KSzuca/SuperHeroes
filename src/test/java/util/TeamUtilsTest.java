package util;

import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testingutils.AbstractHeroDataBuilder;
import testingutils.TeamDataBuilder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamUtilsTest extends AbstractHeroDataBuilder {

    public Team weakTeam;
    public Team powerfulTeam;

//    @Test
//    public void shouldReturnTrueIfFirstTeamIsStronger() {
//
//        AbstractHero weakHero = new SuperHero(
//                "weak hero",
//                new HeroStatistics(1,1,1),
//                TeamType.RED);
//
//        AbstractHero powerfullHero = new SuperHero(
//                "powerful hero",
//                new HeroStatistics(100, 1000, 100),
//                TeamType.BLUE);
//
//        Team weakTeam = new Team(TeamType.RED);
//        Team powerfullTeam = new Team(TeamType.BLUE);
//
//        weakTeam.addHeroToTeam(weakHero);
//        powerfullTeam.addHeroToTeam(powerfullHero);
//
//        boolean result = TeamUtils.whichTeamIsBetter(powerfullTeam,weakTeam);
//        assertTrue(true);
//        //boolean result1 = TeamUtils.betterTeamBuffed(powerfulTeam, weakTeam);
//    }

//    @BeforeEach
//    public void setUp() {
//        AbstractHero weakHero = new SuperHero(
//                "weak hero",
//                new HeroStatistics(1,1,1),
//                TeamType.RED);
//        AbstractHero powerfulHero = new SuperHero(
//                "powerful hero",
//                new HeroStatistics(100, 1000, 100),
//                TeamType.BLUE);
//
//        weakTeam = new Team(TeamType.RED);
//        powerfulTeam = new Team(TeamType.BLUE);
//        weakTeam.addHeroToTeam(weakHero);
//        powerfulTeam.addHeroToTeam(powerfulHero);
//    }

    @BeforeEach
    public void setUp() {
        weakTeam = new TeamDataBuilder()
                .withWeakHeroes()
                .build();
        powerfulTeam = new TeamDataBuilder()
                .buildPowerfulTeam();
    }

    @Test
    public void shouldReturnTrueIfFirstTeamIsStronger() {
        //given
        //inicjowanie danych

        //when
        boolean result = TeamUtils.whichTeamIsBetter(powerfulTeam,weakTeam);

        //then
        assertTrue(result);
    }
//    @Test
//    public void shouldReturnTrueIfFirstTeamIsWeaker() {
//        boolean result = TeamUtils.betterTeamBuffed(weakTeam, powerfulTeam);
//        assertFalse(result);
//    }
}