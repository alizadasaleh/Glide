package az.glide.Glide.feature.review.domain.repository;

import az.glide.Glide.feature.review.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
