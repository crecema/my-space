package com.crecema.my.space.common.util;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class JsonUtilsTests {

    @Data
    static class Temp {
        private int id;
        private String name;
        private LocalDateTime time;
    }

    @Test
    void testClone() {
        var temp = new Temp();
        temp.setId(1);
        temp.setName("test");
        temp.setTime(LocalDateTime.now());
        var clonedTemp = JsonUtils.clone(temp, Temp.class);
        Assertions.assertNotSame(temp, clonedTemp);
    }

}
