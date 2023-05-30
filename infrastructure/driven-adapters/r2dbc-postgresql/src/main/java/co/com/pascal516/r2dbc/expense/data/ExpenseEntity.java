package co.com.pascal516.r2dbc.expense.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(value = "EXPENSE")
public class ExpenseEntity {
    @Id
    @Column(value = "expense_id")
    private UUID idExpense;
    @Column(value = "booking_id")
    private UUID idBooking;
    @Column(value = "expense_concept")
    private String concept;
    @Column(value = "expense_date")
    private LocalDate expenseDate;
    @Column(value = "expense_value")
    private Long value;
}
