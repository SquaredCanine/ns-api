package nl.qstekelenburg.ns.model.prijzen;

import java.io.Serializable;
import java.util.List;

/**
 * Created by doombringer on 7/11/2017.
 */
public class ReisKlasse implements Serializable {

    private final int klasse;
    private final List<Prijsdeel> prijsdelen;
    private final double Totaal;
    private final List<Korting> kortingen;

    public ReisKlasse(int klasse, List<Prijsdeel> prijsdelen, double totaal, List<Korting> kortingen) {
        this.klasse = klasse;
        this.prijsdelen = prijsdelen;
        Totaal = totaal;
        this.kortingen = kortingen;
    }

    public int getKlasse() {
        return klasse;
    }

    public List<Prijsdeel> getPrijsdelen() {
        return prijsdelen;
    }

    public double getTotaal() {
        return Totaal;
    }

    public List<Korting> getKortingen() {
        return kortingen;
    }
}
