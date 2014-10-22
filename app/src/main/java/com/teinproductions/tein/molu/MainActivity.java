package com.teinproductions.tein.molu;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements CalculateFragment.OnCalculateClickListener{

    EditText elementEditText;

    // Dit doe ik om de context en daarmee de Resources beschikbaar te maken voor de enumeration Element:
    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO getActionBar().setHomeButtonEnabled(false);

        // De context voor beschikbaarheid van Resources buiten deze class initializen:
        context = this;

        elementEditText = (EditText) findViewById(R.id.edit_text_1);


        CalculateFragment calculateFragment = new CalculateFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, calculateFragment)
                .commit();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.element_action_bar_item){
            startElementInfoActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void startElementInfoActivity(){

        Intent intent  = new Intent(this,ElementInfoActivity.class);
        startActivity(intent);

    }

    @Override
    public Element onRequestElement() {
        String givenElementAbbreviationOrName = String.valueOf(elementEditText.getText()).trim();
        Element requestedElement;
        requestedElement = Element.findElementByAbbreviationOrName(givenElementAbbreviationOrName);

        if(requestedElement == null){

            // If no element name of abbreviation is given:
            if(givenElementAbbreviationOrName.equals("")){
                DialogFragment customDialog = CustomDialog.createNew(
                        R.string.no_element_given_dialog_fragment_title,
                        R.string.no_element_given_dialog_fragment_message);

                customDialog.show(getFragmentManager(), "theDialog");

                return null;

            // If so:
            } else {
                DialogFragment customDialog = CustomDialog.createNew(
                        R.string.not_an_element_dialog_fragment_title,
                        R.string.not_an_element_dialog_fragment_message);

                customDialog.show(getFragmentManager(),"theDialog");

                return null;
            }

        } else {

            elementEditText.setText(requestedElement.getName());

            return requestedElement;
        }
    }
}
