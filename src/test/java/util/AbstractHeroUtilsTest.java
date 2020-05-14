package util;

import exception.InvalidHeroDataException;
import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbstractHeroUtilsTest {

    @Test
    public void shouldCreateSuperHeroFromString() {
        //given
        String superHeroString = "SuperHero;name;5;10;15;RED";

        //when
        AbstractHero result = AbstractHeroUtils.createHeroFromString(superHeroString);

        //then
        assertEquals(new SuperHero("name", new HeroStatistics(5,10,15), TeamType.RED),
                result);
    }

    @Test
    public void shouldCreateVillainFromString() {
        //given
        //String villainString = "Villain;name;20;30;40;BLUE";
        String villainString = "Villain;name;5;10;15;RED";

        //when
        AbstractHero result = AbstractHeroUtils.createHeroFromString(villainString);

        //then
        assertEquals(new Villain("name", new HeroStatistics(5,10,15), TeamType.RED), result);
        //assertThat(result, equalTo(new Villain("name", new HeroStatistics(5,10,15), TeamType.RED)));
    }

    @Test
    public void shouldThrowExceptionItTooManyParts() {
        //given
        String invalidString = "1;2;3;4;5;6;7";

        //when&then
        assertThrows(InvalidHeroDataException.class,
        () -> AbstractHeroUtils.createHeroFromString(invalidString));
    }

    @Test
    public void shouldThrowExceptionIfTooFewParts() {
        //given
        String invalidString = "1;2;3";

        //when&then
        assertThrows(InvalidHeroDataException.class,
                () -> AbstractHeroUtils.createHeroFromString(invalidString));
    }

    @Test
    public void shouldThrowExceptionIfHealthParamHasWrongFormat() {
        //given
        String invalidFormatString = "SuperHero;name;a;10;15;RED";

        //when&then
        assertThrows(InvalidHeroDataException.class,
                () -> AbstractHeroUtils.createHeroFromString(invalidFormatString));
    }
}
