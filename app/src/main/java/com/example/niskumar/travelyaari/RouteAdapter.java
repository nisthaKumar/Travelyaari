package com.example.niskumar.travelyaari;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by niskumar on 15-08-2018.
 */

public class RouteAdapter extends ArrayAdapter<Route> {

    private Context mcontext;
    private List<Route> routeList = new ArrayList<>();

    public RouteAdapter(@NonNull Context context, List<Route> list) {
        super(context, 0, list);
        mcontext =  context;
        routeList = list;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        String volvo, ac, sleeper;
        int seats;

        if (listItem == null)
            listItem = LayoutInflater.from(mcontext).inflate(R.layout.list_item, parent, false);

        Route current = routeList.get(position);

        if(current.isIs_ac()==true)ac="AC";
        else    ac = "Non-AC";

        if(current.isIs_volvo()==true)volvo = ",Volvo";
        else    volvo="";

        if(current.isIs_sleeper()==true)sleeper = "Sleeper";
        else    sleeper = "Semi-sleeper";

        seats = current.getSeats_available();
        TextView t1 = (TextView) listItem.findViewById(R.id.operator);
        t1.setText(current.getOperator()+"("+ac+","+sleeper+volvo+")");

        TextView t2 = (TextView) listItem.findViewById(R.id.to);
        t2.setText(current.getFrom()+"------"+current.getTo()+" ("+ seats+" available)");

        TextView t3 = (TextView) listItem.findViewById(R.id.time);
        t3.setText("Start:"+current.getTrip_start_time()+" End:"+current.getTrip_end_time());

        TextView t4 = (TextView) listItem.findViewById(R.id.fare);
        t4.setText("          "+current.getFare()+"");

        return listItem;

    }
}

