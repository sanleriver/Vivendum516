package co.com.pascal516.r2dbc.expense.data;

import co.com.pascal516.model.expense.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ExpenseMapper {
    public Expense toModel(ExpenseEntity expenseEntity){
        return Expense.builder()
                .id(expenseEntity.getIdExpense())
                .bookingId(expenseEntity.getIdBooking())
                .expenseConcept(expenseEntity.getConcept())
                .expenseDate(expenseEntity.getExpenseDate())
                .value(expenseEntity.getValue())
                .build();
    }
}
