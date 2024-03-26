package org.javaacademy.taxi.company;

import java.util.Map;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
public class DistanceTariffs {
    @Value("#{${tariffs}}")
    private Map<String, Integer> distances;

    public Integer getDistance(String address) {
        if (distances.containsKey(address)) {
            return distances.get(address);
        }
        throw new AddressDoesNotExistException("Адреса не существует.");
    }
}
