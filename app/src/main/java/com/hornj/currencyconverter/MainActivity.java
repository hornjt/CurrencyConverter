package com.hornj.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    final double euroConversion = 0.89;

    public void buildImages() {
        ImageView dollarImage = (ImageView)findViewById(R.id.dollarImage);
        ImageView euroImage = (ImageView)findViewById(R.id.euroImage);
        ImageView arrowImage = (ImageView)findViewById(R.id.arrowImage);
        dollarImage.setVisibility(View.VISIBLE);
        euroImage.setVisibility(View.VISIBLE);
        arrowImage.setVisibility(View.VISIBLE);
    }

    public String convertToEuros(String dollars) {
        double parsedInput = Double.parseDouble(dollars);
        return String.valueOf(parsedInput * euroConversion);
    }

    public void convertCurrency(View v) {
        EditText dollarView = (EditText)findViewById(R.id.amountInDollars);
        String dollarsInput = dollarView.getText().toString();
        String dollarsToEuros = convertToEuros(dollarsInput);

        buildImages();
        TextView dollars = (TextView) findViewById(R.id.dollars);
        dollars.setText(dollarsInput);
        TextView euros = (TextView) findViewById(R.id.euros);
        euros.setText(dollarsToEuros);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
