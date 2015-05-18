package com.bazted.aamvp.event;

/**
 * @author tbazyshyn
 * @version 1.0.0
 * @since 18.05.2015
 */
public class EventListModel {

    public String[] getDummyInfoFromServer() {
        final String[] strings = new String[20];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "TEST+" + i;
        }
        return strings;
    }

}
