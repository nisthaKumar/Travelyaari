package com.example.niskumar.travelyaari;

/**
 * Created by niskumar on 15-08-2018.
 */

public class Route {

    private String from;
    private String to;
    private boolean is_volvo;
    private String operator;
    private boolean is_ac;
    private String trip_start_time;
    private String trip_end_time;
    private boolean is_sleeper;
    private int fare;
    private int seats_available;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean isIs_volvo() {
        return is_volvo;
    }

    public void setIs_volvo(boolean is_volvo) {
        this.is_volvo = is_volvo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isIs_ac() {
        return is_ac;
    }

    public void setIs_ac(boolean is_ac) {
        this.is_ac = is_ac;
    }

    public String getTrip_start_time() {
        return trip_start_time;
    }

    public void setTrip_start_time(String trip_start_time) {
        this.trip_start_time = trip_start_time;
    }

    public String getTrip_end_time() {
        return trip_end_time;
    }

    public void setTrip_end_time(String trip_end_time) {
        this.trip_end_time = trip_end_time;
    }

    public boolean isIs_sleeper() {
        return is_sleeper;
    }

    public void setIs_sleeper(boolean is_sleeper) {
        this.is_sleeper = is_sleeper;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getSeats_available() {
        return seats_available;
    }

    public void setSeats_available(int seats_available) {
        this.seats_available = seats_available;
    }

    @Override
    public String toString() {
        return "Route{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", is_volvo=" + is_volvo +
                ", operator='" + operator + '\'' +
                ", is_ac=" + is_ac +
                ", trip_start_time='" + trip_start_time + '\'' +
                ", trip_end_time='" + trip_end_time + '\'' +
                ", is_sleeper=" + is_sleeper +
                ", fare=" + fare +
                ", seats_available=" + seats_available +
                '}';
    }
}
