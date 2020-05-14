package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter

public class Villain extends AbstractHero {

    public Villain(String name, HeroStatistics stats, TeamType type) {
        super(name, stats, type);
    }

    public int getPower() {

        return (this.getStats().getHealth() + this.getStats().getStrength()) * this.getStats().getDefense();
    }
}
