package com.bazted.aamvp.event;

import com.bazted.aamvp.mvp.presenter.MvpBasePresenter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;

/**
 * @author tbazyshyn
 * @version 1.0.0
 * @since 18.05.2015
 */
@EBean
public class EventListPresenter extends MvpBasePresenter<IEventListView>
        implements IEventListPresenter {


    private EventListModel eventListModel;

    private int time = 0;

    @AfterInject
    protected void start() {
        eventListModel = new EventListModel();
    }

    @Override
    @Background
    public void loadEventList() {
        if (isViewAttached()) {
            getView().showLoading(true);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isViewAttached()) {

            time++;
            if (time % 2 == 0) {
                getView().showError("forced error");
                return;
            }

            getView().setData(eventListModel.getDummyInfoFromServer());
            getView().showContent();
        }
    }
}
