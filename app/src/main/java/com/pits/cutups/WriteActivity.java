package com.pits.cutups;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pits.cutups.utils.Helpers;

public class WriteActivity extends Activity implements View.OnClickListener {

    private EditText mCutUpsWriteField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_write);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/HoneyScript-Light.ttf");

        TextView saveButton = (TextView) findViewById(R.id.cut_ups_save);
        mCutUpsWriteField = (EditText) findViewById(R.id.cut_ups_write_entry);
        ImageView cutUpButton = (ImageView) findViewById(R.id.button_cutup);
        cutUpButton.setOnClickListener(this);

        saveButton.setTypeface(custom_font);
        mCutUpsWriteField.setTypeface(custom_font);
    }

    @Override
    public void onClick(View v) {
        Helpers.vibrate(getApplicationContext(), 20);
        switch (v.getId()) {
            case R.id.button_cutup:
                System.out.println(Helpers.getRandomNumber());
                Helpers.getCutTextsFromInput(mCutUpsWriteField.getText().toString());
                break;
        }
    }
}
