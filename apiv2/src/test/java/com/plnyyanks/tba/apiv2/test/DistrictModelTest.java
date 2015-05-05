package com.plnyyanks.tba.apiv2.test;

import com.google.gson.Gson;
import com.plnyyanks.tba.apiv2.JSONHelper;
import com.plnyyanks.tba.apiv2.models.District;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by phil on 5/4/15.
 */
public class DistrictModelTest {
    District district;

    @Before
    public void readJsonData(){
        BufferedReader districtReader;
        Gson gson = JSONHelper.getGson();
        String basePath = new File("").getAbsolutePath();
        try {
            districtReader = new BufferedReader(new FileReader(basePath + "/src/test/java/com/plnyyanks/tba/apiv2/test/data/district_ne.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assertTrue(false);
            return;
        }

        district = gson.fromJson(districtReader, District.class);
    }

    @Test
    public void testDistrictModel(){
        assertNotNull(district);
        assertEquals(district.getName(), "New England");
        assertEquals(district.getKey(), "ne");
    }
}
