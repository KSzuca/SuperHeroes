import action.War;
import exception.InvalidHeroTeamException;
import factory.HeroCreator;
import factory.SuperHeroCreator;
import factory.VillainCreator;
import model.*;
import util.AbstractHeroUtils;
import util.PropertiesLoader;


public class App {

    public static void main(String... args) throws InvalidHeroTeamException {

        PropertiesLoader.getInstance().loadProperties();

            HeroCreator creatorA = new SuperHeroCreator();
            VillainCreator creatorB = new VillainCreator();

            generateHero(creatorA);
            generateVillain(creatorB);
//            generateDefaultHero(creatorA);

        Team teamMarvel = new Team(TeamType.RED);
        teamMarvel.addHeroToTeam(new SuperHero(
                "IronMan",
                new HeroStatistics(120, 220, 100),
                TeamType.RED));
        teamMarvel.addHeroToTeam(new SuperHero(
                "BlackWidow",
                new HeroStatistics(30, 300, 90),
                TeamType.RED));


        Team teamDC = new Team(TeamType.BLUE);
        teamDC.addHeroToTeam(new SuperHero(
                "Superman",
                new HeroStatistics(1,23,45),
                TeamType.BLUE));
        teamDC.addHeroToTeam(new SuperHero(
                "Aquaman",
                new HeroStatistics(100, 45,221),
                TeamType.BLUE));

        War war = new War(teamMarvel, teamDC);
        System.out.println(war.startWar(teamDC, teamMarvel));

        AbstractHeroUtils.saveHerosToFile(teamMarvel.getHeroes(), "newFile.txt");
        AbstractHeroUtils.saveHerosToFile(teamDC.getHeroes(), "newFile1.txt");
        System.out.println(AbstractHeroUtils.readHeroesFromFile("newFile.txt"));
        System.out.println(AbstractHeroUtils.readHeroesFromFile("newFile1.txt"));

    }

    public static void generateHero(HeroCreator creator) {
        AbstractHero hero = creator
                .createSuperHero("andrzej", new HeroStatistics(1, 1, 6), TeamType.RED);
        System.out.println(hero);
    }

    public static void generateVillain(HeroCreator creator) {
        AbstractHero villain = creator
                .createSuperHero("andrzej", new HeroStatistics(1, 1, 6), TeamType.RED);
        System.out.println(villain);
    }


//    public static void generateDefaultHero(HeroCreator creator) {
//        AbstractHero hero = creator
//                .createSuperHeroWithDefaultStats("roman", TeamType.BLUE );
//        System.out.println(hero);
//    }

//    public static void generateDefaultVillain(HeroCreator creator) {
//        AbstractHero hero = creator
//                .createVillainWithDefaultStats("lolek", TeamType.GREEN );
//        System.out.println(hero);
//    }


}

