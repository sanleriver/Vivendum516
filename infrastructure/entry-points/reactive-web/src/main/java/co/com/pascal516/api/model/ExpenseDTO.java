package co.com.pascal516.api.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ExpenseDTO {
    private String bookingId;
    private String expenseConcept;
    private String expenseDate;
    private Long value;
}
