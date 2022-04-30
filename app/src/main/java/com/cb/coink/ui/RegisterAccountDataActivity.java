package com.cb.coink.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.cb.coink.R;
import com.cb.coink.databinding.ActivityRegisterAccountDataBinding;
import com.cb.coink.databinding.ActivityRegisterBinding;
import com.cb.coink.model.DocumentTypes;
import com.cb.coink.model.Genders;
import com.cb.coink.retrofit.MyApiAdapter;
import com.cb.coink.retrofit.MyApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterAccountDataActivity extends Activity {
    private ActivityRegisterAccountDataBinding binding;
    String apiKey = "030106";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_account_data);


        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getDocumentTypes();
        getListGenders();
    }


    private void getDocumentTypes() {

        try {
            final Call<ArrayList<DocumentTypes>> obj = MyApiAdapter.getApiUtil().getListDocumentTypes(apiKey);
            obj.enqueue(new Callback<ArrayList<DocumentTypes>>() {
                @Override
                public void onResponse(Call<ArrayList<DocumentTypes>> call, Response<ArrayList<DocumentTypes>> response) {
                    Log.v("arary", "size" + response.body().toString());
                    // Toast.makeText(getApplicationContext(), ":D " + response.body(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<ArrayList<DocumentTypes>> call, Throwable t) {
                    Log.v("error", t.getMessage() + "");
                }
            });

        } catch (Exception e) {
            Log.v("Error", e.getMessage());
        }

    }


    private void getListGenders() {

        try {

            final Call<ArrayList<Genders>> obj = MyApiAdapter.getApiUtil().getListGenders(apiKey);
            obj.enqueue(new Callback<ArrayList<Genders>>() {
                @Override
                public void onResponse(Call<ArrayList<Genders>> call, Response<ArrayList<Genders>> response) {
                    Log.v("arary", "size" + response.body().toString());
                    // Toast.makeText(getApplicationContext(), ":D " + response.body(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<ArrayList<Genders>> call, Throwable t) {
                    Log.v("error", t.getMessage() + "");
                }
            });

        } catch (Exception e) {
            Log.v("Error", e.getMessage());
        }

    }
}