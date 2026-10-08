
package biblioteca;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Gestioneaza cartile, membrii si imprumuturile bibliotecii.
 */
public class ServiciuBiblioteca {

    // Catalogul cartilor, asociate cu identificatorul lor.
    private final Map<Integer, Carte> carti = new LinkedHashMap<>();

    // Membrii bibliotecii, asociati cu identificatorul lor.
    private final Map<Integer, Membru> membri = new LinkedHashMap<>();

    // Lista imprumuturilor active.
    private final List<Imprumut> imprumuturi = new ArrayList<>();

    /**
     * Adauga o carte in catalog.
     *
     * @param carte cartea care va fi adaugata
     */
    public void adaugaCarte(Carte carte) {
        carti.put(carte.getId(), carte);
    }

    /**
     * Adauga un membru in biblioteca.
     *
     * @param membru membrul care va fi adaugat
     */
    public void adaugaMembru(Membru membru) {
        membri.put(membru.getId(), membru);
    }

    /**
     * Imprumuta o carte unui membru.
     *
     * Cartea poate fi imprumutata doar daca exista,
     * membrul exista si cartea este disponibila.
     *
     * @param idCarte identificatorul cartii
     * @param idMembru identificatorul membrului
     * @return true daca imprumutul a fost realizat,
     *         false in caz contrar
     */
    public boolean imprumutaCarte(int idCarte, int idMembru) {

        Carte carte = carti.get(idCarte);
        Membru membru = membri.get(idMembru);

        // Verificam existenta cartii, a membrului
        // si disponibilitatea cartii.
        if (carte == null || membru == null || !carte.esteDisponibila()) {
            return false;
        }

        // Cartea nu mai este disponibila.
        carte.seteazaDisponibilitatea(false);

        // Cream si salvam imprumutul.
        imprumuturi.add(new Imprumut(carte, membru));

        return true;
    }

    /**
     * Returneaza o carte imprumutata.
     *
     * @param idCarte identificatorul cartii
     * @return true daca returnarea a fost realizata,
     *         false daca nu exista un imprumut pentru carte
     */
    public boolean returneazaCarte(int idCarte) {

        // Parcurgem toate imprumuturile active.
        for (int i = 0; i < imprumuturi.size(); i++) {

            Imprumut imprumut = imprumuturi.get(i);

            // Verificam daca imprumutul apartine cartii cautate.
            if (imprumut.getCarte().getId() == idCarte) {

                // Cartea devine din nou disponibila.
                imprumut.getCarte().seteazaDisponibilitatea(true);

                // Eliminam imprumutul din lista.
                imprumuturi.remove(i);

                return true;
            }
        }

        return false;
    }

    /**
     * Cauta carti dupa titlu.
     *
     * Cautarea nu tine cont de litere mari si mici.
     *
     * @param text textul cautat
     * @return lista cartilor gasite
     */
    public List<Carte> cautaDupaTitlu(String text) {

        List<Carte> rezultat = new ArrayList<>();

        for (Carte carte : carti.values()) {

            if (carte.getTitlu()
                    .toLowerCase()
                    .contains(text.toLowerCase())) {

                rezultat.add(carte);
            }
        }

        return rezultat;
    }

    /**
     * Cauta carti dupa autor.
     *
     * Cautarea nu tine cont de litere mari si mici.
     *
     * @param text textul cautat
     * @return lista cartilor gasite
     */
    public List<Carte> cautaDupaAutor(String text) {

        List<Carte> rezultat = new ArrayList<>();

        for (Carte carte : carti.values()) {

            if (carte.getAutor()
                    .toLowerCase()
                    .contains(text.toLowerCase())) {

                rezultat.add(carte);
            }
        }

        return rezultat;
    }

    /**
     * Afiseaza toate cartile din catalog.
     */
    public void afiseazaCarti() {

        for (Carte carte : carti.values()) {
            System.out.println(carte);
        }
    }

    /**
     * Afiseaza toate imprumuturile active.
     */
    public void afiseazaImprumuturi() {

        for (Imprumut imprumut : imprumuturi) {

            System.out.printf(
                    "\"%s\" -> %s%n",
                    imprumut.getCarte().getTitlu(),
                    imprumut.getMembru().getNume()
            );
        }
    }

    /**
     * Salveaza catalogul cartilor intr-un fisier CSV.
     *
     * @param numeFisier numele fisierului CSV
     */
    public void salveazaCartiInCsv(String numeFisier) {

        try (FileWriter scriitor = new FileWriter(numeFisier)) {

            // Scriem antetul fisierului CSV.
            scriitor.write("id,titlu,autor,disponibila\n");

            // Scriem informatiile fiecarei carti.
            for (Carte carte : carti.values()) {

                scriitor.write(
                        String.format(
                                "%d,\"%s\",\"%s\",%s\n",
                                carte.getId(),
                                carte.getTitlu(),
                                carte.getAutor(),
                                carte.esteDisponibila()
                        )
                );
            }

        } catch (IOException e) {

            // Afisam mesajul in cazul unei erori.
            System.out.println(
                    "Nu s-a putut genera CSV: " + e.getMessage()
            );
        }
    }
}
