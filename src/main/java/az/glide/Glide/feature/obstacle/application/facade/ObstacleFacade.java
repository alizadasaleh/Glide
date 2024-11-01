package az.glide.Glide.feature.obstacle.application.facade;

import az.glide.Glide.feature.obstacle.application.model.request.CreateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.request.UpdateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.response.CreateObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.GetObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.UpdateObstacleResponse;

import java.util.List;

public interface ObstacleFacade {
    CreateObstacleResponse create(CreateObstacleRequest request);

    UpdateObstacleResponse update(Long id, UpdateObstacleRequest request);

    GetObstacleResponse get(Long id);

    List<GetObstacleResponse> getAll();

    void delete(Long id);
}
