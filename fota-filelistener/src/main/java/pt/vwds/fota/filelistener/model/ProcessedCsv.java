package pt.vwds.fota.filelistener.model;

import lombok.Getter;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class ProcessedCsv {
    private final Map<String, Set<String>> vinToComponents;

    public ProcessedCsv() {
        this.vinToComponents = new HashMap<>();
    }

    public void add(Pair<String, String> pairVinComponent) {
        String vin = pairVinComponent.getFirst();
        String component = pairVinComponent.getSecond();

        if (vinToComponents.containsKey(vin)) {
            Set<String> components = new HashSet<>(vinToComponents.get(vin));
            components.add(component);
            vinToComponents.put(vin, components);
        } else {
            vinToComponents.put(vin, Set.of(component));
        }
    }
}
