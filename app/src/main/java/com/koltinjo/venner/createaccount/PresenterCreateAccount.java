package com.koltinjo.venner.createaccount;

import com.koltinjo.venner.data.auth.AuthSource;
import com.koltinjo.venner.data.database.DatabaseSourceFake;
import com.koltinjo.venner.util.SchedulerProviderBase;

/**
 * Created by colt on 02.03.17.
 */

public class PresenterCreateAccount implements ContractCreateAccount.Presenter {

    public PresenterCreateAccount(AuthSource authSource, DatabaseSourceFake databaseSource, FragmentCreateAccount fragmentCreateAccount, SchedulerProviderBase schedulerProvider) {

    }

    @Override
    public void onCreateAccountClick() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

}