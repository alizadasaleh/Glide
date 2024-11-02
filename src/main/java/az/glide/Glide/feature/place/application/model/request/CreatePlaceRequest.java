package az.glide.Glide.feature.place.application.model.request;

import az.glide.Glide.feature.common.GeoJson;
import az.glide.Glide.feature.place.domain.model.WheelchairAccess;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
public class CreatePlaceRequest {
    private String name;

    private WheelchairAccess wheelchairAccess;

    private String wheelchairDescription;

    private Float latitude;
    private Float longitude;

    private String address;

    private String geoJson; //optional
}
