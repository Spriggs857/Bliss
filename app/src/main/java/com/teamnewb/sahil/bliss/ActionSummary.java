package com.teamnewb.sahil.bliss;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import db.TaskCRUD;
import db.TaskContract;

import static db.TaskContract.*;


public class ActionSummary extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        DateFormat dateformat = new SimpleDateFormat("EEE, MMM d, ''yy");

        Calendar cal = Calendar.getInstance();

        String date = dateformat.format(cal.getTime());
        actionBar.setTitle(date);

        // Get the message from the intent
        Intent intent = getIntent();
        String description = intent.getStringExtra(ActionForm.DESCRIPTION);
        String type = intent.getStringExtra(ActionForm.TYPE);
        int importance = intent.getIntExtra(ActionForm.IMPORTANCE, 100);

        String display = "Event Successfully Added!" + "\n" + "\n" +
                "Type: " + type + "\n" +
                "Important?" + " " + importance + "\n" +
                "Description:" + " " + description;
//        Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(display);

//        Set the text view as the activity layout
        setContentView(textView);

        //INSERT INTO DATABASE
        TaskContract.Columns col;
        col = new TaskContract.Columns(description,type,importance);
        TaskCRUD crud = new TaskCRUD(this);
        crud.insert(col);
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
