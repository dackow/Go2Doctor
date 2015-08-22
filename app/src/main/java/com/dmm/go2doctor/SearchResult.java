package com.dmm.go2doctor;

/**
 * Created by waldekd on 8/22/15.
 */
public class SearchResult {

    public String name; //swd_nazwa

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getInfo_date() {
        return info_date;
    }

    public void setInfo_date(String info_date) {
        this.info_date = info_date;
    }

    public String getWaiting() {
        return waiting;
    }

    public void setWaiting(String waiting) {
        this.waiting = waiting;
    }

    public String getCrossed_out() {
        return crossed_out;
    }

    public void setCrossed_out(String crossed_out) {
        this.crossed_out = crossed_out;
    }

    public String getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(String waiting_time) {
        this.waiting_time = waiting_time;
    }

    public SearchResult(String name, String division, String address, String phone, String first, String info_date, String waiting, String crossed_out, String waiting_time) {
        this.name = name;
        this.division = division;
        this.address = address;
        this.phone = phone;
        this.first = first;
        this.info_date = info_date;
        this.waiting = waiting;
        this.crossed_out = crossed_out;
        this.waiting_time = waiting_time;
    }

    public String division;//kol_nazwa
    public String address;//opis_2
    public String phone;//opis_2_tel
    public String first;//pierwszy
    public String info_date;//InfoNaDzien
    public String waiting;//ocz - oczekujacy
    public String crossed_out;//skr - liczba skreslonych ??
    public String waiting_time;//czas - czas oczekiwania

}
