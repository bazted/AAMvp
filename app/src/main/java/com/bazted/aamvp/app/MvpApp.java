package com.bazted.aamvp.app;

import android.app.Application;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

/**
 * @author tbazyshyn
 * @version 1.0.0
 * @since 18.05.2015
 */
@EApplication
public class MvpApp extends Application {
    @Bean
    RestBean restBean;

    public RestBean getRestBean() {
        return restBean;
    }
}
