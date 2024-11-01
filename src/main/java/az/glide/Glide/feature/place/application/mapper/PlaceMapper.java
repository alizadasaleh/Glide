package az.glide.Glide.feature.place.application.mapper;

import az.glide.Glide.feature.place.application.model.request.CreatePlaceRequest;
import az.glide.Glide.feature.place.application.model.request.UpdatePlaceRequest;
import az.glide.Glide.feature.place.application.model.response.CreatePlaceResponse;
import az.glide.Glide.feature.place.application.model.response.GetPlaceResponse;
import az.glide.Glide.feature.place.application.model.response.UpdatePlaceResponse;
import az.glide.Glide.feature.place.domain.model.Place;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper {
    Place toModel(CreatePlaceRequest request);

    Place toModel(UpdatePlaceRequest request);

    CreatePlaceResponse toCreateResponse(Place place);

    UpdatePlaceResponse toUpdateResponse(Place place);

    GetPlaceResponse toGetResponse(Place place);
}
