package com.example.sojinjang.makerthon;

/**
 * Created by SungJae on 2017-03-04.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class RegistActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordConfirm;
    private EditText edname;
    private EditText edemail;
    private Button btnDone;
    private Button btnCancel;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etPasswordConfirm);
        edname =(EditText) findViewById(R.id.edname);
        edemail = (EditText) findViewById(R.id.edemail);
        btnDone = (Button) findViewById(R.id.btnDone);
        btnCancel = (Button) findViewById(R.id.btnCancel);


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 이메일 입력 확인
                if( etEmail.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity.this, "아이디를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etEmail.requestFocus();
                    return;
                }

                // 비밀번호 입력 확인
                if( etPassword.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                    return;
                }

                // 비밀번호 확인 입력 확인
                if( etPasswordConfirm.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity.this, "비밀번호 확인을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPasswordConfirm.requestFocus();
                    return;
                }

                // 비밀번호 일치 확인
                if( !etPassword.getText().toString().equals(etPasswordConfirm.getText().toString()) ) {
                    Toast.makeText(RegistActivity.this, "비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                    etPassword.setText("");
                    etPasswordConfirm.setText("");
                    etPassword.requestFocus();
                    return;
                }
                // 이름 입력 확인
                if( edname.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity.this, "이름 입력하세요!", Toast.LENGTH_SHORT).show();
                    edname.requestFocus();
                    return;
                }
                // 이메일 입력 확인
                if( edemail.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity.this, "이메일주소를 입력하세요!", Toast.LENGTH_SHORT).show();
                    edemail.requestFocus();
                    return;
                }

                // 대학교 선택 확인
                Intent result = new Intent();
                result.putExtra("ID", etEmail.getText().toString());
                result.putExtra("password",etPassword.getText().toString());
                result.putExtra("name",edname.getText().toString());
                result.putExtra("email",edemail.getText().toString());

                // 자신을 호출한 Activity로 데이터를 보낸다.
                setResult(RESULT_OK, result);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}

