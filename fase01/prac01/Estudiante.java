public class Estudiante {
    private int cui;
    private String correo;
    private String nombre;
    private String sNombre;
    private String apPaterno;
    private String apMaterno;
    private String fecha;
    private String genero;
    private String estado;

    public void setCui(int n) {
        this.cui = n;
    }

    public void setCorreo(String s) {
        this.correo = s;
    }

    public void setNombre(String s) {
        this.nombre = s;
    }

    public void setSNombre(String s) {
        this.sNombre = s;
    }

    public void setApPaterno(String s) {
        this.apPaterno = s;
    }

    public void setApMaterno(String s) {
        this.apMaterno = s;
    }

    public void setFecha(String s) {
        this.fecha = s;
    }

    public void setGenero(boolean b) {
        if (b) {
            this.genero = "Masculino";
        } else {
            this.genero = "Femenino";
        }
    }

    public void setEstado(boolean b) {
        if (b) {
            this.estado = "Activo";
        } else {
            this.estado = "Deshabilitado";
        }
    }

    public int getCui() {
        return this.cui;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getSNombre() {
        return this.sNombre;
    }

    public String getApPaterno() {
        return this.apPaterno;
    }

    public String getApMaterno() {
        return this.apMaterno;
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getEstado() {
        return this.estado;
    }
}
