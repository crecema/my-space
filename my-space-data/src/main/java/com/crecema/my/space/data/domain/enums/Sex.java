package com.crecema.my.space.data.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum Sex {

    FEMALE(0, "FEMALE"),
    MALE(1, "MALE");

    @JsonValue
    private final int code;
    private final String desc;

    @JsonCreator
    public static Sex valueOf(Integer code) {
        return switch (code) {
            case 0 -> FEMALE;
            case 1 -> MALE;
            default -> null;
        };
    }

    public boolean equals(Integer code) {
        return Objects.equals(this.code, code);
    }

}
