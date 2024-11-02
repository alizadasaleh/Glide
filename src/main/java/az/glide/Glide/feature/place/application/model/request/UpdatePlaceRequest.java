package az.glide.Glide.feature.place.application.model.request;

import az.glide.Glide.feature.place.domain.model.WheelchairAccess;
import lombok.Data;

@Data
public class UpdatePlaceRequest {
    private String name;

    private WheelchairAccess wheelchairAccess;

    private String wheelchairDescription;

    private Float latitude;
    private Float longitude;

    private String address;

    private String geoJson; //optional
}
