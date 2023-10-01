public class Ciudadano{
    private String nombre, cedula;
    private Ciudades ciudad;


    public Ciudadano(String nombre, String cedula, Ciudades ciudad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudad = ciudad;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCedula() {
        return cedula;
    }


    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public Ciudades getCiudad() {
        return ciudad;
    }


    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    
    
}