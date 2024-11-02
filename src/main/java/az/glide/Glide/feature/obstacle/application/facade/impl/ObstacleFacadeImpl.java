package az.glide.Glide.feature.obstacle.application.facade.impl;

import az.glide.Glide.feature.common.Feature;
import az.glide.Glide.feature.common.GeoJson;
import az.glide.Glide.feature.common.Geometry;
import az.glide.Glide.feature.common.MapObject;
import az.glide.Glide.feature.obstacle.application.facade.ObstacleFacade;
import az.glide.Glide.feature.obstacle.application.mapper.ObstacleMapper;
import az.glide.Glide.feature.obstacle.application.model.request.CreateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.request.UpdateObstacleRequest;
import az.glide.Glide.feature.obstacle.application.model.response.CreateObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.GetObstacleResponse;
import az.glide.Glide.feature.obstacle.application.model.response.UpdateObstacleResponse;
import az.glide.Glide.feature.obstacle.domain.model.Obstacle;
import az.glide.Glide.feature.obstacle.domain.model.ObstacleType;
import az.glide.Glide.feature.obstacle.domain.service.ObstacleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ObstacleFacadeImpl implements ObstacleFacade {
    private final ObstacleService obstacleService;
    private final ObstacleMapper obstacleMapper;
    ObjectMapper om = new ObjectMapper();

    @Override
    public CreateObstacleResponse create(CreateObstacleRequest request) {
        Obstacle obstacleModel = obstacleMapper.toModel(request);

        // Create a small rectangle with the given latitude and longitude as the center
        float latitude = request.getLatitude();
        float longitude = request.getLongitude();
        double offset = 0.0001; // Adjust the offset as needed for rectangle size

        // Define the rectangle's corner coordinates (clockwise or counterclockwise)
        List<List<Double>> coordinates = List.of(
                List.of(longitude - offset, latitude + offset), // top-left
                List.of(longitude + offset, latitude + offset), // top-right
                List.of(longitude + offset, latitude - offset), // bottom-right
                List.of(longitude - offset, latitude - offset), // bottom-left
                List.of(longitude - offset, latitude + offset)  // back to top-left to close the polygon
        );

        // Create Geometry and Feature
        Geometry geometry = new Geometry();
        geometry.setType("Polygon");
        geometry.setCoordinates((coordinates));

        Feature feature = new Feature();
        feature.setType("Feature");
        feature.setGeometry(geometry);
        feature.setProperties(Map.of("name", "Rectangle"));

        // Create GeoJson object
        GeoJson geoJson = new GeoJson();
        geoJson.setType("FeatureCollection");
        geoJson.setFeatures(List.of(feature));

        // Set the geoJson to obstacleModel
        String json = "";
        try {
            json = om.writeValueAsString(geoJson);
        }catch (Exception e){
            log.error(e);
        }

        // Save the obstacle
        obstacleModel.setGeoJson(json);
        Obstacle obstacle = obstacleService.create(obstacleModel);

        // Return the response
        return obstacleMapper.toCreateResponse(obstacle);
    }

    @Override
    public UpdateObstacleResponse update(Long id, UpdateObstacleRequest request) {
        var obstacleModel = obstacleMapper.toModel(request);

        var existingObstacle = obstacleService.get(id);

        if (existingObstacle.isEmpty()) {
            throw new RuntimeException("Obstacle with id " + id + " does not exist");
        }

       obstacleModel.setId(id);

        var obstacle = obstacleService.create(obstacleModel);

        return obstacleMapper.toUpdateResponse(obstacle);
    }

    @Override
    public GetObstacleResponse get(Long id) {
        var existingObstacle = obstacleService.get(id);

        if (existingObstacle.isEmpty()) {
            throw new RuntimeException("Obstacle with id " + id + " does not exist");
        }

        var obstacle = existingObstacle.get();

        return obstacleMapper.toGetResponse(obstacle);
    }

    @Override
    public List<GetObstacleResponse> getAll() {
        var result = obstacleService.getAll();

        return result.stream()
                .map(obstacleMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingObstacle = obstacleService.get(id);

        if (existingObstacle.isEmpty()) {
            throw new RuntimeException("Obstacle with id " + id + " does not exist");
        }

       obstacleService.delete(id);
    }
}
