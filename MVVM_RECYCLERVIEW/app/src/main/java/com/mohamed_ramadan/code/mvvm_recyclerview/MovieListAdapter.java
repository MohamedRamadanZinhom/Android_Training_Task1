package com.mohamed_ramadan.code.mvvm_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private ArrayList<MovieModel> movieModelArrayList;

    public void SetList(ArrayList<MovieModel> movieModelArrayList) {
        this.movieModelArrayList = movieModelArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.Name.setText(movieModelArrayList.get(position).getName());
        holder.Year.setText(movieModelArrayList.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return movieModelArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView Year;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.itemname);
            Year=itemView.findViewById(R.id.itemyear);
        }
    }
}
