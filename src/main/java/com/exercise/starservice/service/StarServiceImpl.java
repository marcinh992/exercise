package com.exercise.starservice.service;

import com.exercise.starservice.exception.StarNotFoundException;
import com.exercise.starservice.model.Star;
import com.exercise.starservice.repository.StarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;

    @Override
    public List<Star> findClosestStars(List<Star> stars, int size) {
        return stars.stream()
                .sorted(Comparator.comparingLong(Star::getDistance))
                .limit(size)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Long, Integer> getNumberOfStarsByDistances(List<Star> stars) {
        return stars.stream()
                .collect(Collectors.groupingBy(Star::getDistance, TreeMap::new, Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    @Override
    public Collection<Star> getUniqueStars(Collection<Star> stars) {
        return stars.stream()
                .collect(Collectors.toMap(Star::getName, star -> star, (existing, replacement) -> existing))
                .values();
    }

    @Override
    public Star getStarById(Long id) {
        return starRepository.findById(id)
                .orElseThrow(() -> new StarNotFoundException(String.format("Star not found with id %d", id)));
    }

    @Override
    public Star addStar(Star star) {
        return starRepository.save(star);
    }

    @Override
    public Star updateStar(Long id, Star star) {
        Star existingStar = getStarById(id);
        existingStar.setName(star.getName());
        existingStar.setDistance(star.getDistance());
        return starRepository.save(existingStar);
    }

    @Override
    public void deleteStar(Long id) {
        Star existingStar = getStarById(id);
        starRepository.delete(existingStar);
    }

}
