package az.glide.Glide.feature.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Feature {
    private String type;
    private Geometry geometry;
    private Map<String, Object> properties;

}
