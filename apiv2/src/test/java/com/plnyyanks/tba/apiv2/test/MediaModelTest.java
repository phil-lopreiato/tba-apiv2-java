package com.plnyyanks.tba.apiv2.test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.plnyyanks.tba.apiv2.JSONHelper;
import com.plnyyanks.tba.apiv2.models.Media;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by phil on 5/4/15.
 */
public class MediaModelTest {
    Media cdMedia;
    Media ytMedia;

    @Before
    public void readJsonData(){
        BufferedReader cdMediaReader;
        BufferedReader ytMediaReader;
        Gson gson = JSONHelper.getGson();
        String basePath = new File("").getAbsolutePath();
        try {
            cdMediaReader = new BufferedReader(new FileReader(basePath + "/src/test/java/com/plnyyanks/tba/apiv2/test/data/media_cdphotothread.json"));
            ytMediaReader = new BufferedReader(new FileReader(basePath + "/src/test/java/com/plnyyanks/tba/apiv2/test/data/media_youtube.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assertTrue(false);
            return;
        }

        cdMedia = gson.fromJson(cdMediaReader, Media.class);
        ytMedia = gson.fromJson(ytMediaReader, Media.class);
    }

    @Test
    public void testCdMedia(){
        assertNotNull(cdMedia);
        assertEquals(cdMedia.getType(), "cdphotothread");
        assertEquals(cdMedia.getForeign_key(), "39894");
        assertFalse(cdMedia.getDetails().isJsonNull());
        JsonObject details = cdMedia.getDetails();
        assertTrue(details.has("image_partial"));
        assertEquals(details.get("image_partial").getAsString(), "fe3/fe38d320428adf4f51ac969efb3db32c_l.jpg");
    }

    @Test
    public void testYtMedia(){
        assertNotNull(ytMedia);
        assertEquals(ytMedia.getType(), "youtube");
        assertEquals(ytMedia.getForeign_key(), "RpSgUrsghv4");
        assertFalse(ytMedia.getDetails().isJsonNull());
    }
}
