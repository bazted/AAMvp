package com.bazted.aamvp.mvp.view;

/**
 * @author tbazyshyn
 * @version 1.0.0
 * @since 18.05.2015
 */
public interface MvpLceView<M> extends MvpView {

    void showLoading(boolean pullToRefresh);

    void showContent();

    void showError(String text);

    void setData(M data);

    void loadData();
}
