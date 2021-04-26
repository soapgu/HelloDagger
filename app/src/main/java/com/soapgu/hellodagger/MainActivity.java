package com.soapgu.hellodagger;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.orhanobut.logger.Logger;
import com.soapgu.lightlibrary.LightMaker;

public class MainActivity extends AppCompatActivity {

    private LightMaker lightMaker;
    private boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initialize();
    }

    private void initialize(){
        lightMaker = new LightMaker();
        try {
            lightMaker.open();
        }
        catch ( Exception ex ){
            Logger.e( ex, "open SerialPort failed" );
        }

        SwitchCompat switchCompat = this.findViewById(R.id.switch_light);
        switchCompat.setOnCheckedChangeListener( (v,checked)-> isChecked = checked);

        this.findViewById(R.id.button_on).setOnClickListener(v -> {
            lightMaker.on( isChecked ? "red":"yellow" );
            Toast toast = Toast.makeText(this, "----Light On---" , Toast.LENGTH_SHORT);
            toast.show();
        } );

        this.findViewById(R.id.button_off).setOnClickListener(v -> {
            lightMaker.off( isChecked ? "red":"yellow" );
            Toast toast = Toast.makeText(this, "----Light Off---" , Toast.LENGTH_SHORT);
            toast.show();
        } );
    }

    @Override
    protected void onDestroy() {
        lightMaker.close();
        super.onDestroy();
    }
}