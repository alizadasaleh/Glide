package az.glide.Glide.feature.edge.domain.repository;

import az.glide.Glide.feature.edge.domain.model.Edge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, Long> {
}
