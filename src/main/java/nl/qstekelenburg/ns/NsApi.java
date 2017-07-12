package nl.qstekelenburg.ns;

import nl.qstekelenburg.ns.error.NsApiException;
import nl.qstekelenburg.ns.handle.Handle;
import nl.qstekelenburg.ns.model.NsResult;
import nl.qstekelenburg.ns.model.prijzen.PrijzenHandle;
import nl.qstekelenburg.ns.model.reisadvies.ReisadviesHandle;
import nl.qstekelenburg.ns.model.stations.StationsHandle;
import nl.qstekelenburg.ns.model.storingen.StoringenHandle;
import nl.qstekelenburg.ns.model.vertrektijden.ActueleVertrekTijdenHandle;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class for calling the NS api. The NS API is documented at <a href="http://www.ns.nl/api/api">NS API</a>
 * 
 * @author Paul van Assen
 * 
 */
public class NsApi {

    /**
     * NS Date to Java date formatting string
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private final HttpConnection httpConnection;
    private static final String BASE_URL = "http://webservices.ns.nl/";
    private final Map<Class<?>, Handle<?>> handleMap = new HashMap<>();

    /**
     * Constructor for the NS api handle. Takes a username and password as parameters. A username/password can be
     * requested at <a href="http://www.ns.nl/api/api">NS API</a>
     * 
     * @param username Username supplied by the NS
     * @param password Password supplied by the NS
     */
    public NsApi(String username, String password) {
        if (username == null || password == null) {
            throw new NullPointerException("Username or password cannot be null");
        }
        // No isEmpty to remain compatible with JDK 1.5
        if (username.trim().length() == 0 || password.trim().length() == 0) {
            throw new IllegalArgumentException("Username or password cannot be empty");
        }
        httpConnection = new HttpConnection(username, password);
        System.out.println("CONNECTION MADE!");
        handleMap.put(ActueleVertrekTijdenRequest.class, new ActueleVertrekTijdenHandle());
        handleMap.put(StationsRequest.class, new StationsHandle());
        handleMap.put(StoringenEnWerkzaamhedenRequest.class, new StoringenHandle());
        handleMap.put(ReisadviesRequest.class, new ReisadviesHandle());
        handleMap.put(PrijzenRequest.class, new PrijzenHandle());
    }

    /**
     * Method that makes a call to the NS. The request parameter defines what data to pull. The serialized data of the
     * request is returned, or an exception is thrown. For all request types, see <a href="http://www.ns.nl/api/api">NS
     * API</a> and {@link nl.qstekelenburg.ns.RequestBuilder}
     * 
     * @see nl.qstekelenburg.ns.RequestBuilder
     * @param request Data to request
     * @param <T> Type of response
     * @return Serialized response
     * @throws IOException In case of an network error
     * @throws NsApiException In case of any other error than a network error
     */
    public <T extends NsResult> T getApiResponse(ApiRequest<T> request) throws IOException, NsApiException {
        InputStream stream = null;
        try {
            System.out.println(NsApi.BASE_URL + request.getPath() + "?" + request.getRequestString());
            stream = httpConnection.getContent(NsApi.BASE_URL + request.getPath() + "?" + request.getRequestString());
            @SuppressWarnings("unchecked")
            Handle<T> handle = (Handle<T>) handleMap.get(request.getClass());
            if (handle == null) {
                throw new NsApiException("Unknown request type " + request.getClass());
            }
            return handle.getModel(stream);
        }
        finally {
            IOUtils.closeQuietly(stream);
        }
    }

}
