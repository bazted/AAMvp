package com.bazted.aamvp.act;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bazted.aamvp.R;
import com.bazted.aamvp.fragment.EventListPresenter;
import com.bazted.aamvp.fragment.IEventListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

/**
 * @author tbazyshyn
 * @version 1.0.0
 * @since 18.05.2015
 */
@EActivity(R.layout.fragment_event_list)
public class EventActivity extends AppCompatActivity implements IEventListView {

    @Bean
    EventListPresenter presenter;

    @ViewById(R.id.swipe_refresh_ll)
    SwipeRefreshLayout swipe_refresh_ll;

    @ViewById(R.id.content_view)
    ListView listView;

    @ViewById(R.id.error_tv)
    TextView error_tv;

    @ViewById(R.id.pb)
    View pb;

    @InstanceState
    String[] data;

    @AfterViews
    protected void start() {
        swipe_refresh_ll.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
        presenter.attachView(this);
        loadData();
    }

    @Override
    @UiThread
    public void showLoading(boolean pullToRefresh) {
        pb.setVisibility(View.VISIBLE);
        error_tv.setVisibility(View.GONE);
        listView.setAdapter(null);
        listView.setVisibility(View.VISIBLE);
        if (pullToRefresh) {
            swipe_refresh_ll.setRefreshing(true);
        }

    }

    @Override
    @UiThread
    public void showContent() {
        pb.setVisibility(View.GONE);
        error_tv.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        listView.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, data));
        swipe_refresh_ll.setRefreshing(false);
    }

    @Override
    @UiThread
    public void showError(String text) {
        pb.setVisibility(View.GONE);
        error_tv.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        swipe_refresh_ll.setRefreshing(false);
        error_tv.setText(text);
    }

    @Override
    public void setData(String[] data) {
        this.data = data;
    }

    @Override
    public void loadData() {
        presenter.loadEventList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }

}