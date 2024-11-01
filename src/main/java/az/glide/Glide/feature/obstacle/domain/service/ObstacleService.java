package az.glide.Glide.feature.obstacle.domain.service;

import az.glide.Glide.feature.obstacle.domain.model.Obstacle;

import java.util.List;
import java.util.Optional;

public interface ObstacleService {
    Obstacle create(Obstacle obstacle);

    Obstacle update(Obstacle obstacle);

    Optional<Obstacle> get(Long id);

    List<Obstacle> getAll();

    void delete(Long id);
}
