package co.com.pascal516.model.expense.gateways;

import co.com.pascal516.model.expense.Expense;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface IExpenseRepository {
    Mono<Expense> findById(UUID expenseId);
}
