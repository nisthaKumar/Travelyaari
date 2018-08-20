package com.example.niskumar.travelyaari;

import java.util.Comparator;

/**
 * Created by niskumar on 20-08-2018.
 */

public class RouteComparatorBasedOnSeatsAvailable implements Comparator<Route> {
@Override
public int compare(Route route1, Route route2) {
        return route1.getSeats_available()-route2.getSeats_available();
        }
        }

