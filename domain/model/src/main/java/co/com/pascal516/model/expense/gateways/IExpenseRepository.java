package co.com.pascal516.model.expense.gateways;

import co.com.pascal516.model.expense.Expense;
import reactor.core.publisher.Mono;



public interface IExpenseRepository {
    Mono<Expense> findById(String expenseId);

    Mono<Expense> save(Expense expense);
}
