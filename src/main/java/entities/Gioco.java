package entities;

public class Gioco {
    protected String idGioco;
    protected String titolo;
    protected int annoProduzione;
    protected double prezzo;

    public Gioco(String idGioco, String titolo, int annoProduzione, double prezzo) {
        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoProduzione = annoProduzione;
        this.prezzo = prezzo;
    }

    public String getIdGioco() {
        return idGioco;
    }

    public void setIdGioco(String idGioco) {
        this.idGioco = idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoProduzione() {
        return annoProduzione;
    }

    public void setAnnoProduzione(int annoProduzione) {
        this.annoProduzione = annoProduzione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
//        if (prezzo < 0)
//            this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "idGioco='" + idGioco + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoProduzione=" + annoProduzione +
                ", prezzo=" + prezzo +
                '}';
    }
}

