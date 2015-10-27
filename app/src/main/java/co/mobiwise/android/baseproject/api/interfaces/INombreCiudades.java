package co.mobiwise.android.baseproject.api.interfaces;

import java.util.List;

import co.mobiwise.android.baseproject.api.models.Ciudades;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by jtoscano on 26/10/2015.
 */
public interface INombreCiudades {
    @GET("/Consumo.svc/json/{ObtenerCiudades}")
    List<Ciudades> listCiudades(@Path("ObtenerCiudades")String Nombre);

    @GET("/Consumo.svc/json/{ObtenerCiudades}")
    void listCiudadesAsync(@Path("ObtenerCiudades")String Nombre, Callback<List<Ciudades>> callback);
}
