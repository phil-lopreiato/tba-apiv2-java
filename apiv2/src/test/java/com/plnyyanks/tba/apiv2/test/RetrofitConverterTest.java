package com.plnyyanks.tba.apiv2.test;

import com.plnyyanks.tba.apiv2.RetrofitConverter;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import retrofit.converter.ConversionException;
import retrofit.mime.TypedOutput;
import retrofit.mime.TypedString;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by phil on 5/5/15.
 */
public class RetrofitConverterTest {
    RetrofitConverter converter;

    @Before
    public void setup(){
        converter = new RetrofitConverter();
    }

    @Test(expected = ConversionException.class)
    public void testConversionException() throws ConversionException {
        TypedString string = new TypedString("{saldkj"); // bad json
        converter.fromBody(string, String.class);
    }

    @Test
    public void testToBody(){
        TypedOutput output = converter.toBody("['hello']");
        assertNotNull(output);
        assertNull(output.fileName());
        assertNotNull(output.mimeType());
        assertTrue(output.length() > 0);
        try {
            output.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
