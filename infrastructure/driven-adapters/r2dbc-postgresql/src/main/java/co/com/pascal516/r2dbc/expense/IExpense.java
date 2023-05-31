package co.com.pascal516.r2dbc.expense;

import co.com.pascal516.model.expense.Expense;
import co.com.pascal516.r2dbc.expense.data.ExpenseEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.nio.channels.FileChannel;


public interface IExpense extends ReactiveCrudRepository<ExpenseEntity, String> {
    @Transactional
    @Query(value = "INSERT INTO EXPENSE " +
            "(expense_id, booking_id, expense_concept, expense_date, expense_value)" +
            " VALUES (:#{#expense.getId()}, :#{#expense.getBookingId()}, :#{#expense.getExpenseConcept()}," +
            " :#{#expense.getExpenseDate()}, :#{#expense.getValue()})" +
            " RETURNING expense_id, booking_id, expense_concept, expense_date, expense_value")
    Mono<ExpenseEntity> customSave(@Param("expense") Expense expense);
}
