package co.mobiwise.android.baseproject.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jtoscano on 26/10/2015.
 */
public class Ciudades {

    @SerializedName("Nombre")
    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
