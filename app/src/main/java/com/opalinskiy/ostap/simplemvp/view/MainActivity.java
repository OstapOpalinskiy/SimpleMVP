package com.opalinskiy.ostap.simplemvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.opalinskiy.ostap.simplemvp.R;
import com.opalinskiy.ostap.simplemvp.presenter.IPresenter;
import com.opalinskiy.ostap.simplemvp.presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private EditText etName;
    private EditText etEmail;
    private EditText etId;
    private Button btnSave;
    private Button btnFind;
    private TextView tvResult;
    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnSave.setOnClickListener(this);
        btnFind.setOnClickListener(this);
    }

    private void init() {
        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etId = (EditText) findViewById(R.id.et_userId);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnFind = (Button) findViewById(R.id.btn_find);
        tvResult = (TextView) findViewById(R.id.tv_result);
        presenter = new PresenterImpl(this, getApplicationContext());
    }

    @Override
    public void showUser(String msg) {
        tvResult.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                String name = String.valueOf(etName.getText());
                String email = String.valueOf(etEmail.getText());
                presenter.onSave(name, email);
            case R.id.btn_find:
                String id = String.valueOf(etId.getText());
                presenter.onFind(id);
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
