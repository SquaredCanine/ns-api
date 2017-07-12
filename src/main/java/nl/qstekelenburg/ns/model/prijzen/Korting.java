package nl.qstekelenburg.ns.model.prijzen;

import java.io.Serializable;

/**
 * Created by doombringer on 7/11/2017.
 */
public class Korting implements Serializable {
    private final String name;
    private final double prijs;

    public Korting(String name, double prijs) {
        this.name = name;
        this.prijs = prijs;
    }

    public String getName() {
        return name;
    }

    public double getPrijs() {
        return prijs;
    }
}
