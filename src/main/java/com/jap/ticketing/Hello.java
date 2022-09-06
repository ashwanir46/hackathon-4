package com.jap.ticketing;

public class Hello {
    private String schedule_no;
    private String route_no;
    private int ticket_from_stop_id;
    private int ticket_from_stop_seq_no;
    private int ticket_till_stop_id;
    private int ticket_till_stop_seq_no;
    private String ticket_date;
    private String ticket_time;
    private int total_ticket_amount;
    private double travelled_KM;

    public Hello(String schedule_no, String route_no, int ticket_from_stop_id, int ticket_from_stop_seq_no, int ticket_till_stop_id, int ticket_till_stop_seq_no, String ticket_date, String ticket_time, int total_ticket_amount, double travelled_KM) {
        this.schedule_no = schedule_no;
        this.route_no = route_no;
        this.ticket_from_stop_id = ticket_from_stop_id;
        this.ticket_from_stop_seq_no = ticket_from_stop_seq_no;
        this.ticket_till_stop_id = ticket_till_stop_id;
        this.ticket_till_stop_seq_no = ticket_till_stop_seq_no;
        this.ticket_date = ticket_date;
        this.ticket_time = ticket_time;
        this.total_ticket_amount = total_ticket_amount;
        this.travelled_KM = travelled_KM;
    }


    public static void main(String[] args) {

        System.out.println("Hello");
    }
}
