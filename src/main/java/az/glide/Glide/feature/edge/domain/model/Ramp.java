package az.glide.Glide.feature.edge.domain.model;

import lombok.Getter;

@Getter
public enum Ramp {
    NORAMP(0),
    LOWRAMP(1),
    HIGHRAMP(2);


    private final int value;

    Ramp(int value) {
        this.value = value;
    }

}
