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

public class ContactsAdapter extends ArrayAdapter<Contacts> {


    private Context context;
    private List<Contacts> contacts;

    public ContactsAdapter(Context context, List<Contacts> list){

        super(context, R.layout.contacts_layout, list);
        this.context = context;
        this.contacts = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.contacts_layout, parent, false);

        TextView tvTeacherName = convertView.findViewById(R.id.tvTeacherName);
        TextView tvEmail = convertView.findViewById(R.id.tvEmail);
        TextView tvPhone = convertView.findViewById(R.id.tvPhone);

        tvEmail.setText(contacts.get(position).getEmail());
        tvPhone.setText(contacts.get(position).getPhone());
        tvTeacherName.setText(contacts.get(position).getName());

        return convertView;
    }

}
