package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collezione {
    private List<Gioco> giochi;

    public Collezione() {
        giochi = new ArrayList<>();
    }

//    public void preAddGame() {
//        aggiungiElemento(new Videogioco("V100", "Zelda", 2017, 59.99, "Switch", 40, Genere.AVVENTURA));
//        aggiungiElemento(new GiocoDaTavolo("G200", "Monopoly", 2000, 29.99, 4, 90));
//        aggiungiElemento(new Videogioco("V101", "Resident Evil", 2020, 49.99, "PC", 30, Genere.HORROR));
//        aggiungiElemento(new GiocoDaTavolo("G201", "Dixit", 2015, 35.50, 6, 60));
//    }

    //1)
    public boolean aggiungiElemento(Gioco gioco) {
        boolean uguali = giochi.stream().anyMatch(g -> g.getIdGioco().equals(gioco.getIdGioco()));
        if (uguali) {
            return false;
        }
        giochi.add(gioco);
        return true;
    }

    //2)
    public Optional<Gioco> ricercaPerId(String id) {
        return giochi.stream()
                .filter(g -> g.getIdGioco().equalsIgnoreCase(id))
                .findFirst();
    }

    //3)
    public List<Gioco> ricercaPerPrezzo(double prezzoMax) {
        List<Gioco> risultati = giochi.stream()
                .filter(g -> g.getPrezzo() <= prezzoMax)
                .collect(Collectors.toList());

        if (risultati.isEmpty()) {
            System.out.println("Nessun gioco con quel prezzo.");
        }

        return risultati;
    }

    //4)
    public List<GiocoDaTavolo> ricercaPerNumeroGiocatori(int numero) {
        return giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(gdt -> gdt.getNumeroGiocatori() == numero)
                .collect(Collectors.toList());
    }

    //5)
    public boolean rimuoviPerId(String id) {
        return giochi.removeIf(g -> g.getIdGioco().equalsIgnoreCase(id));
    }

    //6)
    public boolean aggiornaPrezzoPerId(String id, double nuovoPrezzo) {
        Optional<Gioco> gioco = ricercaPerId(id);
        gioco.ifPresent(g -> g.setPrezzo(nuovoPrezzo));
        return gioco.isPresent();
    }

    //7
    public void mostraGiochi() {
        giochi.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "giochi=" + giochi +
                '}';
    }
}
