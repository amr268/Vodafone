package com.amr.core.widget;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.amr.core.R;


public class LogoutDialog {

    private final Context context;

    public LogoutDialog(Context context) {
        this.context = context;
    }

    public Dialog getDialog(
            DialogeListener dialogeListener) {
        LayoutInflater factory = LayoutInflater.from(context);
        @SuppressLint("InflateParams")
        final View deleteDialogView = factory.inflate(R.layout.dialog_layout, null);
        final AlertDialog deleteDialog = new AlertDialog.Builder(context).create();
        deleteDialog.setView(deleteDialogView);
        deleteDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView no = deleteDialogView.findViewById(R.id.tv_no);
        TextView yes = deleteDialogView.findViewById(R.id.tv_yes);
        no.setOnClickListener(view -> dialogeListener.onCancelClicked(deleteDialog));
        yes.setOnClickListener(view -> dialogeListener.onLogoutClicked());
        return deleteDialog;
    }

    public interface DialogeListener {
        void onLogoutClicked();

        void onCancelClicked(Dialog dialog);
    }
}