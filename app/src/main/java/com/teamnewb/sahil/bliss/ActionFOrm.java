package com.teamnewb.sahil.bliss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class ActionForm extends Activity {
    public final static String DESCRIPTION = "com.teamnewb.sahil.ActionForm.DESCRIPTION";
    public final static String TYPE = "com.teamnewb.sahil.ActionForm.TYPE";
    public final static String IMPORTANCE = "com.teamnewb.sahil.ActionForm.IMPORTANCE";

    public void saveActionForm(View view) {
        Intent intent = new Intent(this, ActionSummary.class);
        EditText editText = (EditText) findViewById(R.id.addAction_description);
        String message = editText.getText().toString();
        intent.putExtra(DESCRIPTION, message);

        RadioGroup radio = (RadioGroup) findViewById(R.id.addAction_typeRadioGroup);
        int typeId = radio.getCheckedRadioButtonId();
        RadioButton radioTypeButton = (RadioButton) findViewById(typeId);
        String type = (String) radioTypeButton.getText();
        intent.putExtra(TYPE,type);


        RadioGroup radioImport = (RadioGroup) findViewById(R.id.addAction_importantRadioGroup);
        int importanceId = radioImport.getCheckedRadioButtonId();
        RadioButton radioImportButton = (RadioButton) findViewById(importanceId);
        int importance = 0;
        if ("Important".equals((String) radioImportButton.getText())){
            importance = 1;
        }
        intent.putExtra(IMPORTANCE,importance);

//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(message);
//
//        TextView textView2 = new TextView(this);
//        textView2.setTextSize(40);
//        textView2.setText(type);
//
//        TextView textView3 = new TextView(this);
//        textView3.setTextSize(40);
//        textView3.setText("" + importance);
//        setContentView(textView);
//        setContentView(textView2);
//        setContentView(textView3);


        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_form);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_summary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
