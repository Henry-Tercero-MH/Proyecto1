import java.util.ArrayList;
import java.util.Date;

public class ColaAtendidos extends ColaServicio{

    ArrayList<Tickect> colaAtendidos=new ArrayList<>();
    ArrayList<Bitacora> bitacora=new ArrayList<>();
void bitacoraAtendidos(String nit, Date fecha,String mensaje,TipoEvento tipoEvento){

    Bitacora bitacoraAtendido= new Bitacora(nit,fecha,mensaje,tipoEvento);

    bitacora.add(bitacoraAtendido);

}

void mostrarBitacoraAtendidos(){
  for (int i=0;i<=bitacora.size();i++){
      System.out.println(bitacora.get(i).toString());
    }
}

    @Override
    public Tickect quitarTicket() {
        return null;
    }


}
