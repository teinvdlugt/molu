package com.teinproductions.tein.molu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ElementInfoActivity extends ActionBarActivity{

    ListView listView;

    public static String ELEMENTRESULTINT = "Index of the element that must be sent back to MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_element_info);

        // TODO getActionBar().setHomeButtonEnabled(true);

        listView = (ListView) findViewById(R.id.element_info_list_view);

        String[] elementNames = new String[Element.values().length];
        for(int i = 0; i < elementNames.length; i++){
            elementNames[i] = Element.values()[i].getName();
        }

        ElementListAdapter adapter = new ElementListAdapter(this, elementNames);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                finishWithResult(position);
            }
        });
    }

    private void finishWithResult(int position) {

        Intent goingBack = new Intent();
        goingBack.putExtra(ELEMENTRESULTINT, position);

        setResult(RESULT_OK, goingBack);

        finish();

    }


}
