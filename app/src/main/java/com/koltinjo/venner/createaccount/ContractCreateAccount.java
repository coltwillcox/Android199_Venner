package com.koltinjo.venner.createaccount;

import android.support.annotation.StringRes;
import com.koltinjo.venner.PresenterBase;
import com.koltinjo.venner.ViewBase;

/**
 * Created by colt on 02.03.17.
 */

public interface ContractCreateAccount {

    interface View extends ViewBase<Presenter> {
        void setPresenter(ContractCreateAccount.Presenter presenter);

        void makeToast(@StringRes int stringId);

        String getName();

        String getEmail();

        String getPassword();

        String getPasswordConfirmation();

        void showProgressIndicator(boolean show);

        void startActivityLogin();

        void startActivityProfilePage();
    }

    interface Presenter extends PresenterBase {
        void onCreateAccountClick();

        void subscribe();

        void unsubscribe();
    }

}