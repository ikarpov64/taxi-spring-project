package org.javaacademy.taxi.company;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum TimeOfDay {
    DAY("День"), NIGHT("Ночь");
    String timeOfDay;
}
