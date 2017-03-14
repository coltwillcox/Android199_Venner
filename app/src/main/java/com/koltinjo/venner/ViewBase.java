package com.koltinjo.venner;

import android.support.annotation.StringRes;

/**
 * Created by colt on 03.03.17.
 */

public interface ViewBase<T> {

    void setPresenter(T presenter);

    void makeToast(@StringRes int id);

    void makeToast(String message);

}