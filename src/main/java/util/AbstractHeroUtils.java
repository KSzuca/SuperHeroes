package util;

import exception.InvalidHeroDataException;
import lombok.EqualsAndHashCode;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class AbstractHeroUtils {

    public static AbstractHero createHeroFromString(String heroString) {
        String[] heroParts = heroString.split(";");

        if (heroParts.length > 6) {
            throw new InvalidHeroDataException("Wrong number of fields, expected 6, "
            + " but was: " + heroParts.length);
        } else if (heroParts.length < 6) {
            throw new InvalidHeroDataException("Wrong number of fields, expected 6, "
                    + " but was: " + heroParts.length);
        }

        String name = heroParts[1];
        int health, defense, strength;

        try {
            health = Integer.valueOf(heroParts[2]);
            defense = Integer.valueOf(heroParts[3]);
            strength = Integer.valueOf(heroParts[4]);
        } catch (NumberFormatException ex) {
            throw new InvalidHeroDataException(
                    "One of hero statistics has wrong format", ex);
        }
        TeamType type = TeamType.valueOf(heroParts[5]);

        if ("SuperHero".equals(heroParts[0])) {
            return new SuperHero(name,
                    new HeroStatistics(health, defense, strength),
                    type);
        } else {
            return new Villain(name,
                    new HeroStatistics(health, defense, strength),
                    type);
        }
    }

    public static void saveHerosToFile(List<AbstractHero> heroes, String fileName) {

        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                heroes.forEach(hero -> printWriter.write(hero.parseToString() + "\n"));
            } catch (IOException e) {
            e.printStackTrace();
            }
    }

    public static List<AbstractHero> readHeroesFromFile(String fileName) {
        List<AbstractHero> heroes = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                heroes.add(createHeroFromString(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return heroes;
    }
}

