import java.util.ArrayList;
import java.util.Date;

public class Tickect {
    /**
     * Atributos de la clase Tickect
     */
    private static int id=0;

    private  String nitUsuario;

    private String problema;
    private   String estado;

    /**
     * Creamos una lista de arreglos de tipo bitacora
     */
   // Bitacora nuevaBitacora = new Bitacora();

    ArrayList<Bitacora> ListaBitacora = new ArrayList<>();

/**
 * Metodo contructor
 */
public Tickect(){

}
    public  Tickect(String nitUsuario, String problema) {
        id++;
        this.id = id;
        this.nitUsuario = nitUsuario;
        this.problema = problema;
        this.estado = String.valueOf(TipoEvento.CREADO);
        /**
         * Al agregar un ticket por defecto se crea un evento en la bitacora de los tickets nuevos
         */

        Date LocalDateTime = new Date();
        Bitacora bitacoraTickets = new Bitacora(nitUsuario,LocalDateTime,problema,TipoEvento.CREADO);
ListaBitacora.add(bitacoraTickets);

    }

    public Tickect(String ticket, String nitUsuario, String problema, String cola) {
    }

    /**
     * Metodos getters
     */
    public String getNitUsuario() {
        return nitUsuario;
    }

    public int getId() {
        return id;
    }

    public String getProblema() {
        return problema;
    }

    public String getEstado() {
        return estado;
    }


    /**
     * Metodos setters
     */
    public void setNitUsuario(String nitUsuario) {
        this.nitUsuario = nitUsuario;
    }

    public void setNit(int id) {
        this.id = id;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    /**
     *Método para mostrar los datos en pantalla de la clasee ticket
     */
    @Override
    public String toString() {
        return "Tickect{" +
                "nitUsuario='" + nitUsuario + '\'' +
                ", problema='" + problema + '\'' +
                ", estado='" + estado + '\'' +
                ", ListaBitacora=" + ListaBitacora +
                '}';
    }
}
