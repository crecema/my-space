package com.crecema.my.space.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.findAndRegisterModules();
    }

    public static String toJson(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("JsonUtils.toJson() error", e);
            return "";
        }
    }

    public static <T> T toObject(String json, Class<T> tClass) {
        try {
            return OBJECT_MAPPER.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            log.error("JsonUtils.toObject() error", e);
            return null;
        }
    }

    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            var mapType = OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass);
            return OBJECT_MAPPER.readValue(json, mapType);
        } catch (JsonProcessingException e) {
            log.error("JsonUtils.toMap() error", e);
            return new LinkedHashMap<>();
        }
    }

    public static <K, V> Map<K, V> toMap(Object object, Class<K> kClass, Class<V> vClass) {
        try {
            var mapType = OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass);
            return OBJECT_MAPPER.convertValue(object, mapType);
        } catch (Exception e) {
            log.error("JsonUtils.toMap() error", e);
            return new LinkedHashMap<>();
        }
    }

    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            var collectionType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, eClass);
            return OBJECT_MAPPER.readValue(json, collectionType);
        } catch (JsonProcessingException e) {
            log.error("JsonUtils.toList() error", e);
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] toArray(String json, Class<E> eClass) {
        try {
            var arrayType = OBJECT_MAPPER.getTypeFactory().constructArrayType(eClass);
            return OBJECT_MAPPER.readValue(json, arrayType);
        } catch (JsonProcessingException e) {
            log.error("JsonUtils.toArray() error", e);
            return (E[]) new Object[0] ;
        }
    }

    public static <T> T clone(Object object, Class<T> tClass) {
        return toObject(toJson(object), tClass);
    }

}
