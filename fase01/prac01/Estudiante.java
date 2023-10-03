public class Estudiante {
    private int cui;
    private String correo;
    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private int[] fecha;
    private boolean genero;
    private String estado;

    public void setCui(int n) {
        this.cui = n;
    }

    public void setCorreo(String s) {
        this.correo = s;
    }

    public void setNombres(String s) {
        this.nombres = s;
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

    public String getNombres() {
        return this.nombres;
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
