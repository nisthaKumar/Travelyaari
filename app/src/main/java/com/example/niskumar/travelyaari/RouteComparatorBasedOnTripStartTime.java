package com.example.niskumar.travelyaari;


import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by niskumar on 16-08-2018.
 */

public class RouteComparatorBasedOnTripStartTime implements Comparator<Route> {
    @Override
    public int compare(Route route1, Route route2) {
        try {
            Date date1 = convertStringToDate(route1.getTrip_start_time());
            Date date2 = convertStringToDate(route2.getTrip_start_time());
            return date1.compareTo(date2);
        } catch (Exception e) {
            System.out.println("OOPS! something went wrong while parsing the dates : " + e);
        }
        return 0;
    }

    public Date convertStringToDate(String rawDateString) throws Exception{

        String route_startTime_inString = rawDateString.substring(0, 17);
        String ampm1 = rawDateString.substring(18, 20);

        Date date =new SimpleDateFormat("DD-MMM-YYYY HH:mm").parse(route_startTime_inString);
        if (ampm1.equals("PM")) {
            Calendar cal = Calendar.getInstance(); // creates calendar
            cal.setTime(date); // sets calendar time/date
            cal.add(Calendar.HOUR_OF_DAY, 12); // adds 12 hours
            date = cal.getTime();
        }
        return date;
    }
}
