package pt.vwds.fota.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
@EqualsAndHashCode
public class HardwareComponent{

    private final String code;

    @JsonCreator
    private HardwareComponent(@JsonProperty("code") String code) {
        this.code = code;
    }

    public static HardwareComponent fromString(String code) {
        return HardwareComponent.builder().code(code).build();
    }

    public static Set<HardwareComponent> convertStringsToHardwareComponents(Set<String> components) {
        return components.stream().map(HardwareComponent::fromString).collect(Collectors.toSet());
    }
}
