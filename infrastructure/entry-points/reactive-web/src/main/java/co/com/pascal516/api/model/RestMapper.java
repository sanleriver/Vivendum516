package co.com.pascal516.api.model;

import co.com.pascal516.model.booking.BookingGuest;
import co.com.pascal516.model.expense.Expense;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class RestMapper {
    public BookingGuest bookingGuestToModel(BookingGuestDTO bookingGuestDTO){
        return BookingGuest.builder()
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
}
