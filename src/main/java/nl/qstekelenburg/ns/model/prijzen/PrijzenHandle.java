package nl.qstekelenburg.ns.model.prijzen;

import nl.qstekelenburg.ns.error.NsApiException;
import nl.qstekelenburg.ns.handle.Handle;
import nl.qstekelenburg.ns.xml.Xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by doombringer on 7/12/2017.
 */
public class PrijzenHandle implements Handle<VervoerderKeuzes> {

    @Override
    public VervoerderKeuzes getModel(InputStream stream){
        try{
            Xml xml = Xml.getXml(stream, "VervoerderKeuzes");
            List<VervoerderKeuze> vervoerderKeuzes = new ArrayList<>(xml.children("VervoerderKeuze")
                    .size());
            for (Xml vervoerderKeuzeXml : xml.children("VervoerderKeuze")){
                String vervoerderNaam = vervoerderKeuzeXml.attr("naam");
                int tariefeenheid = Integer.parseInt(vervoerderKeuzeXml.child("Tariefeenheden").content());
                List<ReisType> reistypes = new ArrayList<>(vervoerderKeuzeXml.children("ReisType").size());
                for (Xml reisTypeXml : vervoerderKeuzeXml.children("ReisType")){
                    String reisTypeNaam = reisTypeXml.attr("name");
                    List<ReisKlasse> reisklasses = new ArrayList<>(reisTypeXml.children("ReisKlasse").size());
                    for(Xml reisKlasseXml : reisTypeXml.children("ReisKlasse")){
                        int klasse = Integer.parseInt(reisKlasseXml.attr("klasse"));
                        List<Prijsdeel> prijsdelen = new ArrayList<>(reisKlasseXml.children("Prijsdeel").size());
                        for(Xml prijsdeelXml : reisKlasseXml.children("Prijsdeel")){
                            String vervoerder = prijsdeelXml.attr("vervoerder");
                            double prijs = Double.parseDouble(prijsdeelXml.attr("prijs"));
                            String naar = prijsdeelXml.attr("naar");
                            String van = prijsdeelXml.attr("van");
                            prijsdelen.add(new Prijsdeel(vervoerder,prijs,naar,van));
                        }
                        double totaal = Double.parseDouble(reisKlasseXml.child("Totaal").content());
                        List<Korting> kortingen = new ArrayList<>(4);
                        for(Xml kortingXml : reisKlasseXml.children("Korting")){
                            kortingen = new ArrayList<>(kortingXml.children("Kortingsprijs").size());
                            for(Xml kortingsprijsXml : kortingXml.children("Kortingsprijs")){
                                String name = kortingsprijsXml.attr("name");
                                double prijs = Double.parseDouble(kortingsprijsXml.attr("prijs"));
                                kortingen.add(new Korting(name,prijs));
                            }
                        }
                        reisklasses.add(new ReisKlasse(klasse,prijsdelen,totaal,kortingen));
                    }
                    reistypes.add(new ReisType(reisTypeNaam,reisklasses));
                }
                vervoerderKeuzes.add(new VervoerderKeuze(vervoerderNaam,tariefeenheid,reistypes));
            }
            return new VervoerderKeuzes(vervoerderKeuzes);
        }catch(Exception e){
            throw new NsApiException("Error parsing stream to prijzen", e);
        }
    }

}
