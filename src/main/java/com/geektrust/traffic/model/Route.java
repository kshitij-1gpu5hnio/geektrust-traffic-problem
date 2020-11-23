package com.geektrust.traffic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * This is a base abstract class for all the types of routes.
 * A route will have a name, source, destination, and its length.
*/
@NoArgsConstructor
@AllArgsConstructor
abstract class Route {
    @Getter
    private String name;
    @JsonProperty
    private String source;
    @JsonProperty
    private String destination;
    @Getter
    private int length;
}
