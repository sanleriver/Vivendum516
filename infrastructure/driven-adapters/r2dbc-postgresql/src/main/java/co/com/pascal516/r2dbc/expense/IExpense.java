package co.com.pascal516.r2dbc.expense;

import co.com.pascal516.r2dbc.expense.data.ExpenseEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface IExpense extends ReactiveCrudRepository<ExpenseEntity, UUID> {
}
