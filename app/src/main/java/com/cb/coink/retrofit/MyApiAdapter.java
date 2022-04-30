package com.cb.coink.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiAdapter {

    private static MyApiService API_UTIL;// la interface

    public static MyApiService getApiUtil() { //utiliza patron singelton se utiliza una instancia

        // Creamos un interceptor y le indicamos el log level a usar
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();//va a mostrar lo resultados de la peticion el codigo de respuetsa
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrlUtil = "https://api.bancoink.biz/qa/signup/";

        //si api service es null se va instaciar de lo contrario va a devolver el objeto
        if (API_UTIL == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrlUtil)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            API_UTIL = retrofit.create(MyApiService.class);
        }

        return API_UTIL;
    }


}
