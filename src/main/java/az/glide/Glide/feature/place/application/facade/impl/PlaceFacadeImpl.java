package az.glide.Glide.feature.place.application.facade.impl;

import az.glide.Glide.feature.place.application.facade.PlaceFacade;
import az.glide.Glide.feature.place.application.mapper.PlaceMapper;
import az.glide.Glide.feature.place.application.model.request.CreatePlaceRequest;
import az.glide.Glide.feature.place.application.model.request.UpdatePlaceRequest;
import az.glide.Glide.feature.place.application.model.response.CreatePlaceResponse;
import az.glide.Glide.feature.place.application.model.response.GetPlaceResponse;
import az.glide.Glide.feature.place.application.model.response.UpdatePlaceResponse;
import az.glide.Glide.feature.place.domain.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class PlaceFacadeImpl implements PlaceFacade {
    private final PlaceService placeService;
    private final PlaceMapper placeMapper;

    @Override
    public CreatePlaceResponse create(CreatePlaceRequest request) {
        var placeModel = placeMapper.toModel(request);
        var place = placeService.create(placeModel);

        return placeMapper.toCreateResponse(place);
    }

    @Override
    public UpdatePlaceResponse update(Long id, UpdatePlaceRequest request) {
        var placeModel = placeMapper.toModel(request);

        var existingPlace = placeService.get(id);

        if (existingPlace.isEmpty()) {
            throw new RuntimeException("Place with id " + id + " does not exist");
        }

       placeModel.setId(id);

        var place = placeService.create(placeModel);

        return placeMapper.toUpdateResponse(place);
    }

    @Override
    public GetPlaceResponse get(Long id) {
        var existingPlace = placeService.get(id);

        if (existingPlace.isEmpty()) {
            throw new RuntimeException("Place with id " + id + " does not exist");
        }

        var place = existingPlace.get();

        return placeMapper.toGetResponse(place);
    }

    @Override
    public List<GetPlaceResponse> getAll() {
        var result = placeService.getAll();

        return result.stream()
                .map(placeMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingPlace = placeService.get(id);

        if (existingPlace.isEmpty()) {
            throw new RuntimeException("Place with id " + id + " does not exist");
        }

       placeService.delete(id);
    }
}
