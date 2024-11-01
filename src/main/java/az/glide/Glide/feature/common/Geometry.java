package az.glide.Glide.feature.common;

import lombok.Data;

import java.util.List;

@Data
public class Geometry {
    private String type;
    private List<Double> coordinates;

}
