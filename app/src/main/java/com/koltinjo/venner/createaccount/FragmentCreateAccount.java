package com.koltinjo.venner.createaccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koltinjo.venner.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCreateAccount extends Fragment {

    public FragmentCreateAccount() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false);
    }

}