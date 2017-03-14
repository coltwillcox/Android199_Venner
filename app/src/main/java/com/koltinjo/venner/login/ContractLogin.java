package com.koltinjo.venner.login;

import android.support.annotation.StringRes;
import com.koltinjo.venner.PresenterBase;
import com.koltinjo.venner.ViewBase;

/**
 * Created by colt on 02.03.17.
 */

public interface ContractLogin {

    interface View extends ViewBase<Presenter> {
        void setPresenter(ContractLogin.Presenter presenter);

        void makeToast(@StringRes int stringId);

        void makeToast(String message);

        String getEmail();

        String getPassword();

        void showProgressIndicator(boolean show);

        void startActivityProfile();

        void startActivityCreateAccount();
    }

    interface Presenter extends PresenterBase {
        void onLogInClick();

        void onCreateClick();
    }

}