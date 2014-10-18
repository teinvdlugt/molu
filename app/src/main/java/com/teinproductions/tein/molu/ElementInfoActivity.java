package com.teinproductions.tein.molu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ElementInfoActivity extends ActionBarActivity{

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_element_info);


        listView = (ListView) findViewById(R.id.element_info_list_view);

        // initializing the String[] elementNames
        String[] elementNames = new String[Element.values().length];
        for(int i = 0; i < Element.values().length; i++){
            elementNames[i] = Element.values()[i].getName();
        }
        
        ElementListAdapter adapter = new ElementListAdapter(this,elementNames);

        listView.setAdapter(adapter);



    }
}
