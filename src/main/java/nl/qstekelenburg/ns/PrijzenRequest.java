package nl.qstekelenburg.ns;

import nl.qstekelenburg.ns.model.prijzen.VervoerderKeuzes;

class PrijzenRequest extends ApiRequest<VervoerderKeuzes> {
    private final String from;
    private final String to;
    private final String via;
    private final String dateTime;

    PrijzenRequest(String from, String to, String via, String dateTime) {
        this.from = UrlParamHelper.encode(from);
        this.to = UrlParamHelper.encode(to);
        this.via = UrlParamHelper.encode(via);
        this.dateTime = UrlParamHelper.encode(dateTime);
    }

    /**
     * {@inheritDoc}
     * 
     * @see nl.qstekelenburg.ns.ApiRequest#getPath()
     */
    @Override
    String getPath() {
        return "ns-api-prijzen-v3";
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @see nl.qstekelenburg.ns.ApiRequest#getRequestString()
     */
    @Override
    String getRequestString() {
        StringBuilder requestString = new StringBuilder();
        requestString.append("from=").append(from).append('&');
        requestString.append("to=").append(to);
        if (via != null && via.trim().length() != 0) {
            requestString.append("&").append("via=").append(via);
        }
        if (dateTime != null && dateTime.trim().length() != 0) {
            requestString.append('&').append("dateTime=").append(dateTime);
        }
        return requestString.toString();
    }

}
