package com.teinproductions.tein.molu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

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

    public interface onElementClickListener{
        public void onElementClick();
    }

    onElementClickListener mCallBack;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallBack = (onElementClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ElementListFragment.onElementClickListener");
        }

    }
}
