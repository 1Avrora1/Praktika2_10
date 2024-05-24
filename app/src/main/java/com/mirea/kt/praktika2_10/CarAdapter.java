package com.mirea.kt.praktika2_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private ArrayList<Car> cars;


    public CarAdapter(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView modelView;
        private final TextView licenseView;
        private final TextView yearView;

        ViewHolder(View view){
            super(view);
            modelView=view.findViewById(R.id.etCarModel);
            licenseView=view.findViewById(R.id.etCarLicense);
            yearView=view.findViewById(R.id.etCarYear);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.modelView.setText(String.format("Марка: %s", car.getModel()));
        holder.licenseView.setText(String.format("Гос номер: %s", car.getLicense()));
        holder.yearView.setText(String.format("Год выпуска: %s", car.getPrYear()));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
