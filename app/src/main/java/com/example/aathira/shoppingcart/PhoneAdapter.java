package com.example.aathira.shoppingcart;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder> {

    private List<Phone> phones;
    private Context context;

    public static class PhoneViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView manufacturer;
        TextView model;
        TextView price;

        public PhoneViewHolder(View v) {
            super(v);

            image = (ImageView) v.findViewById(R.id.pic);
            manufacturer = (TextView) v.findViewById(R.id.manufacturer);
            model = (TextView) v.findViewById(R.id.model);
            price = (TextView) v.findViewById(R.id.price);
        }
    }
    public PhoneAdapter(List<Phone> phones, Context context) {
        this.phones = phones;
        this.context = context;
    }

    @Override
    public PhoneAdapter.PhoneViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_phone, parent, false);
        return new PhoneViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PhoneViewHolder holder, final int position) {
        holder.manufacturer.setText(phones.get(position).getManufacturer());
        holder.model.setText(phones.get(position).getModel());
        holder.price.setText(String.valueOf(phones.get(position).getPrice()));
       Picasso.get().load(phones.get(position).getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return phones.size();
    }

}


