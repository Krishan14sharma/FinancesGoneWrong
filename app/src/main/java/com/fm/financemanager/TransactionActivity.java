package com.fm.financemanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class TransactionActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, TransactionActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.addTrans).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtAmount = (EditText) findViewById(R.id.edtAmount);
                Intent intent = new Intent();
                intent.putExtra("amount", "Rs "+edtAmount.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
