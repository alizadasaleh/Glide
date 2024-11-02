package az.glide.Glide.feature.obstacle.domain.model;

import az.glide.Glide.feature.common.Auditable;
import az.glide.Glide.feature.common.GeoJson;
import az.glide.Glide.feature.common.MapObject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Obstacles")
public class Obstacle extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ObstacleType type;

    @Embedded
    private MapObject mapObject;

}
