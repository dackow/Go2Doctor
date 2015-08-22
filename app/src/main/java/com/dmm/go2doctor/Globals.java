package com.dmm.go2doctor;

import android.util.Pair;

/**
 * Created by waldekd on 8/22/15.
 */
public class Globals {
    //NFZ sites settings
    public static String TYPE_MAIN_URL = "http://kolejki.nfz.gov.pl/Informator/GetSwiadczenie";
    public static String TYPE_URL_PARAMS = "isSzpital=false&isPrzychodnia=false&isInne=false&isPopup=true";

    public static String QUEUE_MAIN_URL = "http://kolejki.nfz.gov.pl/Informator/Index/";
    public static String QUEUE_URL_PARAMS = "IdOwNfz=9&Swiadczenie=DZIA%C5%81+%28PRACOWNIA%29+FIZJOTERAPII&Miejscowosc=RZESZ%C3%93W&Swiadczeniodawca=&Ulica=";


    //browser settings
    public static String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/43.0.2357.130 Chrome/43.0.2357.130 Safari/537.36";

    public static String PARSE_DELIMETER = "\",\"";

    //HTML parse constants
    public static String RESULT_SECTION_START_MARKER = "<div id=\"dgvKolejki\">";
    public static String RESULT_SECTION_STOP_MARKER = "<div class=\"navPanel\">";
    public static String RESULTS_DELIMETER = "<div class=\"wynik\">";

    public static String NAME_START_MARKER = "<span class=\"swd_nazwa\"";
    public static String NAME_END_MARKER = "</span>";

    public static String DIVISION_START_MARKER = "<span class=\"kol_nazwa\"";
    public static String DIVISION_END_MARKER = "</span>";

    public static String ADDRESS_START_MARKER = "<div class=\"opis_2\"";
    public static String ADDRESS_END_MARKER = "</div>";

    public static String PHONE_START_MARKER = "<div class=\"opis_2_tel\"";
    public static String PHONE_END_MARKER = "</div>";

    public static String FIRST_START_MARKER = "<div class=\"pierwszy\"";
    public static String FIRST_END_MARKER = "<div class=\"zglos";

    public static String INFO_DATE_START_MARKER = "<div class=\"InfoNaDzien\"";
    public static String INFO_DATE_END_MARKER = "</div>";

    public static String WAITING_START_MARKER = "<div class=\"ocz\"";
    public static String WAITING_END_MARKER = "</div>";

    public static String CROSSED_OUT_START_MARKER = "<div class=\"skr\"";
    public static String CROSSED_OUT_END_MARKER = "</div>";

    public static String WAITING_TIME_START_MARKER = "<div class=\"czas\"";
    public static String WAITING_TIME_END_MARKER = "</div>";

    //marker pairs
    Pair<String,String> NAME_PAIR = new Pair<>(NAME_START_MARKER, NAME_END_MARKER);
    Pair<String,String> DIVISION_PAIR = new Pair<>(DIVISION_START_MARKER, DIVISION_END_MARKER);
    Pair<String,String> ADDRESS_PAIR = new Pair<>(ADDRESS_START_MARKER, ADDRESS_END_MARKER);
    Pair<String,String> PHONE_PAIR = new Pair<>(PHONE_START_MARKER, PHONE_END_MARKER);
    Pair<String,String> FIRST_PAIR = new Pair<>(FIRST_START_MARKER, FIRST_END_MARKER);
    Pair<String,String> INFO_DATE_PAIR = new Pair<>(INFO_DATE_START_MARKER, INFO_DATE_END_MARKER);
    Pair<String,String> WAITING_PAIR = new Pair<>(WAITING_START_MARKER, WAITING_END_MARKER);
    Pair<String,String> CROSSED_OUT_PAIR = new Pair<>(CROSSED_OUT_START_MARKER, CROSSED_OUT_END_MARKER);
    Pair<String,String> WAITING_TIME_PAIR = new Pair<>(WAITING_TIME_START_MARKER, WAITING_TIME_END_MARKER);


}
