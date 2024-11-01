package az.glide.Glide.feature.place.domain.model;

import az.glide.Glide.feature.common.MapObject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "places")
public class Place extends MapObject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private WheelchairAccess wheelchairAccess;

    private String wheelchairDescription;


}
