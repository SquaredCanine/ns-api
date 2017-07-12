package nl.qstekelenburg.ns.model.prijzen;

import java.io.Serializable;
import java.util.List;

/**
 * Created by doombringer on 7/11/2017.
 */
public class VervoerderKeuze implements Serializable {
    private final String naam;
    private final int tariefeenheid;
    private final List<ReisType> reistype;

    public VervoerderKeuze(String naam, int tariefeenheid, List<ReisType> reistype) {
        super();
        this.naam = naam;
        this.tariefeenheid = tariefeenheid;
        this.reistype = reistype;
    }

    public String getNaam() {
        return naam;
    }

    public int getTariefeenheid() {
        return tariefeenheid;
    }

    public List<ReisType> getReistype() {
        return reistype;
    }
}
