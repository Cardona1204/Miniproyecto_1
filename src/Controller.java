import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static Scanner console = new Scanner(System.in);
    private ArrayList<Candidato> listaCandidato = new ArrayList<>();

    public void menu(){
        crearCandidatos();
        buscarCandidato();
        
    }

    // Metodos opcion 1 crear candidato ( solo pasar al menu crearCandidatos )
     private void crearCandidatos() {
        int numCandidatos = obtenerNumeroCandidatos();
        for (int i = 0; i < numCandidatos; i++) {
            System.out.println("Ingresando candidato " + (i + 1) + " de " + numCandidatos);
            crearCandidato();
        }
    }

    private int obtenerNumeroCandidatos() {
        System.out.print("¿Cuántos candidatos quieres incluir? ");
        int numCandidatos = console.nextInt();
        console.nextLine(); 
        return numCandidatos;
    }

    private void crearCandidato() {
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
    
        ArrayList<String> promesas = new ArrayList<>();
        for (int i = 0; i < numPromesas; i++) {
            System.out.println("Ingrese la promesa de campaña " + (i + 1) + ": ");
            String promesa = console.nextLine();
            promesas.add(promesa);
        }
        listaCandidato.add(new Candidato(nombre, cedula, ciudad, orientacion, partido, promesas));
    }


    //Metodo opcion 2 actualizar candidato

    private void actualizarCandidato() {
        System.out.print("Ingrese el nombre del candidato que desea actualizar: ");
        String nombreBuscar = console.nextLine();
    
        boolean candidatoEncontrado = false;
        for (Candidato candidato : listaCandidato) {
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscar)) {
                candidatoEncontrado = true;
    
                System.out.println("Datos actuales del candidato:");
                System.out.println("Nombre: " + candidato.getNombre());
                System.out.println("Cedula: " + candidato.getCedula());
                System.out.println("Ciudad: " + candidato.getCiudad());
                System.out.println("Orientacion politica: " + candidato.getOrientacion());
                System.out.println("Partido politico: " + candidato.getPartido());
                System.out.println("Promesas de campaña:");
                for (String promesa : candidato.getPromesas()) {
                    System.out.println(" --- " + promesa);
                }
                System.out.println("---------------------------");
                System.out.println("Ingrese los nuevos datos para el candidato (o deje en blanco para mantener):");
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = console.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    candidato.setNombre(nuevoNombre);
                }
                System.out.print("Nueva cedula: ");
                String nuevaCedula = console.nextLine();
                if (!nuevaCedula.isEmpty()) {
                    candidato.setCedula(nuevaCedula);
                }
                System.out.print("Nueva ciudad: ");
                String nuevaCiudad_ = console.nextLine();
                if (!nuevaCiudad_.isEmpty()) {
                    Ciudades nuevaCiudad = Ciudades.valueOf(nuevaCiudad_.toUpperCase());
                    candidato.setCiudad(nuevaCiudad);
                }
                System.out.print("Nueva orientacion politica (DERECHA o IZQUIERDA): ");
                String nuevaOrientacion_ = console.nextLine();
                if (!nuevaOrientacion_.isEmpty()) {
                    Orientacion nuevaOrientacion = Orientacion.valueOf(nuevaOrientacion_.toUpperCase());
                    candidato.setOrientacion(nuevaOrientacion);
                }
                System.out.print("Nuevo partido politico: ");
                String nuevoPartido_ = console.nextLine();
                if (!nuevoPartido_.isEmpty()) {
                    Partido nuevoPartido = Partido.valueOf(nuevoPartido_.toUpperCase());
                    candidato.setPartido(nuevoPartido);
                }
                System.out.print("¿Desea actualizar las promesas de campaña? (Si/No): ");
                String actualizarPromesas_ = console.nextLine();
                if (actualizarPromesas_.equalsIgnoreCase("Si")) {
                    System.out.print("¿Cuántas nuevas promesas de campaña tiene el candidato?");
                    int numNuevasPromesas = console.nextInt();
                    console.nextLine();  
                    ArrayList<String> nuevasPromesas = new ArrayList<>();
                    for (int i = 0; i < numNuevasPromesas; i++) {
                        System.out.println("Ingrese la promesa de campaña " + (i + 1) + ": ");
                        String promesa = console.nextLine();
                        nuevasPromesas.add(promesa);
                    }
                    candidato.setPromesas(nuevasPromesas);
                }
                System.out.println("Datos actualizados para el candidato " + candidato.getNombre() + ".");
                break; 
            }
        }
    
        if (candidatoEncontrado == false) {
            System.out.println("No se encontro ningún candidato con el nombre proporcionado.");
        }
    }


    //Metodo opcion 3 eliminar candidato
    private void eliminarCandidato() {
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
    private void buscarCandidato() {
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

    private void imprimirListaCandidatos() {
        int contadorCandidato =+ 1;

        for (Candidato candidato : listaCandidato) {
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
