package com.geektrust.traffic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * This is a base abstract class for all the types of travelling conditions
 * which has some effect on the route.
*/
@NoArgsConstructor
@AllArgsConstructor
abstract class TravelCondition {
    @Getter
    private double effectOnRouteByPercentage;
}
