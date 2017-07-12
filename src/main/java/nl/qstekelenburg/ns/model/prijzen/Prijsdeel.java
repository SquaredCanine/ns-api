package nl.qstekelenburg.ns.model.prijzen;

import java.io.Serializable;

/**
 * Created by doombringer on 7/11/2017.
 */
public class Prijsdeel implements Serializable {
    private final String vervoerder;
    private final double prijs;
    private final String naar;
    private final String van;

    public Prijsdeel(String vervoerder, double prijs, String naar, String van) {
        this.vervoerder = vervoerder;
        this.prijs = prijs;
        this.naar = naar;
        this.van = van;
    }

    public String getVervoerder() {
        return vervoerder;
    }

    public double getPrijs() {
        return prijs;
    }

    public String getNaar() {
        return naar;
    }

    public String getVan() {
        return van;
    }
}
