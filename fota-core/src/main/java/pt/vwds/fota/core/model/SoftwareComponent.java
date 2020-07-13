package pt.vwds.fota.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class SoftwareComponent {
    private final String code;
}
