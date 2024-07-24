package com.exercise.starservice.controller;

import com.exercise.starservice.model.Star;
import com.exercise.starservice.dto.StarDto;
import com.exercise.starservice.mapper.StarMapper;
import com.exercise.starservice.service.StarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/stars")
@RestController
@RequiredArgsConstructor
public class StarController {

    private final StarService starService;

    @GetMapping("/{id}")
    public ResponseEntity<StarDto> getStarById(@PathVariable Long id) {
        Star star = starService.getStarById(id);

        return ResponseEntity.ok(StarMapper.INSTANCE.toDto(star));
    }

    @PostMapping
    public ResponseEntity<StarDto> addStar(@RequestBody @Valid StarDto starDto) {
        Star star = StarMapper.INSTANCE.toEntity(starDto);
        Star savedStar = starService.addStar(star);

        return ResponseEntity.ok(StarMapper.INSTANCE.toDto(savedStar));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StarDto> updateStar(@PathVariable Long id, @RequestBody @Valid StarDto starDto) {
        Star star = StarMapper.INSTANCE.toEntity(starDto);
        Star updatedStar = starService.updateStar(id, star);

        return ResponseEntity.ok(StarMapper.INSTANCE.toDto(updatedStar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStar(@PathVariable Long id) {
        starService.deleteStar(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/closest")
    public List<StarDto> findClosestStars(@RequestBody @Valid List<StarDto> starDtos, @RequestParam int size) {
        List<Star> starEntities = starDtos.stream()
                .map(StarMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());

        return starService.findClosestStars(starEntities, size).stream()
                .map(StarMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/distances")
    public Map<Long, Integer> getNumberOfStarsByDistances(@RequestBody @Valid List<StarDto> starDtos) {
        List<Star> starEntities = starDtos.stream()
                .map(StarMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());

        return starService.getNumberOfStarsByDistances(starEntities);
    }

    @PostMapping("/unique")
    public Collection<StarDto> getUniqueStars(@RequestBody @Valid Collection<StarDto> starDtos) {
        Collection<Star> starEntities = starDtos.stream()
                .map(StarMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());

        return starService.getUniqueStars(starEntities).stream()
                .map(StarMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

}
