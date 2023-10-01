import java.util.ArrayList;
import java.util.Scanner;
public class Controller {
    private static Scanner console = new Scanner(System.in);
    private ArrayList <Candidato> listaCandidato = new ArrayList <Candidato>(); 

    public void menu(){
        //menu con bucle
    }
    public void crear_candidato(){
        System.out.println("Ingrese el nombre");
        String nombre = console.nextLine();
        listaCandidato.add(new Candidato(nombre, nombre, null, 0, nombre, nombre));
    }
}
