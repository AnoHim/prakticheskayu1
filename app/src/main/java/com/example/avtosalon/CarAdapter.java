package com.example.avtosalon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends ArrayAdapter<Car> {

    private LayoutInflater inflater;
    private int layout;
    private List<Car> cars;

     CarAdapter(Context context, int resource, List<Car> cars) {
        super(context, resource, cars);
        this.cars = cars;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Car car = cars.get(position);
        viewHolder.carView.setImageResource(car.getImageResource());
        viewHolder.descriptionView.setText(car.getDescription());
        viewHolder.nameView.setText(car.getName());
        viewHolder.countView.setText(car.getCount() + " " + "шт");

        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = car.getCount()-1;
                if(count<0) count=0;
                car.setCount(count);
                viewHolder.countView.setText(count + " " + "шт");
            }
        });
        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = car.getCount()+1;
                car.setCount(count);
                viewHolder.countView.setText(count + " " + "шт");
            }
        });

        return convertView;
    }

    private class ViewHolder {
        final Button addButton, removeButton;
        final TextView nameView, countView, descriptionView;
        final ImageView carView;
        ViewHolder(View view){
            carView = view.findViewById(R.id.car);
            addButton = view.findViewById(R.id.addButton);
            removeButton = view.findViewById(R.id.removeButton);
            nameView = view.findViewById(R.id.name);
            countView = view.findViewById(R.id.countView);
            descriptionView = view.findViewById(R.id.description);
        }
    }
}
