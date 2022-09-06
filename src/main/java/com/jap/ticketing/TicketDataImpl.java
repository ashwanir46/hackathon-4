package com.jap.ticketing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketDataImpl {
    public static void main(String[] args) {

        TicketDataImpl object = new TicketDataImpl();
        List<TicketData> ticketDataList = object.readFile("sample.csv");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("schedule_no,route_no,ticket_from_stop_id,ticket_from_stop_seq_no,ticket_till_stop_id,ticket_till_stop_seq_no,ticket_date,ticket_time,total_ticket_amount,travelled_KM");
        System.out.println("Read ticketing data from sample.csv file and store the data in a list \n");
        for (TicketData ticketData : ticketDataList) {
            System.out.println(ticketData);
        }
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Sorting the data as per the distance travelled by a bus in descending order and print distance \n");
        List<TicketData> ticketDataListSorted = object.getAllDataSortedInDescendingOrder(ticketDataList);
        for (TicketData ticketData : ticketDataListSorted) {
            System.out.println(ticketData);
        }
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Calculate the total collections made from the sale of these tickets and print \n");
        int totalAmount = object.getTotalTicketAmount(ticketDataList);
        System.out.println("totalAmount = " + totalAmount);
    }

    // reading data from given sample.csv file and add all data into the List
    public List<TicketData> readFile(String fileName) {
        List<TicketData> salesRecordList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");

                String schedule_no = strings[0];
                String route_no = strings[1];
                int ticket_from_stop_id = Integer.parseInt(strings[2]);
                int ticket_from_stop_seq_no = Integer.parseInt(strings[3]);
                int ticket_till_stop_id = Integer.parseInt(strings[4]);
                int ticket_till_stop_seq_no = Integer.parseInt(strings[5]);
                String ticket_date = strings[6];
                String ticket_time = strings[7];
                int total_ticket_amount = Integer.parseInt(strings[8]);
                double travelled_KM = Double.parseDouble(strings[9]);

                salesRecordList.add(new TicketData(schedule_no, route_no, ticket_from_stop_id, ticket_from_stop_seq_no, ticket_till_stop_id, ticket_till_stop_seq_no, ticket_date, ticket_time, total_ticket_amount, travelled_KM));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salesRecordList;
    }

    // Sort the data as per the distance travelled by a bus in descending order.
    public List<TicketData> getAllDataSortedInDescendingOrder(List<TicketData> ticketDataList) {
        ticketDataList.sort(((o1, o2) -> (int) (o2.getTravelled_KM() - o1.getTravelled_KM())));
        return ticketDataList;
    }

    //total collection


}
