package com.manjesh.network.ers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Created by aadhya on 11/19/2016.
 */

@Provider
public class ClientLoggingFilter implements ClientRequestFilter, ClientResponseFilter, WriterInterceptor {
    protected static String HTTPCLIENT_START_TIME = "my-http-starttime";
    protected static String HTTPCLIENT_LOG_STREAM = "my-http-logging-stream";

    @Context
    private ResourceInfo resourceInfo;

    public void filter(final ClientRequestContext requestContext) throws IOException {
        requestContext.setProperty(HTTPCLIENT_START_TIME, System.nanoTime());

        final OutputStream stream = new LoggingStream(requestContext.getEntityStream());
        requestContext.setEntityStream(stream);
        requestContext.setProperty(HTTPCLIENT_LOG_STREAM, stream);
    }

    public void filter(final ClientRequestContext requestContext, final ClientResponseContext responseContext) {
        StringBuilder builder = new StringBuilder("--------------------------").append(System.lineSeparator());

        long startTime = (long) requestContext.getProperty(HTTPCLIENT_START_TIME);
        final double duration = (System.nanoTime() - startTime) / 1_000_000.0;
        builder.append("Response Time: ").append(duration);

        if (requestContext.hasEntity()) {
            final LoggingStream stream = (LoggingStream) requestContext.getProperty(HTTPCLIENT_LOG_STREAM);
            //String body = stream.getString(MessageUtils.getCharset(requestContext.getMediaType()));
            String body = stream.getString(Charset.forName("UTF-8"));
            builder.append(System.lineSeparator()).append("Entity: ").append(body);
        }

        builder.append(System.lineSeparator()).append("--------------------------");
        System.out.println(builder.toString());

        requestContext.removeProperty(HTTPCLIENT_START_TIME);
        requestContext.removeProperty(HTTPCLIENT_LOG_STREAM);
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        // This forces the data to be written to the output stream
        context.proceed();
    }
}