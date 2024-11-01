package az.glide.Glide.feature.place.domain.service;

import az.glide.Glide.feature.place.domain.model.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {
    Place create(Place place);

    Place update(Place place);

    Optional<Place> get(Long id);

    List<Place> getAll();

    void delete(Long id);
}
