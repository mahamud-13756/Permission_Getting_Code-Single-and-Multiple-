package com.example.flash_light_app;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;

    String[] permission={"android.permission.READ_EXTERNAL_STORAGE","android.permission.CAMERA"};//multiple permission neyar jonno ai array te add korte hbe
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().hide(); // ***ekhane action bar hide korle app on hccena..shudhu blink kore......MIND IT#
        b = findViewById(R.id.btn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Request permission[requestPermission] write
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(permission,80);// 2 ta parameter nibe akta permission name er string array arekta int any value
                }
            }
        });



    }

    // ekhane permission er result milega
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==80){
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getApplicationContext(),"Give the permission",Toast.LENGTH_SHORT).show();
            }
        }
    }
}