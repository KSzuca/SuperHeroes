import action.War;
import exception.InvalidHeroTeamException;
import factory.HeroCreator;
import factory.SuperHeroCreator;
import factory.VillainCreator;
import model.*;
import util.AbstractHeroUtils;
import util.PropertiesLoader;
import util.TeamUtils;


public class App {

    public static void main(String... args) throws InvalidHeroTeamException {

        PropertiesLoader.getInstance().loadProperties();
        System.out.println("Bohaterowie pojedynczy: creatorA z defaultowymi właściwościami, creatorB z wpisanymi bezpośrednio do kodu:");
            HeroCreator creatorA = new SuperHeroCreator();
            VillainCreator creatorB = new VillainCreator();
            generateDefaultHero(creatorA);
            generateVillain(creatorB);



        System.out.println();
        System.out.println();
        System.out.println("Wojna DC kontra Marvel: ");

        Team teamMarvel = new Team(TeamType.RED);
        teamMarvel.addHeroToTeam(new SuperHero(
                "IronMan",
                new HeroStatistics(400, 270, 100),
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
                new HeroStatistics(450,220,100),
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

        System.out.print("Żyje ktoś z DC? ");
        System.out.println(teamDC.isAnyHeroeStillAlive());
        System.out.print("Żyje ktoś z Marvela? ");
        System.out.println(teamMarvel.isAnyHeroeStillAlive());

        System.out.print("Lider DC: ");
        System.out.println(teamDC.getTeamLeader());
        System.out.print("Lider Marvela: ");
        System.out.println(teamMarvel.getTeamLeader());

        System.out.print("Siła DC: ");
        System.out.println(teamDC.getTeamPower());
        System.out.print("Siła Marvel: ");
        System.out.println(teamMarvel.getTeamPower());
        System.out.print(TeamUtils.whichTeamIsBetter(teamDC, teamMarvel));
    }



    public static void generateDefaultHero(HeroCreator creatorA) {
        AbstractHero hero = creatorA
                .createSuperHeroWithDefaultStats("Magneto", TeamType.BLUE );
        System.out.println(hero);
    }
    public static void generateVillain(HeroCreator creatorB) {
        AbstractHero villain = creatorB
                .createSuperHero("Super Girl", new HeroStatistics(1, 1, 6), TeamType.RED);
        System.out.println(villain);
    }
}

