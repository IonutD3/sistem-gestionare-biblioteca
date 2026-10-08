
package biblioteca;

/**
 * Reprezinta un membru al bibliotecii.
 */
public class Membru {

    private final int id;
    private final String nume;

    /**
     * Construieste un membru.
     *
     * @param id identificatorul membrului
     * @param nume numele membrului
     */
    public Membru(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }
}
