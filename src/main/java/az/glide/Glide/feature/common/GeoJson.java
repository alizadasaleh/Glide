package az.glide.Glide.feature.common;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
public class GeoJson {
    private String type;
    private List<Feature> features;
}
