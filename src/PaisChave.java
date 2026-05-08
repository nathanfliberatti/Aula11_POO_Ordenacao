import java.util.Objects;

public class PaisChave {

    private String pais;
    private String prova;
    private Genero genero;

    public PaisChave(String pais, String prova, Genero genero) {
        this.pais = pais;
        this.prova = prova;
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaisChave paisChave = (PaisChave) o;
        return Objects.equals(pais, paisChave.pais) && Objects.equals(prova, paisChave.prova) && genero == paisChave.genero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + pais.hashCode();
        hash = 31 * hash + prova.hashCode();
        hash = 31 * hash + genero.hashCode();
        return hash;
    }
}
