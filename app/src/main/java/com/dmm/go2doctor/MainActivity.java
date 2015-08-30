package com.dmm.go2doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  AsyncResponse{
    String resut = null;
    String final_results = null;
    DataProviderTask data_provider_task = new DataProviderTask();

    //XML controls
    Button btnGenerateDB = null;
    Button btnFind = null;
    ListView lvType = null;
//    Spinner spType = null;
    AutoCompleteTextView tvType = null;

    ArrayAdapter<String> lvAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        btnGenerateDB = (Button)findViewById(R.id.btnGenerateDB);
        btnFind = (Button)findViewById(R.id.btnFind);
        btnFind.setEnabled(false);
        //lvType = (ListView)findViewById(R.id.lvType);
//        spType = (Spinner)findViewById(R.id.spType);
        tvType = (AutoCompleteTextView)findViewById(R.id.tvType);

//        spType.setEnabled(false);
        tvType.setEnabled(false);
        data_provider_task.async_response = this;
        generateDB();
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
            case R.id.btnFind:
                find();
                break;
            default:
                break;
        }
    }

    private static String getDataForMarker(Pair<String,String> pair, String input){
        String res;
        int start = input.indexOf(pair.first) + pair.first.length();
        int end_start = input.indexOf(">",start)+1;
        int end = input.indexOf(pair.second,start);
        res = input.substring(end_start, end).replace("&quot;","").replace("<br />","").replace("&#211;","Ó").trim();
        return res;
    }


    private void find() {
        String type = tvType.getText().toString();
        String encoded = null;
        try {
            encoded = URLEncoder.encode(type, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (encoded != null) {
            String params = "IdOwNfz=9&Swiadczenie=" + encoded + "&Miejscowosc=RZESZ%C3%93W&Swiadczeniodawca=&Ulica=";
            FindTask find_task = new FindTask();
            find_task.async_response = new AsyncResponse() {
                @Override
                public void processFinish(String search_results) {
                    int error_start_pos = search_results.indexOf(Globals.VALIDATION_ERROR_SUMMARY_START_MARKER);
                    int error_end_pos = 0;

                    //check if some errors happened...
                    if (error_start_pos != -1) {
                        error_end_pos = search_results.indexOf(Globals.VALIDATION_ERROR_SUMMARY_STOP_MARKER, error_start_pos);
                        String error_msg = search_results.substring(error_start_pos, error_end_pos);
                        Log.e(Globals.TAG,error_msg);
                    } else{
                        int start_marker_pos = search_results.indexOf(Globals.RESULT_SECTION_START_MARKER);
                        int stop_marker_pos = search_results.indexOf(Globals.RESULT_SECTION_STOP_MARKER);
                        search_results = search_results.substring(start_marker_pos, stop_marker_pos);

                        String[] splitter_results = search_results.split(Globals.RESULTS_DELIMETER);

                        List<SearchResult> result_list = new ArrayList<>();
                        for (String single_result : splitter_results) {
                            if (!single_result.contains("swd")) {
                                continue;
                            }
//            String name = getDataForMarker(name_pair, single_result);
                            String division = getDataForMarker(Globals.DIVISION_PAIR, single_result);
                            System.out.println(division);
//            String address = getDataForMarker(address_pair, single_result);
//            String phone = getDataForMarker(phone_pair, single_result);
//            String first = getDataForMarker(first_pair, single_result);
//            String info_date = getDataForMarker(info_date_pair, single_result);
//            String waiting = getDataForMarker(waiting_pair, single_result);
//            String crossed_out = getDataForMarker(crossed_out_pair, single_result);
//            String waiting_time_out = getDataForMarker(waiting_time_pair, single_result);
//            SearchResult search_result = new SearchResult(name, division,address,phone,first,info_date,waiting,crossed_out,waiting_time_out);
//            System.out.println(search_result.toString());
                        }


                    }
                }
            };
            find_task.execute(Globals.QUEUE_MAIN_URL, Globals.TYPE_URL_PARAMS, Globals.USER_AGENT);
        }
    }

    private void generateDB() {
        btnGenerateDB.setEnabled(false);
        data_provider_task.execute(Globals.TYPE_MAIN_URL, Globals.TYPE_URL_PARAMS, Globals.USER_AGENT);
//        String results = DataProviderTask.getResponseForURLandParams(Globals.TYPE_MAIN_URL, Globals.TYPE_URL_PARAMS, Globals.USER_AGENT);
    }

    @Override
    public void processFinish(String output) {
        resut = output;
        btnGenerateDB.setEnabled(true);

        if(output != null && !output.isEmpty()){
            if(output.startsWith("[\"")){
                output = output.substring(2);
            }
            if(output.endsWith("\"]")){
                output = output.substring(0, output.length()-2);
            }

            String[] parsed_types = output.split(Globals.PARSE_DELIMETER);
            if(parsed_types.length > 0){
                lvAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,parsed_types);
//                lvType.setAdapter(lvAdapter);
//                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,parsed_types, android.R.layout.simple_spinner_item);
                //lvAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                //lvAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

//                spType.setEnabled(false);
//                spType.setAdapter(lvAdapter);

                tvType.setEnabled(true);
                tvType.setThreshold(3);
                tvType.setAdapter(lvAdapter);
                btnFind.setEnabled(true);
            }
        }else{
            //lvType.setAdapter(null);
//            spType.setAdapter(null);
            tvType.setAdapter(null);
            btnFind.setEnabled(false);
        }

        //

    }
}
