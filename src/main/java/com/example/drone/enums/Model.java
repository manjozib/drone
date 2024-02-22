package com.example.drone.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Model {
    Lightweight("Lightweight"),
    Middleweight("Middleweight"),
    Cruiserweight("Cruiserweight"),
    Heavyweight("Heavyweight");

    private final String model;

    Model(String model) {
        this.model=model;
    }

    @JsonCreator
    public static Model decode(final String model) {
        return Stream.of(Model.values()).filter(targetEnum -> targetEnum.model.equals(model)).findFirst().orElse(null);
    }

    @JsonValue
    public String getModel() {
        return model;
    }
}
