package co.com.pascal516.r2dbc.expense;

import co.com.pascal516.model.expense.Expense;
import co.com.pascal516.model.expense.gateways.IExpenseRepository;
import co.com.pascal516.r2dbc.expense.data.ExpenseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Repository
public class ExpenseRepository implements IExpenseRepository {
    private static final Logger log = Logger.getLogger(ExpenseRepository.class.getName());
    private final IExpense iExpense;
    private static final ExpenseMapper mapper = new ExpenseMapper();

    @Override
    public Mono<Expense> findById(String expenseId) {
        log.log(Level.INFO, "FINDING EXPENSE: {0}", expenseId);
        return iExpense.findById(expenseId)
                .map(mapper::toModel);
    }

    @Override
    public Mono<Expense> save(Expense expense) {
        return iExpense.customSave(expense)
                .map(mapper::toModel);
    }
}
