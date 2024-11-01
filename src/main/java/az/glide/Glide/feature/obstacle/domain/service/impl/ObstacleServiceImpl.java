package az.glide.Glide.feature.obstacle.domain.service.impl;

import az.glide.Glide.feature.obstacle.domain.model.Obstacle;
import az.glide.Glide.feature.obstacle.domain.repository.ObstacleRepository;
import az.glide.Glide.feature.obstacle.domain.service.ObstacleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObstacleServiceImpl implements ObstacleService {
    private final ObstacleRepository obstacleRepository;

    @Override
    public Obstacle create(Obstacle obstacle) {
        return obstacleRepository.save(obstacle);
    }

    @Override
    public Obstacle update(Obstacle obstacle) {
        return obstacleRepository.save(obstacle);
    }

    @Override
    public Optional<Obstacle> get(Long id) {
        return obstacleRepository.findById(id);
    }

    @Override
    public List<Obstacle> getAll() {
        return obstacleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       obstacleRepository.deleteById(id);
    }
}
