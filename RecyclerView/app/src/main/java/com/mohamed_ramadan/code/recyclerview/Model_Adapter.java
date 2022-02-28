package com.mohamed_ramadan.code.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Model_Adapter extends RecyclerView.Adapter<Model_Adapter.Model_View_Holder> {

    List<Model> modelList;
    public Model_Adapter() {
        modelList=new ArrayList<>();
    }

    @NonNull
    @Override
    public Model_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Model_View_Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Model_View_Holder holder, int position) {
        holder.Name.setText(modelList.get(position).getName());
        holder.Year.setText(modelList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void SetData(List<Model> ModelList) {
        this.modelList=modelList;
    }

    public class Model_View_Holder extends RecyclerView.ViewHolder {

        TextView Name;
        TextView Year;

        public Model_View_Holder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.itemname);
            Year=itemView.findViewById(R.id.itemyear);
        }
    }
}
