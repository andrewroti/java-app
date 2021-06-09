package com.example.carmelmusicacademyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LadderAdapter extends ArrayAdapter<LadderList>
{
    private Context context;
    private List<LadderList> ladderList;


    public LadderAdapter(Context context, List<LadderList> list){

        super(context, R.layout.row_layout, list);
        this.context = context;
        this.ladderList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.row_layout, parent, false);

        TextView tvAwardMonth = convertView.findViewById(R.id.tvAwardMonth);
        TextView tvAwardLevel = convertView.findViewById(R.id.tvAwardLevel);
        TextView tvName = convertView.findViewById(R.id.tvName);

        tvAwardMonth.setText(ladderList.get(position).getAwardMonth());
        tvAwardLevel.setText(ladderList.get(position).getAwardLevel());
        tvName.setText(ladderList.get(position).getName());



        return convertView;
    }
}
