package co.com.pascal516.api.model;

import co.com.pascal516.model.booking.Booking;
import co.com.pascal516.model.booking.BookingGuest;
import co.com.pascal516.model.expense.Expense;
import co.com.pascal516.model.guest.Guest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class RestMapper {
    public BookingGuest bookingGuestToModel(BookingGuestDTO bookingGuestDTO){
        return BookingGuest.builder()
                .guestId(String.valueOf(UUID.randomUUID()))
                .bookingId(String.valueOf(UUID.randomUUID()))
                .contactNumber(bookingGuestDTO.getContactNumber())
                .name(bookingGuestDTO.getName().toUpperCase())
                .entryDate(LocalDate.parse(bookingGuestDTO.getEntryDate()))
                .exitDate(LocalDate.parse(bookingGuestDTO.getExitDate()))
                .value(bookingGuestDTO.getValue())
                .build();
    }

    public Expense expenseToModel(ExpenseDTO expenseDTO){
        return Expense.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .bookingId(expenseDTO.getBookingId())
                .expenseConcept(expenseDTO.getExpenseConcept())
                .expenseDate(LocalDate.parse(expenseDTO.getExpenseDate()))
                .value(expenseDTO.getValue())
                .build();
    }

    public Guest guestToModel(GuestDTO guestDTO){
        return Guest.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .name(guestDTO.getName())
                .contactNumber(guestDTO.getContactNumber())
                .build();
    }

    public Booking bookingToModel(BookingDTO bookingDTO){
        return Booking.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .guestId(bookingDTO.getGuestId())
                .entryDate(bookingDTO.getEntryDate())
                .exitDate(bookingDTO.getExitDate())
                .value(bookingDTO.getValue())
                .build();
    }
}
