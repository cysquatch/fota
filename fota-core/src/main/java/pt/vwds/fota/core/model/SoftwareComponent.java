package pt.vwds.fota.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
@EqualsAndHashCode
public class SoftwareComponent{

    private final String code;

    public static SoftwareComponent fromString(String code) {
        return SoftwareComponent.builder().code(code).build();
    }

    public static Set<SoftwareComponent> convertStringsToSoftwareComponents(Set<String> components) {
        return components.stream().map(SoftwareComponent::fromString).collect(Collectors.toSet());
    }
}
