package com.soapgu.hellodagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.soapgu.lightlibrary.LightMaker;
import com.soapgu.lightlibrary.ModuleTest;

import static com.soapgu.lightlibrary.ModuleTest.Hello;

public class MainActivity extends AppCompatActivity {

    private LightMaker lightMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightMaker = new LightMaker();
        try {
            lightMaker.open();
        }
        catch ( Exception ex ){
            Logger.e( ex, "open SerialPort failed" );
        }


        this.findViewById(R.id.button_on).setOnClickListener(v -> {
            lightMaker.on();
            Toast toast = Toast.makeText(this, "----Light On---" , Toast.LENGTH_SHORT);
            toast.show();
        } );

        this.findViewById(R.id.button_off).setOnClickListener(v -> {
            lightMaker.off();
            Toast toast = Toast.makeText(this, "----Light Off---" , Toast.LENGTH_SHORT);
            toast.show();
        } );
    }
}