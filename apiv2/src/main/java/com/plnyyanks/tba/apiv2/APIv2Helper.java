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

public final class APIv2Helper {

    public static final String TBA_APIv2_URL = "http://www.thebluealliance.com/api/v2";

    private static APIv2 tbaAPI;
    private static ObservableAPIv2 observableAPI;
    private static OkClient okClient;
    private static RestAdapter adapter;
    private static String appId;

    public static void setAppId(String id){
        appId = id;
    }

    public static APIv2 getAPI(){
        setupRestAdapter();
        if(tbaAPI == null){
            tbaAPI = adapter.create(APIv2.class);
        }
        return tbaAPI;
    }

    public static ObservableAPIv2 getObservableAPI(){
        setupRestAdapter();
        if(observableAPI == null){
            observableAPI = adapter.create(ObservableAPIv2.class);
        }
        return observableAPI;
    }

    private static void setupOkClient(){
        if(okClient == null){
            okClient = new OkClient();
        }
    }

    private static void setupRestAdapter(){
        setupOkClient();
        if(adapter == null){
            adapter = new RestAdapter.Builder()
                    .setEndpoint(TBA_APIv2_URL)
                    .setConverter(new RetrofitConverter())
                    .setRequestInterceptor(new APIv2RequestInterceptor())
                    .setErrorHandler(new APIv2ErrorHandler())
                    .setClient(okClient)
                    .build();
        }
    }

    public static class APIv2RequestInterceptor implements RequestInterceptor {
        @Override
        public void intercept(RequestFacade request) {
            if(appId != null && !appId.isEmpty()) {
                request.addHeader("X-TBA-App-Id", appId);
            }
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
