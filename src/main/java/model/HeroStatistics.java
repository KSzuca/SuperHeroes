package model;

import lombok.*;

@NoArgsConstructor
@Getter
@Data
@ToString
@EqualsAndHashCode

public class HeroStatistics {

    private int health;
    private int strength;
    private int defense;


    public HeroStatistics(int health, int strenght, int defense) {
        this.health = health;
        this.strength = strenght;
        this.defense = defense;
    }

    public void increaseHealth(int amount) {
        this.health += amount;
    }

    public void increaseStrenght(int amount) {
        this.strength += amount;
    }

    public void increaseDefense(int amount) {
        this.defense += amount;
    }
}
