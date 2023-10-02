import java.util.ArrayList;
import java.util.Scanner;
public class Controller {
    private static Scanner console = new Scanner(System.in);
    private ArrayList <Candidato> listaCandidato = new ArrayList <Candidato>(); 

    public void menu(){
        //menu con bucle
        crear_candidato();
    }
    public void crear_candidato(){
        System.out.println("Ingrese el nombre del candidato: ");
        String nombre = console.nextLine();

        System.out.println("Ingrese el numero de cedula del candidato: " );
        String cedula = console.nextLine();

        System.out.println("Ingrese la ciudad del candidato (Solo son válidas ciudades del departamento del Valle del Cauca)");
        String ciudadInput = console.nextLine();
        Ciudades ciudad = Ciudades.valueOf(ciudadInput.toUpperCase());

        System.out.println("Ingrese la orientación política de su candidato (DERECHA o IZQUIERDA)");
        String orientacionInput = console.nextLine();
        Orientacion orientacion = Orientacion.valueOf(orientacionInput.toUpperCase());
        
        System.out.println("Ingrese el partido de su candidato");
        String partidoInput = console.nextLine();
        Orientacion partido = Orientacion.valueOf(orientacionInput.toUpperCase());
        
        System.out.println("Ingrese la promesa de su candidato " );
        String promesa = console.nextLine();

        listaCandidato.add(new Candidato(nombre, cedula, ciudad, orientacion, partido, promesa));
    }


    public void imprimirListaCandidatos() {
        for (Candidato candidato : listaCandidato) {
            System.out.println("Nombre: " + candidato.getNombre());
            System.out.println("Cédula: " + candidato.getCedula());
            System.out.println("Ciudad: " + candidato.getCiudad());
            System.out.println("Orientación política: " + candidato.getOrientacion());
            System.out.println("Partido político: " + candidato.getPartido());
            System.out.println("Promesa de campaña: " + candidato.getPromesa());
            System.out.println("---------------------------");
        }
    }

    public void actualizar_candidato(){

    }
}