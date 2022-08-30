
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ColaMesa extends ColaServicio{
    static ArrayList<Tickect>colaMesa=new ArrayList<>();
    static ArrayList<Tickect>Todos=new ArrayList<>();

    public void agregarTicketsMesa(Tickect tickect) {

     colaMesa.add(tickect);
     Todos.add(tickect);
    }


    Scanner leer= new Scanner(System.in);

    @Override
    public void setCola(ArrayList<Tickect> cola) {
        super.setCola(cola);
    }

    ArrayList<Tickect>listaBitacoraMEsa=new ArrayList<>();
    /**
     * Esta clase recibe herencia de ColaServicio la cual es una clase abstracta,
     * con un metodo para quitar un elemento de la cola o eliminar. La cual es abstracta hija tambien
     */

    private static void menu(){
        System.out.println("________________________..Menu..______________________________");
        System.out.println("1.Dar solucion");
        System.out.println("2. Escalar ");
        System.out.println("3. Salir");
        System.out.println("---->");
    }
    public void TrabajarTicketMesa(String nitUsuario) {
        Date LocalDateTime = new Date();
        if (colaMesa.isEmpty()){
            System.out.println("La lista esta vacia");

    }else{
            System.out.println("Ticket ");
            System.out.println("ID\t\t\tNIT\t\t\t\tMENSAJE\t\t\t\t\t\tESTADO");
            System.out.format(" %1d    %12S       %20s         %10s\n",
                    colaMesa.get(0).getId(),
                    colaMesa.get(0).getNitUsuario(),
                    colaMesa.get(0).getProblema(),
                    colaMesa.get(0).getEstado());
        }


        String mensajeSolucion="";
        ArrayList<Bitacora> listaBitacoraMEsa=new ArrayList<>();
        Bitacora bitacoraTicketsMesa = new Bitacora(nitUsuario, LocalDateTime, mensajeSolucion, TipoEvento.ASIGNAR);
        listaBitacoraMEsa.add(bitacoraTicketsMesa);
        int exit=0;
        int opcion=0;

            menu();
            do {
                try {
                    opcion = (char) leer.nextInt();
                } catch (Exception e) {
                    System.out.println("Opcion no valida.");
                    leer = new Scanner(System.in);
                }
                System.out.println("...............\n");

                switch (opcion) {
                    case 1:
                        ColaAtendidos atendidos = new ColaAtendidos();
                        System.out.println("Digite la solucion del problema:");
                        leer.nextLine();
                        String mensaje = leer.nextLine();
                        colaMesa.get(0).setEstado("SOLUCINADO");
                        atendidos.bitacoraAtendidos(nitUsuario, LocalDateTime, mensaje, TipoEvento.SOLUCIONADO);
                        atendidos.colaAtendidos.add(getCola().remove(0));
                       opcion=3;
                    case 2:
                        System.out.println("El Ticket fue escalado a la seccion de Soporte");
                        EscalarTicket();
                        listaBitacoraMEsa.set(0, new Bitacora(nitUsuario, LocalDateTime, mensajeSolucion, TipoEvento.MOVER));
                        opcion=3;

                    case 3:
                        break;
                    default:
                        break;
                }//finaliza el while
                }while(opcion!=3);


    }
void MosatrarTicketsMesa(){
        if (Todos.isEmpty()){
            System.out.println("Esta vacio");
        }else{
        for (int i=0;i<Todos.size();i++){
            System.out.format("%5d %5d    %12S       %20s         %10s\n",
                    i+1,
                    Todos.get(i).getNitUsuario(),
                    Todos.get(i).getProblema(),
                    Todos.get(i).getEstado());
            System.out.println("................................................................");

        }
        }
}


public void EscalarTicket(){
        ColaSoporte colaSoporte=new ColaSoporte();
   colaSoporte.colaSoporte.add(colaMesa.remove(0));

}




    @Override
    public Tickect quitarTicket() {
        return getCola().remove(0);
    }
}
