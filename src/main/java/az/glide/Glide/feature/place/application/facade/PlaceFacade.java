package az.glide.Glide.feature.place.application.facade;

import az.glide.Glide.feature.place.application.model.request.CreatePlaceRequest;
import az.glide.Glide.feature.place.application.model.request.UpdatePlaceRequest;
import az.glide.Glide.feature.place.application.model.response.CreatePlaceResponse;
import az.glide.Glide.feature.place.application.model.response.GetPlaceResponse;
import az.glide.Glide.feature.place.application.model.response.UpdatePlaceResponse;

import java.util.List;

public interface PlaceFacade {
    CreatePlaceResponse create(CreatePlaceRequest request);

    UpdatePlaceResponse update(Long id, UpdatePlaceRequest request);

    GetPlaceResponse get(Long id);

    List<GetPlaceResponse> getAll();

    void delete(Long id);
}
