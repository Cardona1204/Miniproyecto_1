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
        System.out.println("Ingrese el nombre: ");
        String nombre = console.nextLine();

        System.out.println("Ingrese el numero de cedula: " );
        listaCandidato.add(new Candidato(nombre, nombre, null, 0, nombre, nombre));
    }

    public void actualizar_candidato(){
        
    }
}
