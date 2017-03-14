package com.koltinjo.venner.profilepage;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.koltinjo.venner.R;

public class ActivityProfilePage extends AppCompatActivity {

    private static final String FRAGMENT_TAG = "FRAGMENT_PAGE";
    private FragmentProfilePage fragmentProfilePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        fragmentProfilePage = (FragmentProfilePage) getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragmentProfilePage == null) {
            fragmentProfilePage = FragmentProfilePage.newInstance();
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activityprofilepage_framelayout, fragmentProfilePage, FRAGMENT_TAG).commit();
    }

}