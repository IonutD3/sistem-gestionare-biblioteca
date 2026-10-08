
package biblioteca;

/**
 * Reprezinta o carte din biblioteca.
 */
public class Carte {

    private final int id;
    private final String titlu;
    private final String autor;
    private boolean disponibila = true;

    /**
     * Construieste o carte.
     *
     * @param id identificatorul cartii
     * @param titlu titlul cartii
     * @param autor autorul cartii
     */
    public Carte(int id, String titlu, String autor) {
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public boolean esteDisponibila() {
        return disponibila;
    }

    public void seteazaDisponibilitatea(boolean disponibila) {
        this.disponibila = disponibila;
    }

    /**
     * Returneaza informatiile despre carte.
     */
    @Override
    public String toString() {
        return String.format(
                "%d | %s | %s | %s",
                id,
                titlu,
                autor,
                disponibila ? "Disponibila" : "Imprumutata"
        );
    }
}
