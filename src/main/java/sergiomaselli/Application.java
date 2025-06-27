package sergiomaselli;

import entities.Collezione;
import entities.Gioco;
import entities.GiocoDaTavolo;
import entities.Videogioco;
import enums.Genere;

import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();
        boolean inEsecuzione = true;

        while (inEsecuzione) {
            System.out.println("""
                    1. Aggiungi Gioco
                    2. Ricerca per ID
                    3. Ricerca per Prezzo
                    4. Ricerca per Numero Giocatori
                    5. Rimuovi Gioco per ID
                    6. Aggiorna Prezzo Gioco per ID
                    7. Statistiche
                    8. Mostra Tutti i Giochi
                    0. Esci
                    Scegli un'opzione:
                    """);

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1 -> {
                    System.out.println("1 = Videogioco, 2 = Gioco da tavolo:");
                    int tipo = Integer.parseInt(scanner.nextLine());

                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Anno: ");
                    int anno = Integer.parseInt(scanner.nextLine());
                    System.out.print("Prezzo: ");
                    double prezzo = Double.parseDouble(scanner.nextLine());

                    Gioco gioco = null;

                    if (tipo == 1) {
                        System.out.print("Piattaforma: ");
                        String piattaforma = scanner.nextLine();
                        System.out.print("Durata: ");
                        int durata = Integer.parseInt(scanner.nextLine());
                        System.out.print("Genere (AZIONE, AVVENTURA, HORROR, FANTASY): ");
                        Genere genere = Genere.valueOf(scanner.nextLine().toUpperCase());

                        gioco = new Videogioco(id, titolo, anno, prezzo, piattaforma, durata, genere);
                    } else {
                        System.out.print("Numero giocatori: ");
                        int giocatori = Integer.parseInt(scanner.nextLine());
                        System.out.print("Durata media partita (minuti): ");
                        int durata = Integer.parseInt(scanner.nextLine());

                        gioco = new GiocoDaTavolo(id, titolo, anno, prezzo, giocatori, durata);
                    }

                    boolean success = collezione.aggiungiElemento(gioco);
                    if (success) {
                        System.out.println("Gioco aggiunto CON SUCCESSO!");
                    } else {
                        System.out.println("ID già esistente!");
                    }
                }


                case 2 -> {
                    System.out.print("Inserisci ID: ");
                    String id = scanner.nextLine();
                    Optional<Gioco> risultato = collezione.ricercaPerId(id);
                    if (risultato.isPresent()) {
                        System.out.println(risultato.get());
                    } else {
                        System.out.println("Gioco non trovato.");
                    }
                }


                case 3 -> {
                    System.out.print("Prezzo massimo: ");
                    double max = Double.parseDouble(scanner.nextLine());
                    collezione.ricercaPerPrezzo(max).forEach(System.out::println);
                }

                case 4 -> {
                    System.out.print("Numero di giocatori: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    collezione.ricercaPerNumeroGiocatori(num).forEach(System.out::println);
                }

                case 0 -> {
                    inEsecuzione = false;
                    System.out.println("Uscita...");
                }

                default -> System.out.println("Scelta non valida.");
            }


        }
    }
}
