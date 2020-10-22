package com.example.zztmtm;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class InfoDialogue extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view= getActivity().getLayoutInflater().inflate(R.layout.infodialogue,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity()).setView(view);
        return builder.create();
    }
}
