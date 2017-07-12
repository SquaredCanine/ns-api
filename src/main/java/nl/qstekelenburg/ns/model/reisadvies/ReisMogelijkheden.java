package nl.qstekelenburg.ns.model.reisadvies;

import nl.qstekelenburg.ns.model.NsResultListWrapper;

import java.util.List;

/**
 * @author Paul van Assen
 */
public class ReisMogelijkheden extends NsResultListWrapper<ReisMogelijkheid> {
    ReisMogelijkheden(List<ReisMogelijkheid> reisMogelijkheden) {
        super(reisMogelijkheden);
    }
}
