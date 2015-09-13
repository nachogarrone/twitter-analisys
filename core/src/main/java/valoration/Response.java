package valoration;

public class Response {

    private Integer intensidad;
    private Integer certidumbre;
    private String ponderacion;
    private String texto;

    public Integer getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(Integer intensidad) {
        this.intensidad = intensidad;
    }

    public Integer getCertidumbre() {
        return certidumbre;
    }

    public void setCertidumbre(Integer certidumbre) {
        this.certidumbre = certidumbre;
    }

    public String getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(String ponderacion) {
        this.ponderacion = ponderacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
