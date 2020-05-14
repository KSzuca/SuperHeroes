import action.War;
import exception.InvalidHeroTeamException;
import model.*;
import util.AbstractHeroUtils;
import util.PropertiesLoader;


public class App {

    public static void main(String... args) throws InvalidHeroTeamException {

        PropertiesLoader.getInstance().loadProperties();

//            HeroCreator creatorA = new SuperHeroCreator();
//            VillainCreator creatorB = new VillainCreator();
//
//            generateHero(creatorA);
//            generateVillain(creatorB);
//            generateDefaultHero(creatorA);

        Team teamMarvel = new Team(TeamType.RED);
        teamMarvel.addHeroToTeam(new SuperHero(
                "IronMan",
                new HeroStatistics(400, 220, 100),
                TeamType.RED));
        teamMarvel.addHeroToTeam(new SuperHero(
                "Black Widow",
                new HeroStatistics(300, 300, 150),
                TeamType.RED));
        teamMarvel.addHeroToTeam(new SuperHero(
                "Hulk",
                new HeroStatistics(1200,3000,3000),
                TeamType.RED));
        teamMarvel.addHeroToTeam(new SuperHero(
                "Capitan America",
                new HeroStatistics(600,500,700),
                TeamType.RED));
        teamMarvel.addHeroToTeam(new SuperHero(
                "Hulk",
                new HeroStatistics(1200,3000,3000),
                TeamType.RED));teamMarvel.addHeroToTeam(new SuperHero(
                "Thor",
                new HeroStatistics(600,500,800),
                TeamType.RED));


        Team teamDC = new Team(TeamType.BLUE);
        teamDC.addHeroToTeam(new SuperHero(
                "Superman",
                new HeroStatistics(300,230,400),
                TeamType.BLUE));
        teamDC.addHeroToTeam(new SuperHero(
                "Aquaman",
                new HeroStatistics(100, 100,250),
                TeamType.BLUE));
        teamDC.addHeroToTeam(new SuperHero(
                "Batman",
                new HeroStatistics(200, 400,500),
                TeamType.BLUE));
        teamDC.addHeroToTeam(new SuperHero(
                "Wonder Woman",
                new HeroStatistics(150, 400,300),
                TeamType.BLUE));
        teamDC.addHeroToTeam(new SuperHero(
                "Flash",
                new HeroStatistics(500, 600,200),
                TeamType.BLUE));
        teamDC.addHeroToTeam(new SuperHero(
                "Green Lantern",
                new HeroStatistics(100, 50,300),
                TeamType.BLUE));

        War war = new War(teamMarvel, teamDC);
        System.out.println(war.startWar(teamDC, teamMarvel));


        AbstractHeroUtils.saveHerosToFile(teamMarvel.getHeroes(), "newFile.txt");
        AbstractHeroUtils.saveHerosToFile(teamDC.getHeroes(), "newFile1.txt");
        System.out.println(AbstractHeroUtils.readHeroesFromFile("newFile.txt"));
        System.out.println(AbstractHeroUtils.readHeroesFromFile("newFile1.txt"));

        System.out.print("żyje ktoś z dc?");
        System.out.println(teamDC.isAnyHeroeStillAlive());
        System.out.print("żyje ktoś z marvela?");
        System.out.println(teamMarvel.isAnyHeroeStillAlive());

        System.out.print("lider dc:");
        System.out.println(teamDC.getTeamLeader());
        System.out.print("lider marvela:");
        System.out.println(teamMarvel.getTeamLeader());

        System.out.println(teamMarvel.getRandomAliveHero());
    }

//    public static void generateHero(HeroCreator creator) {
//        AbstractHero hero = creator
//                .createSuperHero("andrzej", new HeroStatistics(1, 1, 6), TeamType.RED);
//        System.out.println(hero);
//    }
//
//    public static void generateVillain(HeroCreator creator) {
//        AbstractHero villain = creator
//                .createSuperHero("andrzej", new HeroStatistics(1, 1, 6), TeamType.RED);
//        System.out.println(villain);
//    }


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

