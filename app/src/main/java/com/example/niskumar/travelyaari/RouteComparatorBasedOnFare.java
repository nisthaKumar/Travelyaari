package com.example.niskumar.travelyaari;

import java.util.Comparator;

/**
 * Created by niskumar on 16-08-2018.
 */

public class RouteComparatorBasedOnFare implements Comparator<Route> {
    @Override
    public int compare(Route route1, Route route2) {
        return route1.getFare()-route2.getFare();
    }
}
