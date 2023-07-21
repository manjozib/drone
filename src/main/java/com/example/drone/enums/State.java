package com.example.drone.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum State {
    IDLE("IDLE"),
    LOADING("LOADING"),
    LOADED("LOADED"),
    DELIVERING("DELIVERING"),
    DELIVERED("DELIVERED"),
    RETURNING("RETURNING");

    private String state;

    private State(String state) {
        this.state=state;
    }

    @JsonCreator
    public static State decode(final String state) {
        return Stream.of(State.values()).filter(targetEnum -> targetEnum.state.equals(state)).findFirst().orElse(null);
    }

    @JsonValue
    public String getState() {
        return state;
    }
}
