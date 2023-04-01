package com.grozziie.grozziie_aaam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.grozziie.grozziie_aaam.wifi.AllWifiList;
import com.grozziie.grozziie_aaam.wifi.WifiListActivity;
import com.tapadoo.alerter.Alert;

import java.util.List;

import es.dmoral.toasty.Toasty;
////InilizeSdk
///MD Ariful Islam
//// Software Engineer at THT Space
////Date : 29-3-2023
///Bluetooth SDK

public class Device_CategoryActivity extends AppCompatActivity {

BluetoothAdapter bluetoothAdapter;
BluetoothSocket bluetoothSocket;
BluetoothDevice bluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device__category);
        /////initilize all things
        Toolbar toolbar=findViewById(R.id.profile_toolbar);
        toolbar.setTitle("Device Category");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar();

        try {
            bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();



        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bluetooth(View view) {
        try {
            bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
            if (!bluetoothAdapter.isEnabled()) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Device_CategoryActivity.this);
                builder.setTitle("Bluetooth")
                        .setMessage("Your bluetooth is disable now.\nDo you want to enable it?")
                        .setPositiveButton("NOT NOW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        }).setNegativeButton("ENABLE NOW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        bluetoothAdapter.enable();
                        bluetoothAdapter.enable();


                    }
                }).create();
                builder.show();
            }
            else {
                startActivity(new Intent(getApplicationContext(),BluetoothList.class));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void wifi(View view) {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (wifiInfo.isConnected()) {
            // WiFi is connected
            startActivity(new Intent(getApplicationContext(), AllWifiList.class));
        } else {
            // WiFi is not connected
            AlertDialog.Builder builder=new AlertDialog.Builder(Device_CategoryActivity.this);
            builder.setTitle("Wifi")
                    .setMessage("Your wifi is disable now.\nDo you want to enable it?")
                    .setPositiveButton("NOT NOW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setNegativeButton("See Wifi List", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo wifiInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                    if (wifiInfo.isConnected()) {
                        // WiFi is connected
                        startActivity(new Intent(getApplicationContext(), AllWifiList.class));
                    }
                    else {
                        Toasty.error(getApplicationContext(),"Your wifi is disable now. Do you want to enable it?",Toasty.LENGTH_SHORT,true).show();
                        return;
                    }




                }
            }).create();
            builder.show();
        }

/*

        ConnectivityManager cm = (ConnectivityManager) Device_CategoryActivity.this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if(netInfo != null && netInfo.isConnectedOrConnecting()) {
            WifiManager wifiManager = (WifiManager) Device_CategoryActivity.this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(true);
            wifiManager.setWifiEnabled(true);
            startActivity(new Intent(getApplicationContext(), WifiListActivity.class));
        }
        else {
            AlertDialog.Builder builder=new AlertDialog.Builder(Device_CategoryActivity.this);
            builder.setTitle("Wifi")
                    .setMessage("Your wifi is disable now.\nDo you want to enable it?")
                    .setPositiveButton("NOT NOW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setNegativeButton("ENABLE NOW", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    WifiManager wifiManager = (WifiManager) Device_CategoryActivity.this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                    wifiManager.setWifiEnabled(true);
                    startActivity(new Intent(getApplicationContext(), WifiListActivity.class));


                }
            }).create();
            builder.show();
        }
 */
    }
}