package com.teinproductions.tein.molu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

public class CustomDialog extends DialogFragment {


    public static CustomDialog createNew(int title, int message){

        CustomDialog dialog = new CustomDialog();
        Bundle args = new Bundle();
        args.putInt("title",title);
        args.putInt("message",message);
        dialog.setArguments(args);

        return dialog;
    }

    public static void elementEmpty(FragmentManager fragManager) {

        CustomDialog
                .createNew(
                        R.string.no_element_given_dialog_fragment_title,
                        R.string.no_element_given_dialog_fragment_message)
                .show(fragManager, "theDialog");

    }

    public static void noElement(FragmentManager fragManager) {

        CustomDialog
                .createNew(
                        R.string.not_an_element_dialog_fragment_title,
                        R.string.not_an_element_dialog_fragment_message)
                .show(fragManager, "theDialog");

    }

    public static void invalidNumber(FragmentManager fragManager) {

        CustomDialog
                .createNew(
                        R.string.invalid_number_dialog_title,
                        R.string.invalid_number_dialog_message)
                .show(fragManager, "theDialog");

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int title = getArguments().getInt("title");
        int message = getArguments().getInt("message");

        AlertDialog.Builder theDialog = new AlertDialog.Builder(getActivity());

        theDialog.setTitle(title);
        theDialog.setMessage(message);
        theDialog.setPositiveButton(getResources().getString(R.string.ok_positive_button_dialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return theDialog.create();
    }
}
