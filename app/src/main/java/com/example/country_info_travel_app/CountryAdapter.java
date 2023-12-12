package com.example.country_info_travel_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private List<Country> countries;
    private Context context;

    public CountryAdapter(List<Country> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.name.setText(country.getName());
        // Load image from URL into ImageView using glide library
        Glide.with(context).load(country.getFlagUrl()).into(holder.flag);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public ImageView flag;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            flag = itemView.findViewById(R.id.flag);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            int position = getAdapterPosition();
            Country country = countries.get(position);
            Intent intent = new Intent(view.getContext(), CountryDetailActivity.class);
            intent.putExtra("name", country.getName());
            intent.putExtra("flagUrl", country.getFlagUrl());
            view.getContext().startActivity(intent);
        }
    }
}
