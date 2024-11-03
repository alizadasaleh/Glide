package az.glide.Glide.feature.edge.application.facade;

import az.glide.Glide.feature.edge.application.model.request.CreateEdgeRequest;
import az.glide.Glide.feature.edge.application.model.request.UpdateEdgeRequest;
import az.glide.Glide.feature.edge.application.model.response.CreateEdgeResponse;
import az.glide.Glide.feature.edge.application.model.response.GetEdgeResponse;
import az.glide.Glide.feature.edge.application.model.response.UpdateEdgeResponse;

import java.util.List;

public interface EdgeFacade {
    CreateEdgeResponse create(CreateEdgeRequest request);

    UpdateEdgeResponse update(Long id, UpdateEdgeRequest request);

    GetEdgeResponse get(Long id);

    List<GetEdgeResponse> getAll();

    void delete(Long id);

    List<GetEdgeResponse> getAllAll();
}
