package com.koltinjo.venner.profilepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koltinjo.venner.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfilePage extends Fragment {

    public FragmentProfilePage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_page, container, false);
    }

}