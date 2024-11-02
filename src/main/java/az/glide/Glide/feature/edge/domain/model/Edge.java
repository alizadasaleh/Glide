    package az.glide.Glide.feature.edge.domain.model;

import az.glide.Glide.feature.common.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Edges")
public class Edge extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long publicId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "source_id")),
            @AttributeOverride(name = "latitude", column = @Column(name = "source_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "source_longitude"))
    })
    private Node source;

    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "target_id")),
            @AttributeOverride(name = "latitude", column = @Column(name = "target_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "target_longitude"))
    })
    @Embedded
    private Node target;

    private Float slope;

    private Ramp ramp;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Node {
        private Long id;
        private Float latitude;
        private Float longitude;
    }
}
