package org.mdv.model;

public class Recauto {
    private int id;
    private String propietario;
    private String matricula;
    private String anterior2000;
    private String motivo;
    private String fechaTaller;
    private String fechaAlta;
    private boolean estado;

    public Recauto() {

    }

    public Recauto(int id, String propietario, String matricula, String anterior2000, String motivo, String fechaTaller, String fechaAlta, boolean estado) {
        this.id = id;
        this.propietario = propietario;
        this.matricula = matricula;
        this.anterior2000 = anterior2000;
        this.motivo = motivo;
        this.fechaTaller = fechaTaller;
        this.fechaAlta = fechaAlta;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAnterior2000() {
        return anterior2000;
    }

    public void setAnterior2000(String anterior2000) {
        this.anterior2000 = anterior2000;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaTaller() {
        return fechaTaller;
    }

    public void setFechaTaller(String fechaTaller) {
        this.fechaTaller = fechaTaller;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Recauto{" +
                "id=" + id +
                ", propietario='" + propietario + '\'' +
                ", matricula='" + matricula + '\'' +
                ", anterior2000='" + anterior2000 + '\'' +
                ", motivo='" + motivo + '\'' +
                ", fechaTaller='" + fechaTaller + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", estado=" + estado +
                '}';
    }
}
