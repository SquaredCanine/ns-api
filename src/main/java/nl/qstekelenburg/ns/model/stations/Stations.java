package nl.qstekelenburg.ns.model.stations;

import nl.qstekelenburg.ns.model.NsResultListWrapper;

import java.util.List;

/**
 * @author Paul van Assen
 */
public class Stations extends NsResultListWrapper<Station> {
    Stations(List<Station> stations) {
        super(stations);
    }
}
