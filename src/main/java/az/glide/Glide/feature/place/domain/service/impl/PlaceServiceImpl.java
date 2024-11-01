package az.glide.Glide.feature.place.domain.service.impl;

import az.glide.Glide.feature.place.domain.model.Place;
import az.glide.Glide.feature.place.domain.repository.PlaceRepository;
import az.glide.Glide.feature.place.domain.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;

    @Override
    public Place create(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public Place update(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public Optional<Place> get(Long id) {
        return placeRepository.findById(id);
    }

    @Override
    public List<Place> getAll() {
        return placeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       placeRepository.deleteById(id);
    }
}
