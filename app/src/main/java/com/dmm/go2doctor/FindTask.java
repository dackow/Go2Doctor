package com.dmm.go2doctor;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by waldekd on 8/23/15.
 */
public class FindTask extends AsyncTask<String, Void, String> {
    public AsyncResponse async_response;
    public static String getResponseForURLandParams(String url, String params, String user_agent) {
        String result = null;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", user_agent);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(params);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + params);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            result = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected String doInBackground(String... params) {
        return getResponseForURLandParams(params[0], params[1], params[2]);
    }



    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        async_response.processFinish(s);
    }

}
