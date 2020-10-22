package com.uta.utacarrental.view.reservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.uta.utacarrental.R;
import com.uta.utacarrental.model.Reservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReservationAdapter  extends BaseAdapter {

    Context context;
    List<Reservation> data;
    private static LayoutInflater inflater = null;

    public ReservationAdapter(Context context, List<Reservation> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view==null) {
            view = inflater.inflate(R.layout.fragment_reservation_item, null);
        }
        TextView carNumber = view.findViewById(R.id.reservation_car_number);
        carNumber.setText(String.valueOf(data.get(position).getCarNumber()));
        TextView carName = view.findViewById(R.id.reservation_car_name);
        carName.setText(data.get(position).getCarName());
        TextView carCap = view.findViewById(R.id.reservation_car_capacity);
        carCap.setText(String.valueOf(data.get(position).getCarCapacity()));
        TextView reservationTime = view.findViewById(R.id.reservation_time);
        Date date = data.get(position).getReservationTime();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        reservationTime.setText(ft.format(date));
        TextView totalCost = view.findViewById(R.id.reservation_total_cost);
        totalCost.setText(String.valueOf(data.get(position).getTotalCost()));
        return view;
    }
}
