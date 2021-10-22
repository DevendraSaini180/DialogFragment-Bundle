package com.saini.dialogfragmentapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class LoginDialogFragment extends DialogFragment {

    private EditText mUserName, mPassword;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_fragment_dialog, null);
        dialogBuilder.setView(view).setTitle("Login")
        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mUserName = view.findViewById(R.id.editTextEmail);
                mPassword = view.findViewById(R.id.editTextPassword);
                String userName = mUserName.getText().toString();
                String password = mPassword.getText().toString();
                ArrayList<String> list = new ArrayList<>();
                list.add(userName);
                list.add(password);
                Intent intent = new Intent(getActivity(), ReceivingActivity.class);
                intent.putExtra("LoginData", list);
                getActivity().startActivity(intent);
            }
        });
        return dialogBuilder.create();
    }

}
