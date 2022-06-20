package ru.netology.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    private MovieData first = new MovieData(113, "Вперёд");
    private MovieData second = new MovieData(542, "Джентельмены");
    private MovieData third = new MovieData(253, "Человек-невидимка");
    private MovieData fourth = new MovieData(789, "Бладшот");
    private MovieData fifth = new MovieData(655, "Номер один");


    @Test
    void shouldAddMovies() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        MovieData[] actual = manager.findAll();
        MovieData[] expected = {first, second, third, fourth, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        int idToRemove = 253;
        manager.removeById(idToRemove);

        MovieData[] actual = manager.findAll();
        MovieData[] expected = {first, second, fourth, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        MovieData[] actual = manager.findLast();
        MovieData[] expected = {fifth, fourth, third, second, first};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithPrescribedMiddleLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        MovieData[] actual = manager.findLast();
        MovieData[] expected = {fifth, fourth, third};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithPrescribedHighLimit() {
        MovieManager manager = new MovieManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        MovieData[] actual = manager.findLast();
        MovieData[] expected = {fifth, fourth, third, second, first};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithPrescribedLowLimit() {
        MovieManager manager = new MovieManager(1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        MovieData[] actual = manager.findLast();
        MovieData[] expected = {fifth};

        Assertions.assertArrayEquals(expected, actual);
    }


}
