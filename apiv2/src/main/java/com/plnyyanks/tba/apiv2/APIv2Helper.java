package com.plnyyanks.tba.apiv2;

import com.plnyyanks.tba.apiv2.interfaces.APIv2;
import com.plnyyanks.tba.apiv2.interfaces.ObservableAPIv2;

import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * Created by phil on 4/6/15.
 */
public final class APIv2Helper {

    public static final String TBA_APIv2_URL = "http://www.thebluealliance.com/api/v2";

    private static final String VERSION = "v0.1";
    private static final String API_APP_ID = "plnyyanks:apiv2-java:"+VERSION;

    private static APIv2 tbaAPI;
    private static ObservableAPIv2 observableAPI;
    private static OkClient okClient;
    private static RestAdapter adapter;

    public static APIv2 getAPI(){
        if(okClient == null){
            okClient = new OkClient();
        }
        if(adapter == null){
            adapter = new RestAdapter.Builder()
                    .setEndpoint(TBA_APIv2_URL)
                    .setConverter(new RetrofitConverter())
                    .setRequestInterceptor(new APIv2RequestInterceptor())
                    .setErrorHandler(new APIv2ErrorHandler())
                    .setClient(okClient)
                    .build();
        }
        if(tbaAPI == null){
            tbaAPI = adapter.create(APIv2.class);
        }
        return tbaAPI;
    }

    public static ObservableAPIv2 getObservableAPI(){
        if(okClient == null){
            okClient = new OkClient();
        }
        if(adapter == null){
            adapter = new RestAdapter.Builder()
                    .setEndpoint(TBA_APIv2_URL)
                    .setConverter(new RetrofitConverter())
                    .setRequestInterceptor(new APIv2RequestInterceptor())
                    .setErrorHandler(new APIv2ErrorHandler())
                    .setClient(okClient)
                    .build();
        }
        if(observableAPI == null){
            observableAPI = adapter.create(ObservableAPIv2.class);
        }
        return observableAPI;
    }

    public static class APIv2RequestInterceptor implements RequestInterceptor {

        /**
         * ONLY SET THIS VARIABLE FROM WITHIN TESTS
         * It's so we can send a different App Id
         */
        public static boolean isFromJunit = false;

        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("X-TBA-App-Id", API_APP_ID+(isFromJunit?"-junit":""));
        }
    }

    static class APIv2ErrorHandler implements ErrorHandler {

        @Override
        public Throwable handleError(RetrofitError cause) {
            System.out.println(cause);
            Response response = cause.getResponse();
            if(response != null) {
                TypedByteArray data = (TypedByteArray) (response.getBody());
                byte[] bytes = data.getBytes();
                System.out.println(new String(bytes));
            }
            return cause;
        }
    }

}
