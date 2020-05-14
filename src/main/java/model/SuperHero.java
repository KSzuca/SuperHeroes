package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter

public class SuperHero extends AbstractHero{

    public SuperHero(String name, HeroStatistics stats, TeamType type) {
        super(name, stats, type);
    }

    public int getPower() {

        return (this.getStats().getDefense() + this.getStats().getStrength()) * this.getStats().getHealth();
    }
}
