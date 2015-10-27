package co.mobiwise.android.baseproject.api;

import android.content.Context;

import java.util.List;

import co.mobiwise.android.baseproject.api.interfaces.INombreCiudades;
import co.mobiwise.android.baseproject.api.models.Ciudades;
import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by jtoscano on 26/10/2015.
 */
public class Client {

    private Context mContext;
    private static RestAdapter mRestAdapter;

    public Client(Context context){
        mContext=context;

        mRestAdapter= new RestAdapter.Builder()
                .setEndpoint("http://api.cinepolis.com.mx")
                .build();
    }

    public List<Ciudades> getCiudades(String nombre){
        INombreCiudades service = mRestAdapter.create(INombreCiudades.class);
        return service.listCiudades(nombre);
    }

    public void getCiudades(String nombre, Callback<List<Ciudades>> callback){
        INombreCiudades service = mRestAdapter.create(INombreCiudades.class);
        service.listCiudadesAsync(nombre, callback);
    }
}
