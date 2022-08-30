import java.util.Date;

public class Bitacora {
    /**
     * Atributos de la clase bitacora
     */
    private String nitSoporte;
    private Date fechaHora;
    private String mensaje;
    private TipoEvento evento;

    public Bitacora(String nitSoporte, Date fechaHora, String mensaje, TipoEvento evento) {
        this.nitSoporte = nitSoporte;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.evento = evento;
    }

    public Bitacora() {

    }

    /**
     * Metodos getters
     */

    public String getNitSoporte() {
        return nitSoporte;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public TipoEvento getEvento() {
        return evento;
    }

    /**
     * Metodos getters
     */
    public void setNitSoporte(String nitSoporte) {
        this.nitSoporte = nitSoporte;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setEvento(TipoEvento evento) {
        this.evento = evento;
    }


    /**
     * Metodo para mostrar los datos de la clase bitácora
     */

    void mostrarDatos() {

        System.out.println("-----------------------------------------------------------------------");
        System.out.format("%20s  %20d  %50s  %12s\n",
                nitSoporte, fechaHora, mensaje, evento);

    }
}
