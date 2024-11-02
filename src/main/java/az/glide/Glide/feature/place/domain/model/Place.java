package az.glide.Glide.feature.place.domain.model;

import az.glide.Glide.feature.common.Auditable;
import az.glide.Glide.feature.common.GeoJson;
import az.glide.Glide.feature.common.MapObject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "places")
public class Place extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private WheelchairAccess wheelchairAccess;

    private String wheelchairDescription;

    @Embedded
    private MapObject mapObject;


}
