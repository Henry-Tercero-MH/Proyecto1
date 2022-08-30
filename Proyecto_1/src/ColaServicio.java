import java.util.ArrayList;



public abstract class ColaServicio {

private ArrayList<Tickect> cola = new ArrayList<>();
    private Tickect ticket;

    public ArrayList<Tickect> getCola() {
        return cola;
    }

    public void setCola(ArrayList<Tickect> cola) {
        this.cola = cola;
    }
    public void agregarTickets(Tickect tickect){
        cola.add(0,ticket);
    }

    /**
     * Atribitos de la clase cola de servicio
     */


    TipoCola tipo;


void ListaTickets(){
    for (Tickect tickect:cola){
        System.out.format("%9d,%20s,%50s,%15s\n",
                tickect.getClass(),
                tickect.getId(),
                tickect.getNitUsuario(),
                tickect.getProblema(),
                tickect.getEstado());
    }

}


public abstract Tickect quitarTicket();


}