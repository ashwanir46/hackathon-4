package com.jap.ticketing;

import java.util.List;

@FunctionalInterface
public interface TicketTotalAmount {
   public int getTotalTicketAmount(List<TicketData> ticketDataList);
}
