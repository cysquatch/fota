package pt.vwds.fota.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
@EqualsAndHashCode
public class HardwareComponent{
    private final String code;

    public static HardwareComponent fromString(String code) {
        return HardwareComponent.builder().code(code).build();
    }

    public static Set<HardwareComponent> convertStringsToHardwareComponents(Set<String> components) {
        return components.stream().map(HardwareComponent::fromString).collect(Collectors.toSet());
    }
}
