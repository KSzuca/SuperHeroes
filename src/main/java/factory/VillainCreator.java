package factory;

import lombok.ToString;
import model.AbstractHero;
import model.HeroStatistics;
import model.TeamType;
import model.Villain;
import util.PropertiesLoader;

@ToString

public class VillainCreator implements HeroCreator {

    PropertiesLoader propertiesLoader =  PropertiesLoader.getInstance();

    @Override
    public AbstractHero createSuperHero(
            String name, HeroStatistics stats, TeamType type) {
        return new Villain(name, stats, type);
    }

    @Override
    public AbstractHero createSuperHeroWithDefaultStats(String name, TeamType type) {
        int strength = propertiesLoader
                .getProperties("config.villain.defaultStrength");
        int health = propertiesLoader
                .getProperties("config.villain.defaultHealth");
        int defense = propertiesLoader
                .getProperties("config.villain.defaultDefense");


//        String defaultStrength = System.getProperty("config.villain.defaultsStrength");
//        int strength = Integer.parseInt(defaultStrength);
//
//        String defaultHealth = System.getProperty("config.villain.defaultsHealth");
//        int health = Integer.parseInt(defaultHealth);
//
//        String defaultDefense = System.getProperty("config.villain.defaultsDefense");
//        int defense = Integer.parseInt(defaultDefense);

        return new Villain(name, new HeroStatistics(strength, health, defense), type);
    }
}
