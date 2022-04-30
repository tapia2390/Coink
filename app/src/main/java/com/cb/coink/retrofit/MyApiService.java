package com.cb.coink.retrofit;

import com.cb.coink.model.DocumentTypes;
import com.cb.coink.model.Genders;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApiService {

    @GET("documentTypes")
    Call<ArrayList<DocumentTypes>> getListDocumentTypes(
           // @Field("apiKey") Integer apiKey
            @Query("apiKey") String apiKey
    );



    @GET("genders")
    Call<ArrayList<Genders>> getListGenders(
              //@Field("apiKey") Integer apiKey
              @Query("apiKey") String apiKey
    );




}
