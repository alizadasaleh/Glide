package az.glide.Glide.feature.obstacle.application.facade.impl;

import az.glide.Glide.feature.obstacle.application.facade.ObstacleFacade;
import az.glide.Glide.feature.obstacle.application.mapper.ObstacleMapper;
import az.glide.Glide.feature.obstacle.application.model.request.CreateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.request.UpdateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.response.CreateObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.GetObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.UpdateObstacleResponse;
import az.glide.Glide.feature.obstacle.domain.service.ObstacleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ObstacleFacadeImpl implements ObstacleFacade {
    private final ObstacleService obstacleService;
    private final ObstacleMapper obstacleMapper;

    @Override
    public CreateObstacleResponse create(CreateObstacleRequest request) {
        var obstacleModel = obstacleMapper.toModel(request);
        var obstacle = obstacleService.create(obstacleModel);

        return obstacleMapper.toCreateResponse(obstacle);
    }

    @Override
    public UpdateObstacleResponse update(Long id, UpdateObstacleRequest request) {
        var obstacleModel = obstacleMapper.toModel(request);

        var existingObstacle = obstacleService.get(id);

        if (existingObstacle.isEmpty()) {
            throw new RuntimeException("Obstacle with id " + id + " does not exist");
        }

       obstacleModel.setId(id);

        var obstacle = obstacleService.create(obstacleModel);

        return obstacleMapper.toUpdateResponse(obstacle);
    }

    @Override
    public GetObstacleResponse get(Long id) {
        var existingObstacle = obstacleService.get(id);

        if (existingObstacle.isEmpty()) {
            throw new RuntimeException("Obstacle with id " + id + " does not exist");
        }

        var obstacle = existingObstacle.get();

        return obstacleMapper.toGetResponse(obstacle);
    }

    @Override
    public List<GetObstacleResponse> getAll() {
        var result = obstacleService.getAll();

        return result.stream()
                .map(obstacleMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingObstacle = obstacleService.get(id);

        if (existingObstacle.isEmpty()) {
            throw new RuntimeException("Obstacle with id " + id + " does not exist");
        }

       obstacleService.delete(id);
    }
}
