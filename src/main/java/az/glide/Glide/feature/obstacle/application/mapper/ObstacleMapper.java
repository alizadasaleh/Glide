package az.glide.Glide.feature.obstacle.application.mapper;

import az.glide.Glide.feature.obstacle.application.model.request.CreateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.request.UpdateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.response.CreateObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.GetObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.UpdateObstacleResponse;
import az.glide.Glide.feature.obstacle.domain.model.Obstacle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ObstacleMapper {
    Obstacle toModel(CreateObstacleRequest request);

    Obstacle toModel(UpdateObstacleRequest request);

    CreateObstacleResponse toCreateResponse(Obstacle obstacle);

    UpdateObstacleResponse toUpdateResponse(Obstacle obstacle);

    GetObstacleResponse toGetResponse(Obstacle obstacle);
}
