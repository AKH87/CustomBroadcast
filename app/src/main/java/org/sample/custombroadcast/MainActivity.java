package org.sample.custombroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    CustomBroadcast receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        receiver = new CustomBroadcast();
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent();
        intent.putExtra("msg", editName.getText().toString());
        intent.setAction("org.sample.custombroadcast.MY_MSG");
        sendBroadcast(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("org.sample.custombroadcast.MY_MSG");
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
