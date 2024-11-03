package az.glide.Glide.feature.edge.domain.service;

import az.glide.Glide.feature.edge.domain.model.Edge;

import java.util.List;
import java.util.Optional;

public interface EdgeService {
    Edge create(Edge edge);

    Edge update(Edge edge);

    Optional<Edge> get(Long id);

    List<Edge> getAll();

    void delete(Long id);

    List<Edge> getAllAll();
}
