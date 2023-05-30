package co.com.pascal516.r2dbc.expense;

import co.com.pascal516.r2dbc.expense.data.ExpenseEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;



public interface IExpense extends ReactiveCrudRepository<ExpenseEntity, String> {
}
