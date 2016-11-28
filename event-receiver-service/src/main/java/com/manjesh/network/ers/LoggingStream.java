package com.manjesh.network.ers;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Created by aadhya on 11/19/2016.
 */
public class LoggingStream extends FilterOutputStream
{
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    public LoggingStream(final OutputStream inner)
    {
        super(inner);
    }

    public String getString(final Charset charset)
    {
        final byte[] entity = baos.toByteArray();
        return new String(entity, charset);
    }

    @Override
    public void write(final int i) throws IOException
    {
        baos.write(i);
        out.write(i);
    }
}