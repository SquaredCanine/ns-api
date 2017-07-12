package nl.qstekelenburg.ns;

import nl.qstekelenburg.ns.model.stations.Stations;

class StationsRequest extends ApiRequest<Stations> {

    /**
     * Limiting scope
     */
    StationsRequest() {
    }

    /**
     * {@inheritDoc}
     * 
     * @see nl.qstekelenburg.ns.ApiRequest#getPath()
     */
    @Override
    String getPath() {
        return "ns-api-stations-v2";
    }

    /**
     * {@inheritDoc}
     * 
     * @see nl.qstekelenburg.ns.ApiRequest#getRequestString()
     */
    @Override
    String getRequestString() {
        return "";
    }

}
