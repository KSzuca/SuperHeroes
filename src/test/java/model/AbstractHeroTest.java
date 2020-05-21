package model;

import org.junit.jupiter.api.Test;
import testingutils.AbstractHeroDataBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractHeroTest {

    @Test
    public void shouldParseSuperHeroToString() {
        AbstractHero hero = new AbstractHeroDataBuilder()
                .buildSuperHero();

        String parsedHero = hero.parseToString();

        checkHeroString(hero, parsedHero, "SuperHero");
    }

    @Test
    public void shouldParseVillainToString() {
        AbstractHero villain = new AbstractHeroDataBuilder()
                .buildVillain();

        String result = villain.parseToString();

        checkHeroString(villain, result, "Villain");

    }

    private void checkHeroString(AbstractHero hero, String result, String className) {
        assertEquals(className + ";"
        + hero.getName() + ";"
                + hero.getStats().getHealth() + ";"
                + hero.getStats().getDefense() + ";"
                + hero.getStats().getStrength() + ";"
                + hero.getType(), result);
    }
}
