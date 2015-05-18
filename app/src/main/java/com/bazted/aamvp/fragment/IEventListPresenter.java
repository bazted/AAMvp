package com.bazted.aamvp.fragment;

import com.bazted.aamvp.mvp.presenter.MvpPresenter;

/**
 * @author tbazyshyn
 * @version 1.0.0
 * @since 18.05.2015
 */
public interface IEventListPresenter extends MvpPresenter<IEventListView> {
    void loadEventList();
}
