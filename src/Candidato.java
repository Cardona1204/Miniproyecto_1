public class Candidato extends Ciudadano{
    private byte Der_Izq;
    private String partido, promesas;

    
    public Candidato(String nombre, String cedula, Ciudades ciudad, byte der_Izq, String partido, String promesas) {
        super(nombre, cedula, ciudad);
        Der_Izq = der_Izq;
        this.partido = partido;
        this.promesas = promesas;
    }


    public byte getDer_Izq() {
        return Der_Izq;
    }


    public void setDer_Izq(byte der_Izq) {
        Der_Izq = der_Izq;
    }


    public String getPartido() {
        return partido;
    }


    public void setPartido(String partido) {
        this.partido = partido;
    }


    public String getPromesas() {
        return promesas;
    }


    public void setPromesas(String promesas) {
        this.promesas = promesas;
    }

    

    
}
