package co.mobiwise.android.baseproject.api.eventos;

import java.util.List;

import co.mobiwise.android.baseproject.api.models.Ciudades;

/**
 * Created by jtoscano on 26/10/2015.
 */
public class SendCiudadesEvent {

    private boolean success;

    private List<Ciudades> nombres;

    private String message;

    public SendCiudadesEvent(boolean success, List<Ciudades> nombres, String message) {
        this.success = success;
        this.nombres = nombres;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<Ciudades> getNombres() {
        return nombres;
    }

    public String getMessage() {
        return message;
    }
}
