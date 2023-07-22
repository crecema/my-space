package com.crecema.my.space.data.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum UserStatus {

    INITIAL(0, "INITIAL"),
    DELETED(5, "DELETED");

    @JsonValue
    private final int code;
    private final String desc;

    @JsonCreator
    public static UserStatus valueOf(Integer code) {
        return switch (code) {
            case 0 -> INITIAL;
            case 5 -> DELETED;
            default -> null;
        };
    }

    public boolean equals(Integer code) {
        return Objects.equals(this.code, code);
    }

}
