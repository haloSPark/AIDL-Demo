package com.example.nullop.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.server.IMyRemoteInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    IMyRemoteInterface mService = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_connect).setOnClickListener(this);
        findViewById(R.id.btn_disconect).setOnClickListener(this);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IMyRemoteInterface.Stub.asInterface(service);

            try {
                Toast.makeText(MainActivity.this, "pid: " + mService.getPid(), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
            Toast.makeText(MainActivity.this, "断开",
                    Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_connect:
                Intent intent = new Intent("com.example.server.IMyRemoteInterface");
//                intent.setAction("com.example.server.IMyRemoteInterface");
                intent.setPackage("com.example.server");
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
//                startService(intent);
                break;
            case R.id.btn_disconect:
                unbindService(mConnection);
                break;
        }

    }
}
