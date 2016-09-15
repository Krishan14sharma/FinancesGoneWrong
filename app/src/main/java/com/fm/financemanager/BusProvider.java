package com.fm.financemanager;

import com.squareup.otto.Bus;

/**
 * Created by krishan sharma on 16/09/16.
 */

public class BusProvider {
    private static Bus bus = new Bus();
    public static Bus getBus() {
        return bus;
    }
}
