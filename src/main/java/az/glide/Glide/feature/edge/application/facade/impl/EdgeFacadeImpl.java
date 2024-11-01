package az.glide.Glide.feature.edge.application.facade.impl;

import az.glide.Glide.feature.edge.application.facade.EdgeFacade;
import az.glide.Glide.feature.edge.application.mapper.EdgeMapper;
import az.glide.Glide.feature.edge.application.model.request.CreateEdgeRequest;
import az.glide.Glide.feature.edge.application.model.request.UpdateEdgeRequest;
import az.glide.Glide.feature.edge.application.model.response.CreateEdgeResponse;
import az.glide.Glide.feature.edge.application.model.response.GetEdgeResponse;
import az.glide.Glide.feature.edge.application.model.response.UpdateEdgeResponse;
import az.glide.Glide.feature.edge.domain.service.EdgeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class EdgeFacadeImpl implements EdgeFacade {
    private final EdgeService edgeService;
    private final EdgeMapper edgeMapper;

    @Override
    public CreateEdgeResponse create(CreateEdgeRequest request) {
        var edgeModel = edgeMapper.toModel(request);
        var edge = edgeService.create(edgeModel);

        return edgeMapper.toCreateResponse(edge);
    }

    @Override
    public UpdateEdgeResponse update(Long id, UpdateEdgeRequest request) {
        var edgeModel = edgeMapper.toModel(request);

        var existingEdge = edgeService.get(id);

        if (existingEdge.isEmpty()) {
            throw new RuntimeException("Edge with id " + id + " does not exist");
        }

       edgeModel.setId(id);

        var edge = edgeService.create(edgeModel);

        return edgeMapper.toUpdateResponse(edge);
    }

    @Override
    public GetEdgeResponse get(Long id) {
        var existingEdge = edgeService.get(id);

        if (existingEdge.isEmpty()) {
            throw new RuntimeException("Edge with id " + id + " does not exist");
        }

        var edge = existingEdge.get();

        return edgeMapper.toGetResponse(edge);
    }

    @Override
    public List<GetEdgeResponse> getAll() {
        var result = edgeService.getAll();

        return result.stream()
                .map(edgeMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingEdge = edgeService.get(id);

        if (existingEdge.isEmpty()) {
            throw new RuntimeException("Edge with id " + id + " does not exist");
        }

       edgeService.delete(id);
    }
}
