package co.mobiwise.android.baseproject.api;

import android.app.Application;

import com.squareup.otto.Bus;

import co.mobiwise.android.baseproject.api.bus.BusProvider;
import co.mobiwise.android.baseproject.api.bus.Manager;

/**
 * Created by jtoscano on 26/10/2015.
 */
public class Aplicacion extends Application {

    private Bus mBus = BusProvider.getInstance();
    private Manager mManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mManager=Manager.getInstance(this);
    }
}
