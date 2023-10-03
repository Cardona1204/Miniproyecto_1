import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static Scanner console = new Scanner(System.in);
    private static ArrayList<Candidato> listaCandidato = new ArrayList<>();
    private static ArrayList<String> promesas = new ArrayList<>();

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
                    actualizarCandidato();
                    break;
                case 3:
                    eliminarCandidato();
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
    private static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Insertar candidatos (Se enlistaran automaticamente)");
        System.out.println("2. Actualizar candidato");
        System.out.println("3. Eliminar candidato");
        System.out.println("4. Buscar candidato");
        System.out.println("5. Imprimir lista de candidatos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }


    // Metodos opcion 1 crear candidato ( solo pasar al menu crearCandidatos )
    // Desde que se crean los datos se estan listando
    


    private static void crearCandidato() {
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
    
        System.out.println("¿Cuántas promesas de campaña tiene el candidato?");
        int numPromesas = console.nextInt();
        console.nextLine();  // Limpiar el buffer
    
        for (int i = 0; i < numPromesas; i++) {
            System.out.println("Ingrese la promesa de campaña " + (i + 1) + ": ");
            String promesa = console.nextLine();
            promesas.add(promesa);
        }

        listaCandidato.add(new Candidato(nombre, cedula, ciudad, orientacion, partido, promesas));
    }


    public static void datos_candidato(){
            //NO SE SABE EXACTAMENTE SI AYUDA EN ALGO 
            //EL PUNTO ES QUE TENGA LOS MENSAJES QUE SE LE PEDIRAN AL USUARIO
            //Updating
    }
    //Metodo opcion 2 actualizar candidato

    public static void actualizarCandidato() {
        for (int i = 0; i < listaCandidato.size(); i++) {
            System.out.println((i + 1) + "- " + listaCandidato.get(i).getNombre());
        }

        System.out.print("Ingrese el indice del candidato que desea actualizar: ");
        short indice = console.nextShort();

        crearCandidato();
        listaCandidato.get(indice-1);
    
        
                System.out.println("Datos actualizados para el candidato " + candidato.getNombre() + ".");
                break; 
            }
        }
    
        if (candidatoEncontrado == false) {
            System.out.println("No se encontro ningún candidato con el nombre proporcionado.");
        }
    }


    //Metodo opcion 3 eliminar candidato
    private static void eliminarCandidato() {
        System.out.print("Ingrese el nombre del candidato que desea eliminar: ");
        String nombreEliminar = console.nextLine();
        boolean candidatoEncontrado = false;
        Candidato candidatoAEliminar = null;
        for (Candidato candidato : listaCandidato) {
            if (candidato.getNombre().equalsIgnoreCase(nombreEliminar)) {
                candidatoAEliminar = candidato;
                candidatoEncontrado = true;
                break;
            }
        }
        if (candidatoEncontrado) {
            System.out.println("Datos del candidato a eliminar:");
            System.out.println("Nombre: " + candidatoAEliminar.getNombre());
            System.out.println("Cedula: " + candidatoAEliminar.getCedula());
            System.out.println("Ciudad: " + candidatoAEliminar.getCiudad());
            System.out.println("Orientacion politica: " + candidatoAEliminar.getOrientacion());
            System.out.println("Partido politico: " + candidatoAEliminar.getPartido());
            System.out.println("Promesas de campaña:");
            for (String promesa : candidatoAEliminar.getPromesas()) {
                System.out.println(" --- " + promesa);
            }
            System.out.println("---------------------------");
            System.out.print("¿Esta seguro de que desea eliminar este candidato? (Si/No): ");
            String confirmacion = console.nextLine();
            if (confirmacion.equalsIgnoreCase("Si")) {
                listaCandidato.remove(candidatoAEliminar);
                System.out.println("Candidato eliminado correctamente.");
            } else {
                System.out.println("Operación cancelada. El candidato no ha sido eliminado.");
            }
        } else {
            System.out.println("No se encontró ningún candidato con el nombre proporcionado.");
        }
    }


    //Metodo 4 buscar y mostrar candidato
    private static void buscarCandidato() {
        System.out.print("Ingrese el nombre del candidato que desea buscar: ");
        String nombreBuscar = console.nextLine();
    
        boolean candidatoEncontrado = false;
    
        for (Candidato candidato : listaCandidato) {
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscar)) {
                candidatoEncontrado = true;
    
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
                break; 
        }
        if (candidatoEncontrado == false) {
            System.out.println("No se encontro ningún candidato con el nombre proporcionado.");
        }
    }
}
    


    //Metodo 5 mostrar lista de candidatos

    private static void imprimirListaCandidatos() {
        int contadorCandidato =+ 1;

        for (Candidato candidato : listaCandidato) {
            System.out.println("---------------------------");
            System.out.println("Candidato "+contadorCandidato);
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
