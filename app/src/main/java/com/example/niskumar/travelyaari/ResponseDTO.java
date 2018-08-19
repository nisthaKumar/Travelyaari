package com.example.niskumar.travelyaari;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niskumar on 15-08-2018.
 */

public class ResponseDTO {

    private ArrayList<Route> routes;
    private SearchQuery search_query;

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }

    public SearchQuery getSearch_query() {
        return search_query;
    }

    public void setSearch_query(SearchQuery search_query) {
        this.search_query = search_query;
    }


}
