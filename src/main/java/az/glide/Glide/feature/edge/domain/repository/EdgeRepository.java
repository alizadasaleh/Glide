package az.glide.Glide.feature.edge.domain.repository;

import az.glide.Glide.feature.edge.domain.model.Edge;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, Long> {

    @Query("SELECT e FROM Edge e WHERE " +
        "(e.source.latitude BETWEEN :seLat AND :nwLat AND e.source.longitude BETWEEN :nwLng AND :seLng) OR " +
        "(e.target.latitude BETWEEN :seLat AND :nwLat AND e.target.longitude BETWEEN :nwLng AND :seLng)")
    List<Edge> findEdgesWithinArea(@Param("nwLat") Float nwLatitude,
                                   @Param("nwLng") Float nwLongitude,
                                   @Param("seLat") Float seLatitude,
                                   @Param("seLng") Float seLongitude);

}
