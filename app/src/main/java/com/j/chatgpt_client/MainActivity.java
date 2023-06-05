package com.j.chatgpt_client;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://chat.openai.com"; // Replace with your desired URL
        CustomTabsIntent intent = new CustomTabsIntent.Builder()
                .build();
        try {
            intent.launchUrl(MainActivity.this, Uri.parse(url));
        } catch (ActivityNotFoundException e) {
            // Define what your app should do if no activity can handle the intent.
            Intent intent2 = new Intent(Intent.ACTION_MAIN);
            intent2.setComponent(new ComponentName("com.j.chatgpt_client", "com.j.chatgpt_client.ErrappActivity"));
            startActivity(intent2);
        }
    }
}
