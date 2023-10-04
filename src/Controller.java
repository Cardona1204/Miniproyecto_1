import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static Scanner console = new Scanner(System.in);
    private ArrayList<Candidato> listaCandidato = new ArrayList<>();

    public void menu() {
        int opcion;

        do {
            mostrarMenu();
            opcion = console.nextInt();
            console.nextLine();

            switch (opcion) {
                case 1:
                    crearCandidato();
                    break;
                case 2:
                    actualizarCandidato(candidato_index());
                    break;
                case 3:
                    eliminarCandidato(candidato_index());
                    break;
                case 4:
                    buscarCandidato();
                    break;
                case 5:
                    imprimirListaCandidatos();
                    break;
                case 0:
                    System.out.println("Ha decidido salir del menu");
                    break;
                default:
                    System.out.println("Opcion no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    // Metodo para ver las opciones del menu :D
    private  void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Insertar candidatos");
        System.out.println("2. Actualizar candidato");
        System.out.println("3. Eliminar candidato");
        System.out.println("4. Buscar candidato");
        System.out.println("5. Imprimir lista de candidatos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private  void crearCandidato() {
        System.out.println("Ingrese el nombre del candidato: ");
        String nombre = console.nextLine();
    
        System.out.println("Ingrese el número de cédula del candidato: ");
        String cedula = console.nextLine();
    
        System.out.println("Ingrese la ciudad del candidato (Solo son válidas ciudades del departamento del Valle del Cauca)");
        String ciudad_ = console.nextLine();
        Ciudades ciudad = Ciudades.valueOf(ciudad_.toUpperCase());
    
        System.out.println("Ingrese la orientacion política de su candidato (DERECHA o IZQUIERDA)");
        String orientacion_ = console.nextLine();
        Orientacion orientacion = Orientacion.valueOf(orientacion_.toUpperCase());
    
        System.out.println("Ingrese el partido de su candidato");
        String partido_ = console.nextLine();
        Partido partido = Partido.valueOf(partido_.toUpperCase());
    

        listaCandidato.add(new Candidato(nombre, cedula, ciudad, orientacion, partido, menu_promesas()));
    }

    private ArrayList <String> menu_promesas(){
        ArrayList <String> promesa = new ArrayList<String>();
        while(true){
            System.out.println("Desea agregar una promesa? \n1- SI\n2- NO");
            if(console.nextInt()!=1){
        
                break;
            } 
            console.nextLine();
            System.out.println("Ingrese la propuesta: ");
            promesa.add(console.nextLine());
        }
        return promesa;
    }



    public void actualizarCandidato(int indice) {
        if(indice == -1){
            return;
        }
        Candidato candidato = listaCandidato.get(indice);
        System.out.println("Menu de actualizacion");
        


        listaCandidato.set(indice, menu_cambios(candidato));
    }

    private Candidato menu_cambios(Candidato candidato){
        byte eleccion;
        do {
            System.out.println("1- NOMBRE\n2- CEDULA\n3- CIUDAD\n4- ORIENTACION\n5- PARTIDO\n6- PROMESAS\n7- SALIR");
            eleccion = console.nextByte();
            console.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre: ");
                    candidato.setNombre(console.nextLine());
                    break;
                case 2:
                    System.out.println("Ingrese la nueva cedula: ");
                    candidato.setCedula(console.nextLine());
                    break;
                case 3:
                    System.out.println("Ingrese la nueva ciudad");
                    String ciudad_ = console.nextLine();
                    Ciudades ciudad = Ciudades.valueOf(ciudad_.toUpperCase());
                    candidato.setCiudad(ciudad);
                    break;
                case 4:
                    System.out.println("Ingrese nueva orientacion (DERECHA o IZQUIERDA)");
                    String orientacion_ = console.nextLine();
                    Orientacion orientacion = Orientacion.valueOf(orientacion_.toUpperCase());
                    candidato.setOrientacion(orientacion);
                    break;
                case 5:
                    System.out.println("Ingrese el partido de su candidato");
                    String partido_ = console.nextLine();
                    Partido partido = Partido.valueOf(partido_.toUpperCase());
                    candidato.setPartido(partido);
                    break;
                case 6:
                    candidato.setPromesas(menu_promesas());
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion no válida. Intente nuevamente.");
                    break;
            }
        } while (eleccion != 7);

        return candidato;
    }

    private int candidato_index(){
        if(listaCandidato.size()==0){
            System.out.println("No hay candidatos");
            return -1;
        }
        for (int i = 0; i < listaCandidato.size(); i++) {
            System.out.println((i + 1) + "- " + listaCandidato.get(i).getNombre());
        }

        System.out.print("Ingrese el indice del candidato que desea actualizar: ");
        short indice = console.nextShort();
        if(indice>0 && indice<= listaCandidato.size()){
            return indice-1;
        }
        return -1;
    }


    //Metodo opcion 3 eliminar candidato
    private void eliminarCandidato(int indice) {
        if(indice == -1){
            return;
        }
        Candidato candidato = listaCandidato.remove(indice);
        System.out.print("Se ha eliminado el candidato " + candidato.getNombre());
    }


    //Metodo 4 buscar y mostrar candidato
    private void buscarCandidato() {
        if(listaCandidato.size()==0){
            System.out.println("No hay candidatos");
            return;
        }
        System.out.print("Ingrese el nombre del candidato que desea buscar: ");
        String nombreBuscar = console.nextLine();
    
        for (Candidato candidato : listaCandidato) {
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscar)) {
    
                System.out.println("Datos del candidato:");
                System.out.println("Nombre: " + candidato.getNombre());
                System.out.println("Cedula: " + candidato.getCedula());
                System.out.println("Ciudad: " + candidato.getCiudad());
                System.out.println("Orientacion politica: " + candidato.getOrientacion());
                System.out.println("Partido político: " + candidato.getPartido());
                System.out.println("Promesas de campaña:");
                for (String promesa : candidato.getPromesas()) {
                    System.out.println(" --- " + promesa);
                }
                System.out.println("---------------------------");
                return; 
        }
        System.out.println("No se encontro ningún candidato con el nombre proporcionado.");

    }
}
    


    //Metodo 5 mostrar lista de candidatos

    private void imprimirListaCandidatos() {
        int contadorCandidato = 1;

        if(listaCandidato.size()==0){
            System.out.println("No hay candidatos");
            return;
        }
        for (Candidato candidato : listaCandidato) {
            System.out.println("---------------------------");
            System.out.println("Candidato "+ contadorCandidato);
            System.out.println("Nombre: " + candidato.getNombre());
            System.out.println("Cedula: " + candidato.getCedula());
            System.out.println("Ciudad: " + candidato.getCiudad());
            System.out.println("Orientación politica: " + candidato.getOrientacion());
            System.out.println("Partido politico: " + candidato.getPartido());
            System.out.println("Promesas de campaña:");
            for (String promesa : candidato.getPromesas()) {
                System.out.println(" --- " + promesa);
            }
            System.out.println("---------------------------");
            contadorCandidato++;
        }
    }
    
}
