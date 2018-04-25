package com.sourcey.materiallogindemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import butterknife.Bind;


/**
 * Fragment class for each nav menu item
 */
public class UserFragment extends Fragment {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";
    private static final String ARG_EMAIL = "arg_email";
    private String mText;
    private int mColor;

    private View mContent;

    EditText et;


    public static Fragment newInstance(String text, int color, String email) {
        Fragment frag = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_COLOR, color);
        args.putString(ARG_EMAIL, email);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inf = inflater.inflate(R.layout.fragment_user, container, false);
        et = (EditText) inf.findViewById(R.id.tv_name);
        et.setEnabled(false);
        et.setText(getArguments().getString(ARG_EMAIL));
        return inf;
    }

    @Override
    public void onViewCreated(View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // retrieve text and color from bundle or savedInstanceState
        if (savedInstanceState == null) {
            Bundle args = getArguments();
            mText = args.getString(ARG_TEXT);
            mColor = args.getInt(ARG_COLOR);
           // mEmail = args.getString(ARG_USER);
        } else {
            mText = savedInstanceState.getString(ARG_TEXT);
            mColor = savedInstanceState.getInt(ARG_COLOR);
           // mEmail = savedInstanceState.getString(ARG_USER);
        }

        // initialize views
        mContent = view.findViewById(R.id.fragment_content);



        ToggleButton toggle = (ToggleButton) view.findViewById(R.id.edit_button);
        et.setTag((et.getKeyListener()));
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    et.setEnabled(true);
                    et.setKeyListener((KeyListener) et.getTag());
                    et.setText("");
                } else {
                    et.setEnabled(false);
                    et.setKeyListener(null);
                }
               // mEmail = et.getText().toString();
            }
        });

        // set background color


        mContent.setBackgroundColor(mColor);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);
        //outState.putString(ARG_USER, mEmail);
        super.onSaveInstanceState(outState);
    }

}
