package az.glide.Glide.feature.obstacle.presentation.controller;

import az.glide.Glide.feature.obstacle.application.facade.ObstacleFacade;
import az.glide.Glide.feature.obstacle.application.model.request.CreateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.request.UpdateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.response.CreateObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.GetObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.UpdateObstacleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/obstacles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ObstacleRestController {
    private final ObstacleFacade obstacleFacade;

    @GetMapping
    public ResponseEntity<List<GetObstacleResponse>> getObstacle() {
        var response = obstacleFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetObstacleResponse> get(@PathVariable("id") Long id) {
        var response = obstacleFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateObstacleResponse> create(@RequestBody CreateObstacleRequest request) {
        var response = obstacleFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateObstacleResponse> update(@PathVariable("id") Long id, @RequestBody UpdateObstacleRequest request) {
        var response = obstacleFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       obstacleFacade.delete(id);
    }
}
