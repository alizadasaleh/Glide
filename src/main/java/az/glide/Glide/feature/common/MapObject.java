package az.glide.Glide.feature.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class MapObject {

    private Float latitude;
    private Float longitude;

    private String address;

    @JdbcTypeCode(SqlTypes.JSON)
    private GeoJson geoJson;
}
