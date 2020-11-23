package com.geektrust.traffic.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class defines the model for travel options.
*/
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TravelOption {
    private String vehicle;
    private String orbit;
    private int timeToTraverseOrbit;
}
