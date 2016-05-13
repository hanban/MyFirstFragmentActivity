package com.hthinyane.myfirstfragmentactivity;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOne extends Fragment {

    private OnButtonPressedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("fake");
            }
        });
        return view;

    }

    public interface OnButtonPressedListener {
        public void onButtonPressed(String s);
    }

    public void updateDetail(String s) {
        listener.onButtonPressed(s);
    }

    @Override
        public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonPressedListener) {
            listener = (OnButtonPressedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implemenet MyListFragment.OnButtonPressedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
