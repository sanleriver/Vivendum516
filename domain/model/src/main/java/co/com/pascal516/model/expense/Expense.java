package co.com.pascal516.model.expense;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Expense {
    private UUID id;
    private UUID bookingId;
    private String expenseConcept;
    private LocalDate expenseDate;
    private Long value;
}
