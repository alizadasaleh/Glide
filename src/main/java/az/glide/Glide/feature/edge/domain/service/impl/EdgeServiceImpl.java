package az.glide.Glide.feature.edge.domain.service.impl;

import az.glide.Glide.feature.edge.domain.model.Edge;
import az.glide.Glide.feature.edge.domain.repository.EdgeRepository;
import az.glide.Glide.feature.edge.domain.service.EdgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EdgeServiceImpl implements EdgeService {
    private final EdgeRepository edgeRepository;

    @Override
    public Edge create(Edge edge) {
        return edgeRepository.save(edge);
    }

    @Override
    public Edge update(Edge edge) {
        return edgeRepository.save(edge);
    }

    @Override
    public Optional<Edge> get(Long id) {
        return edgeRepository.findById(id);
    }

    @Override
    public List<Edge> getAll() {
        return edgeRepository.findEdgesWithinArea(40.37893920515291f, 49.82907878582189f,40.375665106119655f,
                49.85988933183643f);
    }

    @Override
    public void delete(Long id) {
       edgeRepository.deleteById(id);
    }


}
