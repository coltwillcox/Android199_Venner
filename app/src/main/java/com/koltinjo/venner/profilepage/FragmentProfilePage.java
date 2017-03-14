package com.koltinjo.venner.profilepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.koltinjo.venner.R;
import com.koltinjo.venner.login.ActivityLogin;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfilePage extends Fragment implements ContractProfilePage.View {

    // Views.
    private TextView textViewName;
    private TextView textViewEmail;
    private TextView textViewBiography;
    private TextView textViewInterests;
    private CircleImageView circleImageViewThumbnail;
    private FloatingActionButton fabDetailsEdit;
    private ImageButton imageButtonLogout;
    private ImageButton imageButtonUserSettings;

    private ContractProfilePage.Presenter presenter;

    public FragmentProfilePage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile_page, container, false);
        textViewName = (TextView) root.findViewById(R.id.fragmentprofilepage_textview_username);
        textViewEmail = (TextView) root.findViewById(R.id.fragmentprofilepage_textview_email);
        textViewInterests = (TextView) root.findViewById(R.id.fragmentprofilepage_textview_interests);
        textViewBiography = (TextView) root.findViewById(R.id.fragmentprofilepage_textview_biographyuser);
        circleImageViewThumbnail = (CircleImageView) root.findViewById(R.id.fragmentprofilepage_circleimageview_thumbnail);
        fabDetailsEdit = (FloatingActionButton) root.findViewById(R.id.fragmentprofilepage_fab_detailsedit);
        imageButtonLogout = (ImageButton) root.findViewById(R.id.fragmentprofilepage_imagebutton_logout);
        imageButtonUserSettings = (ImageButton) root.findViewById(R.id.fragmentprofilepage_imagebutton_usersettings);
        setListeners();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null) {
//            presenter = new PresenterProfilePage();
        }
        presenter.subscribe();
    }

    // Interface methods.
    @Override
    public void setPresenter(ContractProfilePage.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setName(String name) {
        textViewName.setText(name);
    }

    @Override
    public void setEmail(String email) {
        textViewEmail.setText(email);
    }

    @Override
    public void setBio(String bio) {
        textViewBiography.setText(bio);
    }

    @Override
    public void setInterests(String interests) {
        textViewInterests.setText(interests);
    }

    @Override
    public void setProfilePhotoURL(String profilePhotoURL) {
        Glide
                .with(getActivity())
                .load(profilePhotoURL)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        setDefaultProfilePhoto();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        presenter.onThumbnailLoaded();
                        return false;
                    }
                })
                .dontAnimate()
                .fitCenter()
                .into(circleImageViewThumbnail);
    }

    @Override
    public void setDefaultProfilePhoto() {
        Glide
                .with(getActivity())
                .load(R.drawable.ic_face_white_48dp)
                .listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                        makeToast("Unable to load image.");
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        presenter.onThumbnailLoaded();
                        return false;
                    }
                })
                .dontAnimate()
                .fitCenter()
                .into(circleImageViewThumbnail);
    }

    @Override
    public void showLogouSnackbar() {
        Snackbar
                .make(getView(), getString(R.string.fragmentprofilepage_action_logout), Snackbar.LENGTH_SHORT)
                .setAction(R.string.fragmentprofilepage_action_logout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onLogoutConfirmed();
                    }
                })
                .show();
    }

    @Override
    public void setThumbnailLoadingIndicator(boolean show) {

    }

    @Override
    public void setDetailsLoadingIndicator(boolean show) {

    }

    @Override
    public void makeToast(@StringRes int id) {
        Toast.makeText(getActivity(), getString(id), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startActivityLogin() {
        startActivity(new Intent(getActivity(), ActivityLogin.class));
    }

    @Override
    public void startActivityPhoto() {

    }

    @Override
    public void startActivityDetail() {

    }

    @Override
    public void startActivityProfileSettings() {

    }

    public static FragmentProfilePage newInstance() {
        return new FragmentProfilePage();
    }

    private void setListeners() {
        circleImageViewThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onThumbnailClick();
            }
        });
        imageButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogoutClick();
            }
        });
        imageButtonUserSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onUserSettingsClick();
            }
        });
    }

}