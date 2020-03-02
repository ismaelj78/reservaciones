
import java.util.Date;


public class campos_altas {
    String fecha;
    String laboratorio;
    String hora;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public campos_altas(String fecha, String laboratorio, String hora) {
        this.fecha = fecha;
        this.laboratorio = laboratorio;
        this.hora = hora;
    }
    
}
