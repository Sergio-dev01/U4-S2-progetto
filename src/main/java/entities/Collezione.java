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
        return giochi.stream()
                .filter(g -> g.getPrezzo() <= prezzoMax)
                .collect(Collectors.toList());
    }

    //4)
    public List<GiocoDaTavolo> ricercaPerNumeroGiocatori(int numero) {
        return giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(gdt -> gdt.getNumeroGiocatori() == numero)
                .collect(Collectors.toList());
    }


}
