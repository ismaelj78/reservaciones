
import java.util.Date;


public class campos_altas {
    String fecha;
    String laboratorio;
    String hora;
    int id_usuario;

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
     public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public campos_altas(String fecha, String laboratorio, String hora, int id_usuario) {
        this.fecha = fecha;
        this.laboratorio = laboratorio;
        this.hora = hora;
        this.id_usuario = id_usuario;
    }
    
}
