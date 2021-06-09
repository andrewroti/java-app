package com.example.carmelmusicacademyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SubRequestAdapter extends ArrayAdapter<SubRequests> {

    private Context context;
    private List<SubRequests> list;


    public SubRequestAdapter(Context context, List<SubRequests> list){

        super(context, R.layout.sublist_layout, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(R.layout.sublist_layout, parent, false);

        TextView tvUserEmail = convertView.findViewById(R.id.tvUserEmail);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        TextView tvReason = convertView.findViewById(R.id.tvReason);

        tvDate.setText(list.get(position).getDateRequested());
        tvUserEmail.setText("Contact teacher: " + list.get(position).getUserEmail());
        tvReason.setText(list.get(position).getReason());



        return convertView;
    }
}
