package co.mobiwise.android.baseproject.api.bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by jtoscano on 26/10/2015.
 */
public class BusProvider {

    private static Bus sBus;

    private BusProvider() {
        super();
    }

    public static Bus getInstance(){
        if(sBus == null){
            sBus = new Bus(ThreadEnforcer.ANY);
        }
        return sBus;
    }
}
