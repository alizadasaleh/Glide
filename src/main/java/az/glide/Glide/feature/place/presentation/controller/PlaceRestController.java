package az.glide.Glide.feature.place.presentation.controller;

import az.glide.Glide.feature.place.application.facade.PlaceFacade;
import az.glide.Glide.feature.place.application.model.request.CreatePlaceRequest;
import az.glide.Glide.feature.place.application.model.request.UpdatePlaceRequest;
import az.glide.Glide.feature.place.application.model.response.CreatePlaceResponse;
import az.glide.Glide.feature.place.application.model.response.GetPlaceResponse;
import az.glide.Glide.feature.place.application.model.response.UpdatePlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/places")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlaceRestController {
    private final PlaceFacade placeFacade;

    @GetMapping
    public ResponseEntity<List<GetPlaceResponse>> getPlace() {
        var response = placeFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPlaceResponse> get(@PathVariable("id") Long id) {
        var response = placeFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreatePlaceResponse> create(@RequestBody CreatePlaceRequest request) {
        var response = placeFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatePlaceResponse> update(@PathVariable("id") Long id, @RequestBody UpdatePlaceRequest request) {
        var response = placeFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       placeFacade.delete(id);
    }
}
