package com.example.carmelmusicacademyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BandProspectAdapter extends ArrayAdapter<BandProspectsBackendless> {

    private Context context;
    private List<BandProspectsBackendless> bandProspectsBackendlessList;

    public BandProspectAdapter(Context context, List<BandProspectsBackendless> list){

        super(context, R.layout.prospect_layout, list);
        this.context = context;
        this.bandProspectsBackendlessList = list;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.prospect_layout, parent, false);

       TextView tvAge = convertView.findViewById(R.id.tvAge);
       TextView tvName = convertView.findViewById(R.id.tvName);
       TextView tvInstrument = convertView.findViewById(R.id.tvInstrument);
       TextView tvTeacher = convertView.findViewById(R.id.tvTeacher);
       TextView tvLessonDays = convertView.findViewById(R.id.tvLessonDays);

       tvAge.setText(bandProspectsBackendlessList.get(position).getAge());
       tvInstrument.setText("Instrument(s): " + bandProspectsBackendlessList.get(position).getInstrument());
       tvLessonDays.setText("Lesson day(s): " + bandProspectsBackendlessList.get(position).getLessonDays());
       tvName.setText("Name: " + bandProspectsBackendlessList.get(position).getName());
       tvTeacher.setText("Teacher(s): " + bandProspectsBackendlessList.get(position).getTeacher());



        return convertView;
    }
}
