package nl.qstekelenburg.ns.model.prijzen;

import java.io.Serializable;
import java.util.List;

/**
 * Created by doombringer on 7/11/2017.
 */

public class ReisType implements Serializable {

    private final String naam;
    private final List<ReisKlasse> reisklasse;

    public ReisType(String naam, List<ReisKlasse> reisklasse) {
        this.naam = naam;
        this.reisklasse = reisklasse;
    }

    public String getNaam() {
        return naam;
    }

    public List<ReisKlasse> getReisklasse() {
        return reisklasse;
    }
}
