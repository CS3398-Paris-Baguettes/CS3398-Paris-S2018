package com.sourcey.materiallogindemo;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.app.Activity;

import butterknife.Bind;


/**
 * Fragment class for each nav menu item
 */
public class SearchFragment extends Fragment {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";

    private String mText;
    private int mColor;

    private View mContent;

    @Bind(R.id.input_search) EditText et;
    @Bind(R.id.textView2) TextView tv;

    FilmSearcher searcher = new FilmSearcher();


    public static Fragment newInstance(String text, int color) {
        Fragment frag = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_COLOR, color);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inf = inflater.inflate(R.layout.fragment_search, container, false);
        et = (EditText) inf.findViewById(R.id.input_search);
        //et.setEnabled(true);
        et.setFocusableInTouchMode(true);

        tv = (TextView) inf.findViewById(R.id.textView2);
        tv.setText("");

        return inf;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // retrieve text and color from bundle or savedInstanceState
        if (savedInstanceState == null) {
            Bundle args = getArguments();
            mText = args.getString(ARG_TEXT);
            mColor = args.getInt(ARG_COLOR);
        } else {
            mText = savedInstanceState.getString(ARG_TEXT);
            mColor = savedInstanceState.getInt(ARG_COLOR);
        }

        // initialize views
        mContent = view.findViewById(R.id.fragment_content);


        // set background color
        mContent.setBackgroundColor(mColor);


        AppCompatButton btn = (AppCompatButton) view.findViewById(R.id.btn_search);
        et.setTag((et.getKeyListener()));

                btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        final String qry = et.getText().toString();

                        //et.setEnabled(false);
                        new Thread(new Runnable(){
                            @Override
                            public void run() {

                                String netflixHas = "";
                                String huluHas = "";

                                try
                                {
                                    netflixHas = searcher.searchNetflix(qry);
                                    huluHas = searcher.searchHulu(qry);
                                }
                                catch(Exception e)
                                {

                                }

                                final String netflixHasFinal = netflixHas;
                                final String huluHasFinal = huluHas;

                                getActivity().runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        try {

                                            if (!netflixHasFinal.isEmpty() && !huluHasFinal.isEmpty()) {
                                                tv.setText("Both Netflix and Hulu have:\n" + qry + "\n\n" +
                                                           "Netflix has it at:\n" + netflixHasFinal + "\n\n" +
                                                           "Hulu has it at:\n" + huluHasFinal);
                                            } else if (!netflixHasFinal.isEmpty()) {
                                                tv.setText("Only Netflix has:\n" + qry + "\n\n" +
                                                           "Netflix has it at:\n" + netflixHasFinal);
                                            } else if (!huluHasFinal.isEmpty()) {
                                                tv.setText("Only Hulu has:\n" + qry + "\n\n" +
                                                           "Hulu has it at:\n" + huluHasFinal);
                                            } else {
                                                tv.setText("Neither service offers:\n" + qry);
                                            }
                                        } catch (Exception e) {
                                            tv.setText(e.toString());

                                        }
                                    }
                                });
                                    }

                        }).start();
                    }
                });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);
        super.onSaveInstanceState(outState);
    }
}
