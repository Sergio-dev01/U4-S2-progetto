package entities;

import enums.Genere;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int durataGioco;
    private Genere genere;

    public Videogioco(String idGioco, String titolo, int annoProduzione, double prezzo, String piattaforma, int durataGioco, Genere genere) {
        super(idGioco, titolo, annoProduzione, prezzo);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public void setDurataGioco(int durataGioco) {
        this.durataGioco = durataGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "piattaforma='" + piattaforma + '\'' +
                ", durataGioco=" + durataGioco +
                ", genere=" + genere +
                '}';
    }
}
