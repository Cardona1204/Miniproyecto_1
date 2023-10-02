public class Candidato extends Ciudadano{
    
    private Orientacion orientacion;
    private String partido, promesas;


    public Candidato(String nombre, String cedula, Ciudades ciudad, Orientacion orientacion, Orientacion partido2,String promesas) {
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


    public String getPartido() {
        return partido;
    }


    public void setPartido(String partido) {
        this.partido = partido;
    }


    public String getPromesa() {
        return promesas;
    }


    public void setPromesas(String promesas) {
        this.promesas = promesas;
    }

}