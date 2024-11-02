package az.glide.Glide.feature.obstacle.application.model.request;

import az.glide.Glide.feature.common.MapObject;
import az.glide.Glide.feature.obstacle.domain.model.ObstacleType;
import lombok.Data;

@Data
public class CreateObstacleRequest {
    private ObstacleType type;

    private Float latitude;
    private Float longitude;

}
