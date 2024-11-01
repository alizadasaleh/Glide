package az.glide.Glide.feature.obstacle.domain.model;

import az.glide.Glide.feature.common.GeoJson;
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
public class Obstacle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Float latitude;
    private Float longitude;

    private String address;

    @JdbcTypeCode(SqlTypes.JSON)
    private GeoJson geoJson;
}
