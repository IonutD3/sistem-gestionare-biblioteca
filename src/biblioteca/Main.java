
package biblioteca;

/**
 * Clasa principala a aplicatiei.
 *
 * Contine metoda main() de la care porneste executia programului.
 */
public class Main {

    public static void main(String[] args) {

        // Cream serviciul care gestioneaza biblioteca.
        ServiciuBiblioteca biblioteca = new ServiciuBiblioteca();

        // Adaugam cartile in catalog.
        biblioteca.adaugaCarte(
                new Carte(1, "Java Programming", "James Gosling")
        );

        biblioteca.adaugaCarte(
                new Carte(2, "Clean Code", "Robert C. Martin")
        );

        biblioteca.adaugaCarte(
                new Carte(3, "Effective Java", "Joshua Bloch")
        );

        // Adaugam membrii bibliotecii.
        biblioteca.adaugaMembru(
                new Membru(1, "Ion Popescu")
        );

        biblioteca.adaugaMembru(
                new Membru(2, "Maria Ionescu")
        );

        // Afisam toate cartile.
        System.out.println("=== CARTI ===");
        biblioteca.afiseazaCarti();

        // Imprumutam cartea cu ID-ul 1
        // membrului cu ID-ul 1.
        System.out.println(
                "\nImprumut carte 1: "
                        + biblioteca.imprumutaCarte(1, 1)
        );

        // Imprumutam cartea cu ID-ul 2
        // membrului cu ID-ul 2.
        System.out.println(
                "Imprumut carte 2: "
                        + biblioteca.imprumutaCarte(2, 2)
        );

        // Afisam imprumuturile active.
        System.out.println("\n=== IMPRUMUTURI ===");
        biblioteca.afiseazaImprumuturi();

        // Cautam cartile care contin "Java" in titlu.
        System.out.println("\nCautare titlu 'Java':");

        biblioteca.cautaDupaTitlu("Java")
                .forEach(System.out::println);

        // Cautam cartile al caror autor contine "Martin".
        System.out.println("\nCautare autor 'Martin':");

        biblioteca.cautaDupaAutor("Martin")
                .forEach(System.out::println);

        // Returnam cartea cu ID-ul 1.
        System.out.println(
                "\nReturnare carte 1: "
                        + biblioteca.returneazaCarte(1)
        );

        // Afisam din nou imprumuturile active.
        System.out.println("\n=== IMPRUMUTURI ===");
        biblioteca.afiseazaImprumuturi();

        // Afisam catalogul dupa returnarea cartii.
        System.out.println("\n=== CARTI ===");
        biblioteca.afiseazaCarti();

        // Generam fisierul CSV.
        biblioteca.salveazaCartiInCsv("carti.csv");

        System.out.println("\nFisier CSV generat.");
    }
}
