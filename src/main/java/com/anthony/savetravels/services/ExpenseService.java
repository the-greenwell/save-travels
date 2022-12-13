package com.anthony.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony.savetravels.models.Expense;
import com.anthony.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}

	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}
	public List<Expense> getAll(){
		return expenseRepo.findAll();
	}
	public Expense getOne(Long expenseId) {
		Optional<Expense> expense = expenseRepo.findById(expenseId);
		if(expense.isPresent()) {
			return expense.get();
		}
		return null;
	}
	public Expense update(Long id, String name, String vendor, Double amount, String description) {
		Expense updatedExpense = new Expense(id, name, vendor, amount, description);
		return expenseRepo.save(updatedExpense);
	}
	public Expense update(Expense expense) {
		return expenseRepo.save(expense);
	}
	public String deleteById(Long id) {
		expenseRepo.deleteById(id);
		return "Deleted " + id;
	}
}
