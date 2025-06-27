package entities;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(String idGioco, String titolo, int annoProduzione, double prezzo, int numeroGiocatori, int durataMediaPartita) {
        super(idGioco, titolo, annoProduzione, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "numeroGiocatori=" + numeroGiocatori +
                ", durataMediaPartita=" + durataMediaPartita +
                '}';
    }
}

