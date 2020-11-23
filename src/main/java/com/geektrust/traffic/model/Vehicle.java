package com.geektrust.traffic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * This class defines the base abstract class for all the types of vehicles.
 * A vehicle would have a name and speed.
*/
@NoArgsConstructor
@AllArgsConstructor
abstract class Vehicle {
    @Getter
    String name;
    @JsonProperty
    int speed;
}
