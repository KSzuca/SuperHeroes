package factory;


import model.*;

public interface HeroCreator {

    String CONFIG = "config";
    String DEFAULT_STRENGTH = "defaultsStrength";
    String DEFAULT_HEALTH = "defaultsHealth";
    String DEFAULT_DEFENCE = "defaultsDefense";


    AbstractHero createSuperHero(
            String name, HeroStatistics stats, TeamType type);


    AbstractHero createSuperHeroWithDefaultStats(
            String name, TeamType type
    );
}

