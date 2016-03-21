package io.github.sagarayi.networkmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectServer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_server);

        Intent intent=getIntent();


    }
    public void sendIP(View v)
    {
        EditText edit= (EditText) findViewById(R.id.editText);
        String ip= String.valueOf(edit.getText());
        Toast.makeText(this,ip,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,Client.class);
        intent.putExtra("IP",ip);
        startActivity(intent);
    }

}
