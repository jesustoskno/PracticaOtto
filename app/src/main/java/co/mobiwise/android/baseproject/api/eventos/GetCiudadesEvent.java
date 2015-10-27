package co.mobiwise.android.baseproject.api.eventos;

/**
 * Created by jtoscano on 26/10/2015.
 */
public class GetCiudadesEvent {

    private String nombreCiudades;

    public GetCiudadesEvent(String nombreCiudades) {
        this.nombreCiudades = nombreCiudades;
    }

    public String getNombreCiudades() {
        return nombreCiudades;
    }
}
