package model;

import lombok.*;

import static java.lang.String.join;

@ToString
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractHero {

    public static int instanceNumber = 0;

    protected String name;
    protected HeroStatistics stats;
    protected TeamType type;
    protected boolean isAlive;


    public AbstractHero(String name, HeroStatistics stats, TeamType type) {
        //instanceNumber++;

        this.name = name;
        this.stats = stats;
        this.type = type;
        this.isAlive = true;

        switch(type) {
            case RED: {
                this.getStats().increaseHealth(50);
                break;
            }
            case BLUE: {
                this.getStats().increaseStrenght(50);
                break;
            }
            case GREEN: {
                this.getStats().increaseDefense(50);
                break;
            }
        }
    }

    public void killHero() {
        this.isAlive = false;
    }

    public abstract int getPower();

    public String parseToString() {

       return join(";",
               this.getClass().getSimpleName(),
                this.name,
                Integer.toString(this.stats.getHealth()),
                Integer.toString(this.stats.getDefense()),
                Integer.toString(this.stats.getStrength()),
                this.type.toString());
    }
}
