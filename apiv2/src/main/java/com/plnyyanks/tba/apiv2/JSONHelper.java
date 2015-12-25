package com.plnyyanks.tba.apiv2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JSONHelper {
    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            /* Construct new gson with our custom deserializers */
            GsonBuilder builder = new GsonBuilder();
            gson = builder.create();
        }
        return gson;
    }
}
