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

        return new Villain(name, new HeroStatistics(strength, health, defense), type);
    }
}
