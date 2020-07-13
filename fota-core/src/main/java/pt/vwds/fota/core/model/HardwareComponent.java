package pt.vwds.fota.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class HardwareComponent {
    private final String code;
}
