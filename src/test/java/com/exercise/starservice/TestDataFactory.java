package com.exercise.starservice;

import com.exercise.starservice.model.Star;

import java.util.Arrays;
import java.util.List;

public class TestDataFactory {

    public static List<Star> createTestStars() {
        return Arrays.asList(
                Star.builder().id(1L).name("Alpha").distance(4).build(),
                Star.builder().id(2L).name("Beta").distance(2).build(),
                Star.builder().id(3L).name("Gamma").distance(5).build(),
                Star.builder().id(4L).name("Delta").distance(1).build(),
                Star.builder().id(5L).name("Epsilon").distance(3).build()
        );
    }

    public static List<Star> createTestStarsWithDuplicates() {
        return Arrays.asList(
                Star.builder().id(1L).name("Alpha").distance(4).build(),
                Star.builder().id(2L).name("Beta").distance(2).build(),
                Star.builder().id(3L).name("Alpha").distance(5).build(),
                Star.builder().id(4L).name("Delta").distance(1).build(),
                Star.builder().id(5L).name("Beta").distance(3).build()
        );
    }

    public static List<Star> createTestStarsWithSameDistance() {
        return Arrays.asList(
                Star.builder().id(1L).name("Alpha").distance(4).build(),
                Star.builder().id(2L).name("Beta").distance(2).build(),
                Star.builder().id(3L).name("Gamma").distance(5).build(),
                Star.builder().id(4L).name("Delta").distance(1).build(),
                Star.builder().id(5L).name("Epsilon").distance(3).build(),
                Star.builder().id(6L).name("Zeta").distance(3).build()
        );
    }
}
