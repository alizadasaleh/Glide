package az.glide.Glide.feature.obstacle.application.model.response;

import az.glide.Glide.feature.obstacle.domain.model.ObstacleType;
import lombok.Data;

@Data
public class GetObstacleResponse {
    private Long id;
    private ObstacleType type;

    private Float latitude;
    private Float longitude;

    private String address;

    private String geoJson;
}
