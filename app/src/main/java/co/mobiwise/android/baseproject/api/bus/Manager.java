package co.mobiwise.android.baseproject.api.bus;

import android.content.Context;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import co.mobiwise.android.baseproject.R;
import co.mobiwise.android.baseproject.api.Client;
import co.mobiwise.android.baseproject.api.eventos.GetCiudadesEvent;
import co.mobiwise.android.baseproject.api.eventos.SendCiudadesEvent;
import co.mobiwise.android.baseproject.api.models.Ciudades;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jtoscano on 26/10/2015.
 */
public class Manager {

    private static Manager instance;

    private Context mContext;
    private Bus mBus = BusProvider.getInstance();
    private Client mClient;

    public static Manager getInstance(Context context){
        if(instance == null){
            instance = new Manager(context);
        }
        return instance;
    }
    public Manager(Context context) {
        mContext = context;
        mBus.register(this);
        mClient = new Client(context);
    }

    @Subscribe
    public void onGetCiudadesEvent(GetCiudadesEvent getCiudadesEvent){
        Callback<List<Ciudades>> getCiudadesCallback = new Callback<List<Ciudades>>() {
            @Override
            public void success(List<Ciudades> ciudades, Response response) {
                mBus.post(new SendCiudadesEvent(true, ciudades, null));
            }

            @Override
            public void failure(RetrofitError error) {
                mBus.post(new SendCiudadesEvent(false, null, mContext.getString(R.string.error_ciudades) + error.getKind()));
            }
        };

        mClient.getCiudades(getCiudadesEvent.getNombreCiudades(), getCiudadesCallback);
    }
}
