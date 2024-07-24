package com.exercise.starservice.service;

import com.exercise.starservice.model.Star;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface StarService {

    List<Star> findClosestStars(List<Star> stars, int size);

    Map<Long, Integer> getNumberOfStarsByDistances(List<Star> stars);

    Collection<Star> getUniqueStars(Collection<Star> stars);

    Star getStarById(Long id);

    Star addStar(Star star);

    Star updateStar(Long id, Star star);

    void deleteStar(Long id);


}
