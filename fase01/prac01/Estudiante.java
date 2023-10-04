public class Estudiante {
    private int cui;
    private String correo;
    private String nombre;
    private String sNombre;
    private String apPaterno;
    private String apMaterno;
    private int[] fecha = new int[3];
    private boolean genero;
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

    public void setFecha(int y, int m, int d) {
        this.fecha[0] = y;
        this.fecha[1] = m;
        this.fecha[2] = d;
    }

    public void setGenero(boolean b) {
        this.genero = b;
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

    public int[] getFecha() {
        return this.fecha;
    }

    public boolean getGenero() {
        return this.genero;
    }

    public String getEstado() {
        return this.estado;
    }
}
