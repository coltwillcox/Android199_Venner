package com.koltinjo.venner.profilepage;

import com.koltinjo.venner.PresenterBase;
import com.koltinjo.venner.ViewBase;

/**
 * Created by colt on 02.03.17.
 */

public interface ContractProfilePage {

    interface View extends ViewBase<Presenter> {
        void setPresenter(ContractProfilePage.Presenter presenter);

        void setName(String name);

        void setEmail(String email);

        void setBio(String bio);

        void setInterests(String interests);

        void setProfilePhotoURL(String profilePhotoURL);

        void setDefaultProfilePhoto();

        void showLogouSnackbar();

        void setThumbnailLoadingIndicator(boolean show);

        void setDetailsLoadingIndicator(boolean show);

        void startActivityLogin();

        void startActivityPhoto();

        void startActivityDetail();

        void startActivityProfileSettings();
    }

    interface Presenter extends PresenterBase {
        void onThumbnailClick();

        void onEditProfileClick();

        void onLogoutClick();

        void onUserSettingsClick();

        void onLogoutConfirmed();

        void onThumbnailLoaded();
    }

}