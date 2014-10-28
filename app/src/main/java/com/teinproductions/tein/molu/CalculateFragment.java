package com.teinproductions.tein.molu;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class CalculateFragment extends Fragment {

    EditText molEditText, gramEditText, particlesEditText;
    TextView molarMassTextView;
    Button calculateButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View theView = inflater.inflate(R.layout.calculate_fragment, container, false);

        molEditText = (EditText) theView.findViewById(R.id.mol_edit_text);
        gramEditText = (EditText) theView.findViewById(R.id.gram_edit_text);
        particlesEditText = (EditText) theView.findViewById(R.id.particles_edit_text);
        molarMassTextView = (TextView) theView.findViewById(R.id.mass_amount_text_view);
        calculateButton = (Button) theView.findViewById(R.id.calculate_button);

        molEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_GO){
                    Element passedElement = onCalculateClickListener.onRequestElement();
                    if (passedElement == null) return false;

                    molarMassTextView.setText(passedElement.getMass().toString());

                    Double givenMol = Double.parseDouble(String.valueOf(molEditText.getText()));

                    Double calculatedGram = passedElement.calculateGramWhenMolGiven(givenMol);
                    Double calculatedParticles = passedElement.calculateParticlesWhenMolGiven(givenMol);

                    DecimalFormat formatter = new DecimalFormat("0.#####E0");

                    gramEditText.setText(formatter.format(calculatedGram));
                    particlesEditText.setText(formatter.format(calculatedParticles));

                    return true;
                } return false;
            }
        });


        gramEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_GO){
                    Element passedElement = onCalculateClickListener.onRequestElement();
                    if (passedElement == null) return false;

                    molarMassTextView.setText(passedElement.getMass().toString());

                    Double givenGram = Double.parseDouble(String.valueOf(gramEditText.getText()));

                    Double calculatedMol = passedElement.calculateMolWhenGramGiven(givenGram);
                    Double calculatedParticles = passedElement.calculateParticlesWhenMolGiven(calculatedMol);

                    DecimalFormat formatter = new DecimalFormat("0.#####E0");

                    molEditText.setText(formatter.format(calculatedMol));
                    particlesEditText.setText(formatter.format(calculatedParticles));

                    return true;
                } return false;
            }
        });


        particlesEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_GO){
                    Element passedElement = onCalculateClickListener.onRequestElement();
                    if (passedElement == null) return false;

                    molarMassTextView.setText(passedElement.getMass().toString());

                    Integer givenParticles = Integer.parseInt(String.valueOf(particlesEditText.getText()));

                    Double calculatedMol = passedElement.calculateMolWhenParticlesGiven(givenParticles);
                    Double calculatedGram = passedElement.calculateGramWhenMolGiven(calculatedMol);

                    DecimalFormat formatter = new DecimalFormat("0.#####E0");

                    molEditText.setText(formatter.format(calculatedMol));
                    gramEditText.setText(formatter.format(calculatedGram));

                    return true;
                } return false;
            }
        });

        setUpButton();

        return theView;

    }

    public void setUpButton() {

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCalculate();
            }
        });

    }

    public void onClickCalculate() {

        Element passedElement = onCalculateClickListener.onRequestElement();

        if (passedElement == null) return;


        molarMassTextView.setText(passedElement.getMass().toString());

        // If a value is given in molEditText:
        if (!String.valueOf(molEditText.getText()).equals("")) {

            Double givenMol = Double.parseDouble(String.valueOf(molEditText.getText()));

            Double calculatedGram = passedElement.calculateGramWhenMolGiven(givenMol);
            Double calculatedParticles = passedElement.calculateParticlesWhenMolGiven(givenMol);

            DecimalFormat formatter = new DecimalFormat("0.#####E0");

            gramEditText.setText(formatter.format(calculatedGram));
            particlesEditText.setText(formatter.format(calculatedParticles));
        }

        // If a value is given in gramEditText:
        else if (!String.valueOf(gramEditText.getText()).equals("")) {

            Double givenGram = Double.parseDouble(String.valueOf(gramEditText.getText()));

            Double calculatedMol = passedElement.calculateMolWhenGramGiven(givenGram);
            Double calculatedParticles = passedElement.calculateParticlesWhenMolGiven(calculatedMol);

            DecimalFormat formatter = new DecimalFormat("0.#####E0");

            molEditText.setText(formatter.format(calculatedMol));
            particlesEditText.setText(formatter.format(calculatedParticles));
        }

        // If a value is given in particlesEditText:
        else if (!String.valueOf(particlesEditText.getText()).equals("")) {

            Integer givenParticles = Integer.parseInt(String.valueOf(particlesEditText.getText()));

            Double calculatedMol = passedElement.calculateMolWhenParticlesGiven(givenParticles);
            Double calculatedGram = passedElement.calculateGramWhenMolGiven(calculatedMol);

            DecimalFormat formatter = new DecimalFormat("0.#####E0");

            molEditText.setText(formatter.format(calculatedMol));
            gramEditText.setText(formatter.format(calculatedGram));
        }
    }




    OnCalculateClickListener onCalculateClickListener;

    public interface OnCalculateClickListener {

        public Element onRequestElement();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            onCalculateClickListener = (OnCalculateClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCalculateClickListener");
        }
    }
}
