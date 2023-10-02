public class App {
    public static void main(String[] args) {
        // Crear una instancia de Controller
        Controller controller = new Controller();

        // Llamar a los métodos desde la instancia
        controller.menu();  // Llama al método del menú
        controller.imprimirListaCandidatos();  // Llama al método para imprimir la lista de candidatos
    }
}