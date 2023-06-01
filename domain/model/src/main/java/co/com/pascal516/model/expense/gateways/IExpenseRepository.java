package co.com.pascal516.model.expense.gateways;

import co.com.pascal516.model.expense.Expense;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface IExpenseRepository {
    Mono<Expense> findById(String expenseId);

    Mono<Expense> save(Expense expense);

    Flux<Expense> findByBookingId(String bookingId);
}
