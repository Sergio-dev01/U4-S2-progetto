package entities;

import java.util.ArrayList;
import java.util.List;

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


}
