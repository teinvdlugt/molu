package com.teinproductions.tein.molu;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ElementFragment extends Fragment{

    TextView elementNameTextView, atomicMassTextView, abbreviationTextView, atomicNumberTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View theView = inflater.inflate(R.layout.fragment_element, container, false);

        elementNameTextView = (TextView) theView.findViewById(R.id.fragment_element_name);
        atomicMassTextView = (TextView) theView.findViewById(R.id.fragment_element_atomic_mass);
        abbreviationTextView = (TextView) theView.findViewById(R.id.fragment_element_abbreviation);
        atomicNumberTextView = (TextView) theView.findViewById(R.id.fragment_element_atomic_number);

        if(getArguments() == null){
            return theView;
        }

        Element element = (Element) getArguments().getSerializable("element");

        elementNameTextView.setText(element.getName());
        atomicMassTextView.setText(new DecimalFormat().format(element.getMass()));
        abbreviationTextView.setText(element.getAbbreviation());
        atomicNumberTextView.setText(new DecimalFormat().format(element.getAtomicNumber()));

        return theView;
    }

    public static ElementFragment newInstance(Element element){
        ElementFragment elementFragment = new ElementFragment();
        Bundle args = new Bundle();
        args.putSerializable("element", element);
        elementFragment.setArguments(args);

        return elementFragment;
    }
}
