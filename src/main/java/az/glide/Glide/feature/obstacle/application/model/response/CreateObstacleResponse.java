package az.glide.Glide.feature.obstacle.application.model.response;

import az.glide.Glide.feature.obstacle.domain.model.ObstacleType;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateObstacleResponse {
    private Long id;

    private ObstacleType type;

    private Float latitude;
    private Float longitude;

    private String address;

    private String geoJson;
}
