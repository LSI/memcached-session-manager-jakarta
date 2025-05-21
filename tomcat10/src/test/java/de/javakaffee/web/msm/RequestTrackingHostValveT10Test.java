package de.javakaffee.web.msm;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@Test
public class RequestTrackingHostValveT10Test extends RequestTrackingHostValveTest {

    private static final Rfc6265CookieProcessor COOKIE_PROCESSOR = new Rfc6265CookieProcessor();

    @Override
    protected void setupGetResponseSetCookieHeadersExpectations(Response response, String[] result) {
        when(response.getHeaders(eq("Set-Cookie"))).thenReturn(Arrays.asList(result));
    }

    @Override
    protected String[] getSetCookieHeaders(final Response response) {
        final Collection<String> result = response.getHeaders("Set-Cookie");
        return result.toArray(new String[result.size()]);
    }


    protected String generateCookieString(jakarta.servlet.http.Cookie cookie) {
        // Tomcat 10 adds a request parameter but it does not currently appear to be used in code.
        return COOKIE_PROCESSOR.generateHeader(cookie, null);
    }
}
