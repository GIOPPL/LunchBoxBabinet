package com.gioppl.lunchboxcabinet;

import android.os.Bundle;
import android.util.Log;

import com.gioppl.lunchboxcabinet.trsform.CabinetToolsPort;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CabinetToolsPort cabinetToolsPort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        CabinetToolsPort.getInstance().init(new CabinetToolsPort.PortCallback() {
            @Override
            public void result(String result) {
                Log.i("device response",result);
            }
        });
//        cabinetToolsPort.openBox("");
    }
}