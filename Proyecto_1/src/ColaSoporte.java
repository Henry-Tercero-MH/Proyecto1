import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ColaSoporte extends ColaServicio{
    Scanner leer= new Scanner(System.in);

         static ArrayList<Tickect>colaSoporte=new ArrayList<>();
    public void agregarTicketsMesa(Tickect tickect) {

        colaSoporte.add(tickect);
    }


    /**
     * Metodo para ecalar ticket en la seccion de soporte
     */
    public void EscalarTicketS(){
       ColaDesarrollo colaDesarrollo=new ColaDesarrollo();
       colaDesarrollo.colaDesarrollo.add(colaSoporte.remove(0));

    }
    @Override
    public Tickect quitarTicket() {
        return getCola().remove(getCola().size());
    }
    public void TrabajarTicketSoporte(String nitUsuario){
        if (colaSoporte.isEmpty()){
            System.out.println("La lista esta vacia");

        }else{
            System.out.println("Ticket ");
            System.out.println("ID\t\t\tNIT\t\t\t\tMENSAJE\t\t\t\t\t\tESTADO");
            System.out.format(" %1d  %12S  %20s  %10s\n",
                    colaSoporte.get(0).getId(),
                    colaSoporte.get(0).getNitUsuario(),
                    colaSoporte.get(0).getProblema(),
                    colaSoporte.get(0).getEstado());
        }
        Date LocalDateTime = new Date();
        colaSoporte.get(getCola().size()).getId();
        String mensajeSolucion="";
        Bitacora listaSoporte = new Bitacora(nitUsuario, LocalDateTime, mensajeSolucion, TipoEvento.ASIGNAR);
        ArrayList<Bitacora> listaBitacoraSoporte=new ArrayList<>();
        listaBitacoraSoporte.add(listaSoporte);
        System.out.println("1.Dar solucion");
        System.out.println("2. Escalar ");
        System.out.println("3. Salir");
        System.out.println("---->");
        int op= leer.nextInt();
        switch (op){
            case 1:
                ColaAtendidos atendidos=new ColaAtendidos();
                System.out.println("Digite la solucion del problema:");
                String mensaje=leer.nextLine();
                atendidos.bitacoraAtendidos(nitUsuario,LocalDateTime,mensaje,TipoEvento.SOLUCIONADO);
                atendidos.colaAtendidos.add(getCola().remove(0));

            case 2:
                System.out.println("El Ticket fue escalado a la seccion de Desarrollo");
                EscalarTicketS();
                listaBitacoraSoporte.set(0, new Bitacora(nitUsuario, LocalDateTime, mensajeSolucion, TipoEvento.MOVER));
                break;
            default:
                break;
        }


    }
    void MosatrarTicketSoporte(){
        for (int i=0;i<colaSoporte.size();i++){
            System.out.format("%5d %5d    %12S       %20s         %10s\n",
                    i+1,
                    colaSoporte.get(i).getId(),
                    colaSoporte.get(i).getNitUsuario(),
                    colaSoporte.get(i).getProblema(),
                    colaSoporte.get(i).getEstado());
            System.out.println("................................................................");
            System.out.println("");
            System.out.println("");
        }
    }
}
