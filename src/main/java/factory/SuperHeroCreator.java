package factory;

import factory.HeroCreator;
import lombok.ToString;
import model.AbstractHero;
import model.HeroStatistics;
import model.SuperHero;
import model.TeamType;
import util.PropertiesLoader;

@ToString

public class SuperHeroCreator implements HeroCreator {

    private static final String SUPER_HERO = "superHero";

    PropertiesLoader propertiesLoader = PropertiesLoader.getInstance();

    @Override
    public AbstractHero createSuperHero(
            String name, HeroStatistics stats, TeamType type) {
        return new SuperHero(name, stats, type);
    }

    @Override
    public AbstractHero createSuperHeroWithDefaultStats(String name, TeamType type) {

        int strength = propertiesLoader
                .getProperties(String.join(".", CONFIG, SUPER_HERO, DEFAULT_STRENGTH));
        int health = propertiesLoader
                .getProperties(String.join(".", CONFIG, SUPER_HERO, DEFAULT_HEALTH));
        int defense = propertiesLoader
                .getProperties(String.join(".", CONFIG, SUPER_HERO, DEFAULT_DEFENCE));

//        int strength = propertiesLoader.getProperties("config.superHero.defaultsStrength");
//        int health = propertiesLoader.getProperties("config.superHero.defaultsHealth");
//        int defense = propertiesLoader.getProperties("config.superHero.defaultsDefense");

//        String defaultStrength = System.getProperty("");
//        int strength = Integer.parseInt(defaultStrength);
//
//        String defaultHealth = System.getProperty("config.superHero.defaultsHealth");
//        int health = Integer.parseInt(defaultHealth);
//
//        String defaultDefense = System.getProperty("config.superHero.defaultsDefense");
//        int defense = Integer.parseInt(defaultDefense);

        //^ to jest niezgodne z DRY, za dużo powtarzania, dlatego powyżej tego jest wersja uproszczona

        return new SuperHero(name, new HeroStatistics(health, strength, defense), type);
    }
}
