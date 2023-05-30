package co.com.pascal516.model.expense;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Expense {
    private String id;
    private String bookingId;
    private String expenseConcept;
    private LocalDate expenseDate;
    private Long value;
}
