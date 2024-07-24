package com.exercise.starservice;

import com.exercise.starservice.model.Star;
import com.exercise.starservice.repository.StarRepository;
import com.exercise.starservice.service.StarServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StarServiceTest {

    @Mock
    private StarRepository starRepository;

    @InjectMocks
    private StarServiceImpl starService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findClosestStarsTest() {
        // given
        List<Star> stars = TestDataFactory.createTestStars();

        // when
        List<Star> closestStars = starService.findClosestStars(stars, 3);

        // then
        assertEquals(3, closestStars.size());
        assertEquals("Delta", closestStars.get(0).getName());
        assertEquals("Beta", closestStars.get(1).getName());
        assertEquals("Epsilon", closestStars.get(2).getName());
    }

    @Test
    void getNumberOfStarsByDistancesTest() {
        // given
        List<Star> stars = TestDataFactory.createTestStarsWithSameDistance();

        // when
        Map<Long, Integer> starsByDistances = starService.getNumberOfStarsByDistances(stars);

        // then
        assertEquals(1, starsByDistances.get(1L));
        assertEquals(1, starsByDistances.get(2L));
        assertEquals(2, starsByDistances.get(3L));
        assertEquals(1, starsByDistances.get(4L));
        assertEquals(1, starsByDistances.get(5L));
    }

    @Test
    void getUniqueStarsTest() {
        // given
        List<Star> stars = TestDataFactory.createTestStarsWithDuplicates();

        // when
        Collection<Star> uniqueStars = starService.getUniqueStars(stars);

        // then
        assertEquals(3, uniqueStars.size());
        assertTrue(uniqueStars.stream().anyMatch(star -> star.getName().equals("Alpha")));
        assertTrue(uniqueStars.stream().anyMatch(star -> star.getName().equals("Beta")));
        assertTrue(uniqueStars.stream().anyMatch(star -> star.getName().equals("Delta")));
    }
}
