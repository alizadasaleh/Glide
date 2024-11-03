package az.glide.Glide.feature.edge.presentation.controller;

import az.glide.Glide.feature.edge.application.facade.EdgeFacade;
import az.glide.Glide.feature.edge.application.model.request.CreateEdgeRequest;
import az.glide.Glide.feature.edge.application.model.request.UpdateEdgeRequest;
import az.glide.Glide.feature.edge.application.model.response.CreateEdgeResponse;
import az.glide.Glide.feature.edge.application.model.response.GetEdgeResponse;
import az.glide.Glide.feature.edge.application.model.response.UpdateEdgeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/edges")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EdgeRestController {
    private final EdgeFacade edgeFacade;

    @GetMapping
    public ResponseEntity<List<GetEdgeResponse>> getEdge() {
        var response = edgeFacade.getAll();

        return ResponseEntity.ok(response);
    }


    @GetMapping("/all")
    public ResponseEntity<List<GetEdgeResponse>> getAll() {
        var response = edgeFacade.getAllAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetEdgeResponse> get(@PathVariable("id") Long id) {
        var response = edgeFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateEdgeResponse> create(@RequestBody CreateEdgeRequest request) {
        var response = edgeFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateEdgeResponse> update(@PathVariable("id") Long id, @RequestBody UpdateEdgeRequest request) {
        var response = edgeFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       edgeFacade.delete(id);
    }
}
