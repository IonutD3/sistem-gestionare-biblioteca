
package biblioteca;

/**
 * Reprezinta un imprumut din biblioteca.
 *
 * Un imprumut face legatura intre o carte
 * si membrul care a imprumutat-o.
 */
public class Imprumut {

    private final Carte carte;
    private final Membru membru;

    /**
     * Construieste un imprumut.
     *
     * @param carte cartea imprumutata
     * @param membru membrul care a imprumutat cartea
     */
    public Imprumut(Carte carte, Membru membru) {
        this.carte = carte;
        this.membru = membru;
    }

    public Carte getCarte() {
        return carte;
    }

    public Membru getMembru() {
        return membru;
    }
}
