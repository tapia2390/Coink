package com.cb.coink.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.cb.coink.R;
import com.cb.coink.databinding.ActivityRegisterAccountDataBinding;
import com.cb.coink.model.DocumentTypes;
import com.cb.coink.model.Genders;
import com.cb.coink.model.Modelo;
import com.cb.coink.model.Person;
import com.cb.coink.retrofit.MyApiAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterAccountDataActivity extends Activity {
    private ActivityRegisterAccountDataBinding binding;
    Modelo modelo = Modelo.getInstance();
    String apiKey = "030106";
    boolean flag = false;
    String cellphone ="";
    ArrayList<DocumentTypes> documentTypesList = new ArrayList<DocumentTypes>();
    ArrayList<Genders> gendersList = new ArrayList<Genders>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_account_data);



        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
             cellphone = parametros.getString("cellphone");

        }

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getDocumentTypes();
        getListGenders();


        binding.layoutPersonalInformation.optionDocumentType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogDocumnetType(view);
            }
        });


        binding.layoutPersonalInformation.optionGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogGender(view);
            }
        });

        binding.layoutPersonalInformation.txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogDate(view, 0);
            }
        });

        binding.layoutPersonalInformation.txtDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogDate(view, 1);
            }
        });

        binding.layoutPersonalInformation.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                modelo.person = new Person(
                        cellphone,
                        binding.layoutPersonalInformation.optionDocumentType.getText().toString(),
                        binding.layoutPersonalInformation.txtxDocumentNumber.getText().toString(),
                        binding.layoutPersonalInformation.txtDate.getText().toString(),
                        binding.layoutPersonalInformation.txtDateOfBirth.getText().toString(),
                        binding.layoutPersonalInformation.optionGender.getText().toString(),
                        binding.layoutPersonalInformation.txtEmail.getText().toString(),
                        binding.layoutPersonalInformation.txtPin.getText().toString()

                        );


                Intent intent = new Intent(getApplicationContext(), FinalizeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
            }
        });


    binding.layoutPersonalInformation.txtxDocumentNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                   validateForm();
            }
        });


        binding.layoutPersonalInformation.txtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    validateForm();
            }
        });

        binding.layoutPersonalInformation.txtComfirmEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    validateForm();
            }
        });

        binding.layoutPersonalInformation.txtPin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    validateForm();
            }
        });

        binding.layoutPersonalInformation.txtComfimPin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    validateForm();
            }
        });

    }




    private void showAlertDialogDate(View view, int num) {

        Calendar calendar = Calendar.getInstance();
        int yil = 0;
        if(num == 1){
             yil = calendar.get(calendar.YEAR)-18;
        }else{
            yil = calendar.get(calendar.YEAR);
        }

        int ay =  calendar.get(calendar.MONTH);

        int gun = calendar.get(calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterAccountDataActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                if (num == 0) {
                    binding.layoutPersonalInformation.txtDate.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    validateForm();
                } else {
                    binding.layoutPersonalInformation.txtDateOfBirth.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    validateForm();
                }

            }
        }, yil, ay, gun);
        datePickerDialog.setTitle("Fecha");
        datePickerDialog.show();
    }

    private void getDocumentTypes() {

        try {
            final Call<ArrayList<DocumentTypes>> obj = MyApiAdapter.getApiUtil().getListDocumentTypes(apiKey);
            obj.enqueue(new Callback<ArrayList<DocumentTypes>>() {
                @Override
                public void onResponse(Call<ArrayList<DocumentTypes>> call, Response<ArrayList<DocumentTypes>> response) {
                    Log.v("response body", "response body: " + response.body().toString());
                    // Toast.makeText(getApplicationContext(), ":D " + response.body(), Toast.LENGTH_LONG).show();
                    documentTypesList = response.body();

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
                    Log.v("response body", "response body: " + response.body().toString());
                    gendersList = response.body();
                }

                @Override
                public void onFailure(Call<ArrayList<Genders>> call, Throwable t) {
                    Log.v("error", t.getMessage());
                }
            });

        } catch (Exception e) {
            Log.v("Error", e.getMessage());
        }

    }


    public void showAlertDialogDocumnetType(View view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.txt_select));

        // add a list
        String[] document = new String[documentTypesList.size()];

        for (int i = 0; i <= documentTypesList.size() - 1; i++) {
            document[i] = documentTypesList.get(i).getNotation();

        }
        builder.setItems(document, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                binding.layoutPersonalInformation.optionDocumentType.setText(document[item]);
                validateForm();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showAlertDialogGender(View view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione");

        // add a list
        String[] gender = new String[gendersList.size()];
        for (int i = 0; i <= gendersList.size() - 1; i++) {
            gender[i] = gendersList.get(i).getName();

        }
        builder.setItems(gender, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                binding.layoutPersonalInformation.optionGender.setText(gender[item]);
                validateForm();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private boolean validateEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    //alerta
    public void alerta(String titulo, String decripcion) {

        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(titulo)
                .setContentText(decripcion)
                .setConfirmText(getString(R.string.acept))
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        sDialog.dismissWithAnimation();
                    }
                }).show();
    }


    public void validateForm() {

        if (!binding.layoutPersonalInformation.optionDocumentType.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.optionDocumentType.setError(getString(R.string.required_field));
            flag = false;
            return;
        }

        if (!binding.layoutPersonalInformation.txtxDocumentNumber.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtxDocumentNumber.setError(getString(R.string.required_field));
            flag = false;
            return;
        }

        if (!binding.layoutPersonalInformation.txtDate.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtDate.setError(getString(R.string.required_field));
            flag = false;
            return;
        }

        if (!binding.layoutPersonalInformation.txtDateOfBirth.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtDateOfBirth.setError(getString(R.string.required_field));
            flag = false;
            return;
        }

        if (!binding.layoutPersonalInformation.optionGender.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.optionGender.setError(getString(R.string.required_field));
            flag = false;
            return;
        }

        if (!binding.layoutPersonalInformation.txtEmail.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtEmail.setError(getString(R.string.required_field));
            flag = false;
            return;
        }

        if (validateEmail(binding.layoutPersonalInformation.txtEmail.getText().toString())) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtEmail.setError(getString(R.string.invalid_email));
            flag = false;
            return;
        }

        if (!binding.layoutPersonalInformation.txtComfirmEmail.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtComfirmEmail.setError(getString(R.string.required_field));
            flag = false;
            return;
        }

        if (binding.layoutPersonalInformation.txtComfirmEmail.getText().toString().equals(binding.layoutPersonalInformation.txtEmail.getText().toString())) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtComfirmEmail.setError(getString(R.string.the_emails_do_not_match));
            flag = false;
            return;
        }

        if (!binding.layoutPersonalInformation.txtPin.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtPin.setError(getString(R.string.the_emails_do_not_match));
            flag = false;
            return;
        }

        if (!binding.layoutPersonalInformation.txtComfimPin.toString().trim().isEmpty()) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtComfimPin.setError(getString(R.string.the_emails_do_not_match));
            flag = false;
            return;
        }


        if (binding.layoutPersonalInformation.txtComfimPin.getText().toString().trim().equals(binding.layoutPersonalInformation.txtPin.getText().toString().trim())) {
            flag = true;
        } else {
            binding.layoutPersonalInformation.txtComfimPin.setError(getString(R.string.the_passwprd_do_not_match));
            flag = false;
            return;
        }

        if(flag){
            binding.layoutPersonalInformation.btnSignUp.setBackgroundResource(R.drawable.btn_rounded_green);
        }else{
            binding.layoutPersonalInformation.btnSignUp.setBackgroundResource(R.drawable.btn_rounded_gray);
        }

    }
}