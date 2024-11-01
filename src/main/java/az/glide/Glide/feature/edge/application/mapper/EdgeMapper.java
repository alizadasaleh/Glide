package az.glide.Glide.feature.edge.application.mapper;

import az.glide.Glide.feature.edge.application.model.request.CreateEdgeRequest;
import az.glide.Glide.feature.edge.application.model.request.UpdateEdgeRequest;
import az.glide.Glide.feature.edge.application.model.response.CreateEdgeResponse;
import az.glide.Glide.feature.edge.application.model.response.GetEdgeResponse;
import az.glide.Glide.feature.edge.application.model.response.UpdateEdgeResponse;
import az.glide.Glide.feature.edge.domain.model.Edge;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EdgeMapper {
    Edge toModel(CreateEdgeRequest request);

    Edge toModel(UpdateEdgeRequest request);

    CreateEdgeResponse toCreateResponse(Edge edge);

    UpdateEdgeResponse toUpdateResponse(Edge edge);

    GetEdgeResponse toGetResponse(Edge edge);
}
