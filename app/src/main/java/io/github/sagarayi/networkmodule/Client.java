package io.github.sagarayi.networkmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends AppCompatActivity implements Runnable {

    String ip;
    private Thread t;
    private Client c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        ip=(String)bundle.get("IP");

        c=new Client();
        t=new Thread(c);
        t.start();

    }

    @Override
    public void run() {
        try {


            InetAddress host=InetAddress.getByName(ip);
            int portno=898;

            //Toast.makeText(this,"Entered thread running",Toast.LENGTH_LONG);
            Socket sclient=new Socket(host,portno);

            final PrintWriter out=new PrintWriter(sclient.getOutputStream(),true);

            Button b1=(Button)findViewById(R.id.buttonA);
            b1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    out.println("A");
                }
            });


            Button b2=(Button)findViewById(R.id.buttonB);
            b2.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    out.println("B");
                }
            });
            Button b3=(Button)findViewById(R.id.buttonB);
            b2.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    out.println("C");
                }
            });
            Button b4=(Button)findViewById(R.id.buttonB);
            b2.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    out.println("D");
                }
            });

        } catch (UnknownHostException e) {
            /*Intent reverse=new Intent(this,ConnectServer.class);
            startActivity(reverse);*/
            Toast.makeText(this,"Macha UnknownHostException",Toast.LENGTH_LONG).show();
            Log.e("HOST Exception :", e.getMessage());
        } catch (IOException e) {
            Log.e("IO Exception DAMN SUN :", e.getMessage());
        }
    }
}
