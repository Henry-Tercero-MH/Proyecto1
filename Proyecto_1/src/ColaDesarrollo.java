import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ColaDesarrollo extends ColaServicio{
    static  ArrayList<Tickect>colaDesarrollo=new ArrayList<>();
    Scanner leer= new Scanner(System.in);
    public void agregarTicketsMesa(Tickect tickect) {

        colaDesarrollo.add(tickect);
    }

    int i=0;
    public int random() {
        int r = 0;
        for (int i = 0; i < colaDesarrollo.size();i++) {
            Random rd = new Random();
            r = rd.nextInt(colaDesarrollo.size());
        } return r;
    }
    public void TrabajarTicketSoporte(String nitUsuario){
            if (colaDesarrollo.isEmpty()){
            System.out.println("La lista esta vacia");

        }else{
                if (colaDesarrollo.size()==1){
                    System.out.println("Ticket ");
                    System.out.println("ID\t\t\tNIT\t\t\t\tMENSAJE\t\t\t\t\t\tESTADO");
                    System.out.format("%5d  %12S  %20s %10s\n",
                            colaDesarrollo.get(0).getId(),
                            colaDesarrollo.get(0).getNitUsuario(),
                            colaDesarrollo.get(0).getProblema(),
                            colaDesarrollo.get(0).getEstado());

                    //Es ciclo nos dara un numero ramdom el cual usaremos para trabajar un ticket

                    Date LocalDateTime = new Date();
                    colaDesarrollo.get(0);
                    String mensajeSolucion="";
                    Bitacora bitacoraTicketsDesarrollo = new Bitacora(nitUsuario, LocalDateTime, mensajeSolucion, TipoEvento.ASIGNAR);
                    System.out.println("1.Dar solucion");
                    System.out.println("2. Salir");
                    System.out.println("---->");
                    int op= leer.nextInt();
                    switch (op){
                        case 1:
                            ColaAtendidos atendidos=new ColaAtendidos();
                            System.out.println("Digite la solucion del problema:");
                            String mensaje=leer.nextLine();
                            atendidos.bitacoraAtendidos(nitUsuario,LocalDateTime,mensaje,TipoEvento.SOLUCIONADO);
                            atendidos.colaAtendidos.add(getCola().remove(random()));
                            break;
                        case 2:
                        default:
                            break;
                    }
                }
                else{
            System.out.println("Ticket ");
            System.out.println("ID\t\t\tNIT\t\t\t\tMENSAJE\t\t\t\t\t\tESTADO");
                    System.out.format(" %5d %12S %20s %  %10s\n",
                    colaDesarrollo.get(random()).getId(),
                    colaDesarrollo.get(random()).getNitUsuario(),
                    colaDesarrollo.get(random()).getProblema(),
                    colaDesarrollo.get(random()).getEstado());

        //Es ciclo nos dara un numero ramdom el cual usaremos para trabajar un ticket

            Date LocalDateTime = new Date();
            colaDesarrollo.get(random());
            String mensajeSolucion="";
            Bitacora bitacoraTicketsDesarrollo = new Bitacora(nitUsuario, LocalDateTime, mensajeSolucion, TipoEvento.ASIGNAR);
            System.out.println("1.Dar solucion");
            System.out.println("2. Salir");
            System.out.println("---->");
            int op= leer.nextInt();
            switch (op){
                case 1:
                    ColaAtendidos atendidos=new ColaAtendidos();
                    System.out.println("Digite la solucion del problema:");
                    String mensaje=leer.nextLine();
                    atendidos.bitacoraAtendidos(nitUsuario,LocalDateTime,mensaje,TipoEvento.SOLUCIONADO);
                    atendidos.colaAtendidos.add(getCola().remove(random()));
                    break;
                case 2:
                default:
                    break;
            }

        //fin del for
    }}}
    void MosatrarTicketsesarrollo(){
        for (int i=0;i<colaDesarrollo.size();i++){
            System.out.format("%5d %5d    %12S       %20s         %10s\n",
                    i+1,
                    colaDesarrollo.get(i).getId(),
                    colaDesarrollo.get(i).getNitUsuario(),
                    colaDesarrollo.get(i).getProblema(),
                    colaDesarrollo.get(i).getEstado());
            System.out.println("................................................................");
            System.out.println("");
            System.out.println("");
        }
    }
    @Override
    public Tickect quitarTicket() {
        return null;
    }
}
