package com.bazted.aamvp.mvp.presenter;

import com.bazted.aamvp.mvp.view.MvpView;

/**
 * @author tbazyshyn
 * @version 1.0.0
 * @since 18.05.2015
 */
public interface MvpPresenter<V extends MvpView> {
    void attachView(V view);

    void detachView(boolean retainInstance);
}
