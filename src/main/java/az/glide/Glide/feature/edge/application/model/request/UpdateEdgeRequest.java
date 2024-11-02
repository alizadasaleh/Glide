package az.glide.Glide.feature.edge.application.model.request;

import az.glide.Glide.feature.edge.domain.model.Edge;
import az.glide.Glide.feature.edge.domain.model.Ramp;
import lombok.Data;

@Data
public class UpdateEdgeRequest {
    private Long osmId;

    private Edge.Node source;
    private Edge.Node target;

    private Float slope;

    private Ramp ramp;
}
