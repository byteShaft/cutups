package com.pits.cutups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.pits.cutups.utils.Helpers;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView mCutUpsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCutUpsButton = (ImageView) findViewById(R.id.cut_ups_button);
    }

    @Override
    public void onClick(View v) {
        Helpers.vibrate(getApplicationContext(), 20);
        switch (v.getId()) {
            case R.id.cut_ups_button:
                Intent cutUpsActivityIntent = new Intent(
                        getApplicationContext(), WriteActivity.class);
                startActivity(cutUpsActivityIntent);
        }
    }
}
