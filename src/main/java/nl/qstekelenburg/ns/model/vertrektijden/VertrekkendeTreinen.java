package nl.qstekelenburg.ns.model.vertrektijden;

import nl.qstekelenburg.ns.model.NsResultListWrapper;

import java.util.List;

/**
 * @author Paul van Assen
 */
public class VertrekkendeTreinen extends NsResultListWrapper<VertrekkendeTrein> {
    VertrekkendeTreinen(List<VertrekkendeTrein> vertrekkendeTreinen) {
        super(vertrekkendeTreinen);
    }
}
