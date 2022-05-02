package com.cb.coink.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.databinding.DataBindingUtil;

import com.cb.coink.R;
import com.cb.coink.databinding.ActivityRegisterBinding;

public class RegisterActivity extends Activity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.layoutKeyPad.key0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "0");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "1");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "2");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "3");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "4");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "5");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "6");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "7");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "8");
                stateCellPhoneNumber();
            }
        });

        binding.layoutKeyPad.key9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cellPhoneNumber.setText(binding.cellPhoneNumber.getText().toString() + "9");
                stateCellPhoneNumber();
            }
        });


        binding.layoutKeyPad.backDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cellPhoneNumber.getText().toString().length() > 0) {
                    StringBuffer sb = new StringBuffer(binding.cellPhoneNumber.getText().toString());
                    sb.delete(binding.cellPhoneNumber.getText().toString().length() - 1, binding.cellPhoneNumber.getText().toString().length());
                    binding.cellPhoneNumber.setText(sb.toString());
                    stateCellPhoneNumber();
                }
            }
        });

        binding.layoutKeyPad.backEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cellPhoneNumber.getText().toString().length() == 10) {
                    Intent intent = new Intent(getApplicationContext(), RegisterAccountDataActivity.class);
                    intent.putExtra("cellphone", binding.cellPhoneNumber.getText().toString());
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

                }
            }
        });

    }


    public void stateCellPhoneNumber() {
        if (binding.cellPhoneNumber.getText().toString().length() == 10) {
            binding.layoutKeyPad.backEnter.setBackgroundResource(R.drawable.circle_green);
        } else {
            binding.layoutKeyPad.backEnter.setBackgroundResource(R.drawable.circle_gray_ligth);
        }
    }
}