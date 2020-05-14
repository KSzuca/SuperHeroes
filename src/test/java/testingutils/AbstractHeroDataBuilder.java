package testingutils;

import model.*;

public class AbstractHeroDataBuilder {

    private String name;
    private HeroStatistics stats;
    private TeamType type;



    public AbstractHeroDataBuilder() {
        name = "default-hero";
        stats = new HeroStatistics();
        type = TeamType.BLUE;
    }

    public AbstractHeroDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AbstractHeroDataBuilder withStats(HeroStatistics stats) {
        this.stats = stats;
        return this;
    }

    public AbstractHeroDataBuilder withType(TeamType type) {
        this.type = type;
        return this;
    }

    public AbstractHero buildSuperHero() {
        return new SuperHero(name, stats, type);
    }

    public AbstractHero buildVillain() {
        return new Villain(name, stats, type);
    }

    public AbstractHeroDataBuilder buildWeakHero() {
        return this.withStats(new HeroStatistics(1,1,1));
    }

    public AbstractHeroDataBuilder biuldPowerfulHero() {
        return this.withStats(new HeroStatistics(100, 100, 1000));
    }
}
