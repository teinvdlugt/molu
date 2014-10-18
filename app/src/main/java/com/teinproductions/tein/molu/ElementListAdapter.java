package com.teinproductions.tein.molu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ElementListAdapter extends ArrayAdapter {


    public ElementListAdapter(Context context, String[] elementNames){

        super(context,R.layout.element_info_list_layout, elementNames);

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.element_info_list_layout, parent, false);

        TextView elementNameTextView = (TextView) theView.findViewById(R.id.element_name_text_view);
        TextView atomicNumberTextView = (TextView) theView.findViewById(R.id.atomic_number_text_view);
        TextView atomicMassTextView = (TextView) theView.findViewById(R.id.atomic_number_text_view);

        elementNameTextView.setText(Element.values()[position].getName());
        atomicNumberTextView.setText(Element.values()[position].getAtomicNumber().toString());
        atomicMassTextView.setText(Element.values()[position].getMass().toString());

        return theView;
    }
}
