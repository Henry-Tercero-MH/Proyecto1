import java.util.Scanner;

public class Main {
    private static void menu(){
        System.out.println("________________________..Menu..______________________________");
        System.out.println("1. Crear Ticket");
        System.out.println("2. Trabajar Ticket");
        System.out.println("3. Reporte 1");
        System.out.println("4 Reporte 2");
        System.out.println("5. Reporte 3");
        System.out.println("6. Cargar Datos Json");
        System.out.println("...............\n");
        System.out.println("Ingrese una opcion: ");
    }
    public static class Mod11Nit {
        public boolean validacionNit(String nit) {
            boolean valor = false;
            boolean valor2 = false;
            boolean valido = false;
            int digitoVerificador = 0;
            int n;
            String verificar = "";
            String cadena = "";
            int factor = 8765432;
            int suma = 0;
            //condicional si el nit ingresado cumple con el requisito de 8 digitos
            if (nit.length() == 8) {
                //ciclo para capturar solamente los primeros 7 digitos del nit, para validarlo con el ultimo digito
                for (int j = 0; j < nit.length() - 1; j++) {
                    String num1 = String.valueOf(nit.charAt(j));
                    verificar += num1;
                }

                System.out.println(verificar);
                n = Integer.parseInt(verificar);
                // ciclo para validar realizar la operacion de cada numero del nit multiplicado por el factor 2,3,4,5,6,7,8
                for (int i = 0; i < verificar.length(); i++) {
                    String num = String.valueOf(Integer.toString(n).charAt(i));
                    String num2 = String.valueOf(Integer.toString(factor).charAt(i));
                    suma += Integer.parseInt(num) * Integer.parseInt(num2);
                    num = "";
                }

                //Operacion digito verificador mod 11
                suma = suma % 11;
                digitoVerificador = 11 - suma;
               // System.out.println("Digito verificador");
               // System.out.println(digitoVerificador);
                String dig = "" + String.valueOf(digitoVerificador);
//si el digito verificador es igual al ultimo digito, sera valido
                if (dig.charAt(0) == nit.charAt(7)) {
                    valor = true;

                } else {
                    System.out.println("El nit no es valido");
                }
                // si no es valido el programa volvera a pedir el nit valido
            } else {
                System.out.println(" Ingrese numeros enteros, la longitud es incorrecta ingrese 8 digitos");
            }
            if (valor == true) {
                valido = true;
                System.out.println("NIT valido");

            } else {
                System.out.println("NIT Invalido");
                valido = false;
            }
            return valido;
        }

    }

    static Scanner leer = new Scanner(System.in);

Mod11Nit mod11Nit= new Mod11Nit();
    public static void main(String[] args) {

        /**
         * Importarmos el paquete de google Gson para leer el archivo json
         */
        int exit=0;
        int opcion=0;
        while (exit!=1){
            menu();
            try {
                opcion = (char) leer.nextInt();
            } catch (Exception e) {
                System.out.println("Opcion no valida.");
                leer = new Scanner(System.in);
            }

        System.out.println("...............\n");

            switch (opcion) {
                case 1:
                    /**
                     * Metodos que nos permite registrar un nuevo Ticket
                     */
                    System.out.println("Digite su NIT:");
                    leer.nextLine();
                    String nitUsuario = leer.nextLine();
                    Mod11Nit nuevoNIT = new Mod11Nit();
                    nuevoNIT.validacionNit(nitUsuario);
                    System.out.println("Digite el problema:");
                    String problema = leer.nextLine();
                    Tickect nuevoT=new Tickect(nitUsuario,problema);
                  ColaMesa nuevaCola = new ColaMesa();
                  nuevaCola.agregarTicketsMesa(nuevoT);
                  

                    System.out.println("Ticket se agrego con exito: ");

                    break;

                case 2:
                    System.out.println("_-______-----_---__--_-___-_..BIENVENIDO AL SISTEMA.._____---__-__-__----_--_--_---__");
                    System.out.println("Digite su NIT:");
                    leer.nextLine();
                    String nit = leer.nextLine();
                    Mod11Nit nuevo = new Mod11Nit();
                    nuevo.validacionNit(nit);
                    System.out.println("Cual es su rol en las siguientes Colas: ");
                    System.out.println("--------------------------------");
                    System.out.println("MesaAyuda = Mesa");
                    System.out.println("Soporte Tecnico = Soporte");
                    System.out.println("Desarrollador = Desarrollador");
                    System.out.println("--------------------------------");
                    TipoCola tipoCola = TipoCola.valueOf(leer.nextLine().toUpperCase());
                    if (tipoCola==(TipoCola.MESA)) {
                        ColaMesa colaM = new ColaMesa();
                        colaM.TrabajarTicketMesa(nit);
                    }
                    if (tipoCola.equals(TipoCola.SOPORTE)) {
                        ColaSoporte colaSoporte = new ColaSoporte();
                        colaSoporte.TrabajarTicketSoporte(nit);
                    }
                    if (tipoCola.equals(TipoCola.DESARROLLADOR)) {
                        ColaDesarrollo colaDesarrollo = new ColaDesarrollo();
                        colaDesarrollo.TrabajarTicketSoporte(nit);
                    }

                    break;

                case 3:
                    System.out.println("Listado General de Tickets:");
                    System.out.println("No.\tID\t\t\tNIT\t\t\t\tMENSAJE\t\t\t\t\t\tESTADO");
                    ColaMesa colaM = new ColaMesa();
                    colaM.MosatrarTicketsMesa();

                    break;

                case 4:
                    System.out.println("Cola Mesa de Ayuda:");
                    System.out.println("No.\tID\t\t\tNIT\t\t\t\tMENSAJE\t\t\t\t\t\tESTADO");
                    ColaMesa cola = new ColaMesa();
                    cola.MosatrarTicketsMesa();
                    System.out.println(".......................................................");
                    System.out.println("Cola Soporte Tecnico:");
                    System.out.println("No.\tID\t\t\tNIT\t\t\t\tMENSAJE\t\t\t\t\t\tESTADO");
                    ColaSoporte colaSoporte=new ColaSoporte();
                    colaSoporte.MosatrarTicketSoporte();
                    System.out.println(".......................................................");
                    System.out.println("Cola Soporte Desarrollador");
                    System.out.println("No.\tID\t\t\tNIT\t\t\t\tMENSAJE\t\t\t\t\t\tESTADO");
                    ColaDesarrollo colaDesarrollo=new ColaDesarrollo();
                    colaDesarrollo.MosatrarTicketsesarrollo();
                    System.out.println(".......................................................");
                    break;

                case 5:
                    break;

                case 6:
                    break;
                default:
                    break;
            }


        }//finaliza el while

    }//finaliza el main






    /**
     * Metodos
     */
    public void validarNit(String nit) {
        Mod11Nit modNit = new Mod11Nit();
        boolean valor1 = false;
        //inicia la validacion del nit
        do {

            nit = leer.nextLine();
            if (modNit.validacionNit(nit)) {
                valor1 = true;
            }
        } while (!valor1);//termina la validacion de nit
    }

    private static class agregarTickets {
        public agregarTickets(Tickect nuevoT) {
        }
    }


    /**
     * Se solicita el nit del departamento que dara soporte y el tipo de departamento
     */


}