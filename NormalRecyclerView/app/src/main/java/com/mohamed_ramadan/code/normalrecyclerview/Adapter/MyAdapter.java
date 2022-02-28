package com.mohamed_ramadan.code.normalrecyclerview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamed_ramadan.code.normalrecyclerview.Model.Man;
import com.mohamed_ramadan.code.normalrecyclerview.Model.Quiz;
import com.mohamed_ramadan.code.normalrecyclerview.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Quiz> ListMen;
    private DB_Helper db_helper;

    public MyAdapter(List<Quiz> listMen , DB_Helper db) {
        ListMen = listMen;
        this.db_helper=db;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new MyViewHolder(  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitems,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.textView.setText(ListMen.get(position).getQuestion());
        holder.op1.setText(ListMen.get(position).getOption1());
        holder.op2.setText(ListMen.get(position).getOption2());
        holder.op3.setText(ListMen.get(position).getOption3());
    }

    @Override
    public int getItemCount() {
        return ListMen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        RadioButton op1;
        RadioButton op2;
        RadioButton op3;
        RadioGroup RG;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.Question);
            op1=itemView.findViewById(R.id.option1);
            op2=itemView.findViewById(R.id.option2);
            op3=itemView.findViewById(R.id.option3);
            RG=itemView.findViewById(R.id.RG);
        }
    }
}
