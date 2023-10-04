import java.util.ArrayList;

public class Candidato extends Ciudadano {
    
    private Orientacion orientacion;
    private Partido partido;
    private ArrayList<String> promesas;  
    
    public Candidato(String nombre, String cedula, Ciudades ciudad, Orientacion orientacion, Partido partido, ArrayList<String> promesas) {
        super(nombre, cedula, ciudad);
        this.orientacion = orientacion;
        this.partido = partido;
        this.promesas = promesas;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public ArrayList<String> getPromesas() {
        return promesas;
    }

    public void setPromesas(ArrayList<String> promesas) {
        this.promesas = promesas;
    }
}
