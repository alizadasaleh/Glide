package az.glide.Glide.feature.review.application.facade;

import az.glide.Glide.feature.review.application.model.request.CreateReviewRequest;
import az.glide.Glide.feature.review.application.model.request.UpdateReviewRequest;
import az.glide.Glide.feature.review.application.model.response.CreateReviewResponse;
import az.glide.Glide.feature.review.application.model.response.GetReviewResponse;
import az.glide.Glide.feature.review.application.model.response.UpdateReviewResponse;

import java.util.List;

public interface ReviewFacade {
    CreateReviewResponse create(CreateReviewRequest request);

    UpdateReviewResponse update(Long id, UpdateReviewRequest request);

    GetReviewResponse get(Long id);

    List<GetReviewResponse> getAll();

    void delete(Long id);
}
