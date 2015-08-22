package com.dmm.go2doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements  AsyncResponse{
    String resut = null;
    DataProviderTask data_provider_task = new DataProviderTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        data_provider_task.async_response = this;
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

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btnGenerateDB:
                generateDB();
                break;
            default:
                break;
        }
    }

    private void generateDB() {
        data_provider_task.execute(Globals.TYPE_MAIN_URL, Globals.TYPE_URL_PARAMS, Globals.USER_AGENT);
//        String results = DataProviderTask.getResponseForURLandParams(Globals.TYPE_MAIN_URL, Globals.TYPE_URL_PARAMS, Globals.USER_AGENT);
    }

    @Override
    public void processFinish(String output) {
        resut = output;
    }
}
