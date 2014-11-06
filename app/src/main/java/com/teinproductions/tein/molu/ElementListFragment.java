package com.teinproductions.tein.molu;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ElementListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String[] elementNames = new String[Element.values().length];
        for(int i = 0; i < elementNames.length; i++){
            elementNames[i] = Element.values()[i].getName();
        }

        setListAdapter(new ElementListAdapter(getActivity(), elementNames));

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
