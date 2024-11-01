package az.glide.Glide.feature.obstacle.domain.repository;

import az.glide.Glide.feature.obstacle.domain.model.Obstacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObstacleRepository extends JpaRepository<Obstacle, Long> {
}
