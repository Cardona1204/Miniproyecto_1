import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static Scanner console = new Scanner(System.in);
    private ArrayList<Candidato> listaCandidato = new ArrayList<>();

    public void menu(){
        
        actualizarCandidato();
        
    }

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
        String ciudadInput = console.nextLine();
        Ciudades ciudad = Ciudades.valueOf(ciudadInput.toUpperCase());
    
        System.out.println("Ingrese la orientación política de su candidato (DERECHA o IZQUIERDA)");
        String orientacionInput = console.nextLine();
        Orientacion orientacion = Orientacion.valueOf(orientacionInput.toUpperCase());
    
        System.out.println("Ingrese el partido de su candidato");
        String partidoInput = console.nextLine();
        Partido partido = Partido.valueOf(partidoInput.toUpperCase());
    
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


    public void actualizarCandidato() {
        System.out.print("Ingrese el nombre del candidato que desea actualizar: ");
        String nombreBuscar = console.nextLine();
    
        boolean candidatoEncontrado = false;
        for (Candidato candidato : listaCandidato) {
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscar)) {
                candidatoEncontrado = true;
    
                System.out.println("Datos actuales del candidato:");
                System.out.println("Nombre: " + candidato.getNombre());
                System.out.println("Cédula: " + candidato.getCedula());
                System.out.println("Ciudad: " + candidato.getCiudad());
                System.out.println("Orientación política: " + candidato.getOrientacion());
                System.out.println("Partido político: " + candidato.getPartido());
                System.out.println("Promesas de campaña:");
                for (String promesa : candidato.getPromesas()) {
                    System.out.println(" - " + promesa);
                }
                System.out.println("---------------------------");
    
                System.out.println("Ingrese los nuevos datos para el candidato (o deje en blanco para mantener):");
    
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = console.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    candidato.setNombre(nuevoNombre);
                }
    
                System.out.print("Nueva cédula: ");
                String nuevaCedula = console.nextLine();
                if (!nuevaCedula.isEmpty()) {
                    candidato.setCedula(nuevaCedula);
                }
    
                System.out.print("Nueva ciudad: ");
                String nuevaCiudadInput = console.nextLine();
                if (!nuevaCiudadInput.isEmpty()) {
                    Ciudades nuevaCiudad = Ciudades.valueOf(nuevaCiudadInput.toUpperCase());
                    candidato.setCiudad(nuevaCiudad);
                }
    
                System.out.print("Nueva orientación política (DERECHA o IZQUIERDA): ");
                String nuevaOrientacionInput = console.nextLine();
                if (!nuevaOrientacionInput.isEmpty()) {
                    Orientacion nuevaOrientacion = Orientacion.valueOf(nuevaOrientacionInput.toUpperCase());
                    candidato.setOrientacion(nuevaOrientacion);
                }
    
                System.out.print("Nuevo partido político: ");
                String nuevoPartidoInput = console.nextLine();
                if (!nuevoPartidoInput.isEmpty()) {
                    Partido nuevoPartido = Partido.valueOf(nuevoPartidoInput.toUpperCase());
                    candidato.setPartido(nuevoPartido);
                }
    
                System.out.print("¿Desea actualizar las promesas de campaña? (Sí/No): ");
                String actualizarPromesasInput = console.nextLine();
                if (actualizarPromesasInput.equalsIgnoreCase("Sí")) {
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
            System.out.println("No se encontró ningún candidato con el nombre proporcionado.");
        }
    }
    
    

    private void imprimirListaCandidatos() {
        int contadorCandidato =+ 1;

        for (Candidato candidato : listaCandidato) {
            System.out.println("Candidato "+contadorCandidato);
            System.out.println("Nombre: " + candidato.getNombre());
            System.out.println("Cédula: " + candidato.getCedula());
            System.out.println("Ciudad: " + candidato.getCiudad());
            System.out.println("Orientación política: " + candidato.getOrientacion());
            System.out.println("Partido político: " + candidato.getPartido());
            System.out.println("Promesas de campaña:");
            for (String promesa : candidato.getPromesas()) {
                System.out.println(" --- " + promesa);
            }
            System.out.println("---------------------------");
            contadorCandidato++;
        }
    }
    
}
