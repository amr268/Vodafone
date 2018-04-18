package com.amr.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.amr.core.util.Preconditions;


public class CustomDialoge {

    private final Context context;

    public CustomDialoge(Context context) {
        Preconditions.checkNonNull(context, "should not pass null context reference");
        this.context = context;
    }

    public AlertDialog.Builder getConfirmationDialog(DialogListner dialogListner) {
        return new AlertDialog.Builder(context)
                .setTitle("Confirmation")
                .setMessage("Are you sure you want to logout?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> dialogListner.onOkClicked())
                .setNegativeButton(android.R.string.no, ((dialog, i) -> dialogListner.onNoClicked(dialog)));
    }

    public interface DialogListner {

        void onOkClicked();

        void onNoClicked(DialogInterface dialog);
    }
}