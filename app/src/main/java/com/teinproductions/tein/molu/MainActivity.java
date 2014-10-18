package com.teinproductions.tein.molu;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText elementEditText,molEditText,gramEditText,particlesEditText;
    TextView molarMassTextView;

    final int nA = (int) 6.02214 * (10 ^ 23);

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
        molEditText = (EditText) findViewById(R.id.mol_edit_text);
        molarMassTextView = (TextView) findViewById(R.id.mass__amount_text_view);
        gramEditText = (EditText) findViewById(R.id.gram_edit_text);
        particlesEditText = (EditText) findViewById(R.id.particles_edit_text);


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

    public void onClickCalculate(View view) {
        String givenElementAbbreviation = String.valueOf(elementEditText.getText());


        Element givenElement = Element.findElementByAbbreviation(givenElementAbbreviation);

        // Als het element niet goed is:
        if(givenElement == null){

            // Als er niets in het Element vak staat:
            if(String.valueOf(elementEditText.getText()).equals("")){
                DialogFragment customDialog = CustomDialog.createNew(
                        R.string.no_element_given_dialog_fragment_title,
                        R.string.no_element_given_dialog_fragment_message);

                customDialog.show(getFragmentManager(),"theDialog");

            // Als er wel iets in het Element vak staat:
            } else {
                DialogFragment customDialog = CustomDialog.createNew(
                        R.string.not_an_element_dialog_fragment_title,
                        R.string.not_an_element_dialog_fragment_message);

                customDialog.show(getFragmentManager(),"theDialog");
            }


        // Als het element goed is:
        } else {

            elementEditText.setText(givenElement.getName());
            molarMassTextView.setText(givenElement.getMass().toString());

            // If a value is given in molEditText:
            if(!String.valueOf(molEditText.getText()).equals("")) {

                Double givenMol = Double.parseDouble(String.valueOf(molEditText.getText()));

                Double calculatedGram = givenElement.calculateGramWhenMolGiven(givenMol);
                Integer calculatedParticles = givenElement.calculateParticlesWhenMolGiven(givenMol);

                gramEditText.setText(calculatedGram.toString());
                particlesEditText.setText(calculatedParticles.toString());
            }

            // If a value is given in gramEditText:
            else if (!String.valueOf(gramEditText.getText()).equals("")) {

                Double givenGram = Double.parseDouble(String.valueOf(gramEditText.getText()));

                Double calculatedMol = givenElement.calculateMolWhenGramGiven(givenGram);
                Integer calculatedParticles = givenElement.calculateParticlesWhenMolGiven(calculatedMol);

                molEditText.setText(calculatedMol.toString());
                particlesEditText.setText(calculatedParticles.toString());
            }

            // If a value is given in particlesEditText:
            else if (!String.valueOf(particlesEditText.getText()).equals("")){

                Integer givenParticles = Integer.parseInt(String.valueOf(particlesEditText.getText()));

                Double calculatedMol = givenElement.calculateMolWhenParticlesGiven(givenParticles);
                Double calculatedGram = givenElement.calculateGramWhenMolGiven(calculatedMol);

                molEditText.setText(calculatedMol.toString());
                gramEditText.setText(calculatedGram.toString());
            }
        }
    }

    public void startElementInfoActivity(){

        Intent intent  = new Intent(this,ElementInfoActivity.class);
        startActivity(intent);

    }

}
