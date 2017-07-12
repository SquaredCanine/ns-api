package nl.qstekelenburg.ns.model.prijzen;

import nl.qstekelenburg.ns.model.NsResultListWrapper;

import java.util.List;

/**
 * Created by doombringer on 7/11/2017.
 * Zodra alles goed staat, kan je public hier verwijderen.
 */
public class VervoerderKeuzes extends NsResultListWrapper<VervoerderKeuze> {
    VervoerderKeuzes(List<VervoerderKeuze> vervoerderKeuzes){
        super(vervoerderKeuzes);
    }
}
