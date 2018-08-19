package com.example.niskumar.travelyaari;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button b1 ;
    Button b2 ;
    ListView listView;
    List<Route> routeList;
    private RouteAdapter rAdapter;
    AlertDialog.Builder alertDialogBuilder;
    AlertDialog.Builder alertDialogBuilder1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.sort);
        b2 = (Button) findViewById(R.id.filter);

        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Please select Sort By");

        alertDialogBuilder.setPositiveButton("Fare",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Collections.sort(routeList, new RouteComparatorBasedOnFare());
                        rAdapter = new RouteAdapter(MainActivity.this, routeList);
                        listView.setAdapter(rAdapter);
                        Toast.makeText(MainActivity.this,"Sorted based on Fare",Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("Start Time",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Collections.sort(routeList, new RouteComparatorBasedOnTripStartTime());
                rAdapter = new RouteAdapter(MainActivity.this, routeList);
                listView.setAdapter(rAdapter);
                Toast.makeText(MainActivity.this,"Sorted based on Start Time",Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNeutralButton("End Time",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Collections.sort(routeList, new RouteComparatorBasedOnTripEndTime());
                rAdapter = new RouteAdapter(MainActivity.this, routeList);
                listView.setAdapter(rAdapter);
                Toast.makeText(MainActivity.this, "Sorted based on End Time", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder1 = new AlertDialog.Builder(this);
        alertDialogBuilder1.setMessage("Please select Filter By");

        alertDialogBuilder1.setPositiveButton("SRS_Travels",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        List<Route> routesFilteredByServiceProvider_SRS_Travels = filterByServiceProviders("SRS Travels");
                        rAdapter = new RouteAdapter(MainActivity.this, routesFilteredByServiceProvider_SRS_Travels);
                        listView.setAdapter(rAdapter);
                        Toast.makeText(MainActivity.this,"Filtered based on SRS_Travels",Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder1.setNegativeButton("Volvo",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                List<Route> routesFilteredByServiceProvider_SRS_Travels = filterByServiceProviders("SRS Travels");
                rAdapter = new RouteAdapter(MainActivity.this, filterByIsVolvo(true));
                listView.setAdapter(rAdapter);
                Toast.makeText(MainActivity.this,"Filtered based on Volvo",Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder1.setNeutralButton("Price(500-750)",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                List<Route> routesFilteredByServiceProvider_SRS_Travels = filterByServiceProviders("SRS Travels");
                rAdapter = new RouteAdapter(MainActivity.this, filterByPriceRange(500, 750));
                listView.setAdapter(rAdapter);
                Toast.makeText(MainActivity.this, "Filtered based on Price(500-750)", Toast.LENGTH_LONG).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = alertDialogBuilder1.create();
                alertDialog.show();

            }

        });

        listView = (ListView)findViewById(R.id.route_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<ResponseDTO> call = api.getRoutes();

        call.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                ResponseDTO responseDTO = response.body();
                routeList = responseDTO.getRoutes();

                rAdapter = new RouteAdapter(MainActivity.this, routeList);
                listView.setAdapter(rAdapter);
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }


    public List<Route> filterByServiceProviders(String serviceProvider) {

        List<Route> routesFilteredByServiceProvider = new ArrayList<>();

        //  iterate through all the routes and pick out the ones which have the required operator
        for(Route route : routeList) {
            if(route.getOperator().equals(serviceProvider)) {
                routesFilteredByServiceProvider.add(route);
            }
        }
        return routesFilteredByServiceProvider;
    }

    public List<Route> filterByIsVolvo(boolean isVolvo) {

        List<Route> routesFilteredByIsVolvo = new ArrayList<>();

        //  iterate through all the routes and pick out the ones which have matching isVolvo
        for(Route route : routeList) {
            if(route.isIs_volvo() == isVolvo) {
                routesFilteredByIsVolvo.add(route);
            }
        }
        return routesFilteredByIsVolvo;
    }

    public List<Route> filterByPriceRange(int min, int max) {

        List<Route> routesFilteredByPriceRange = new ArrayList<>();

        //  iterate through all the routes and pick out the ones which have matching price range
        for(Route route : routeList) {
            if(min <= route.getFare() && route.getFare() <= max) {
                routesFilteredByPriceRange.add(route);
            }
        }
        return routesFilteredByPriceRange;
    }
   }
