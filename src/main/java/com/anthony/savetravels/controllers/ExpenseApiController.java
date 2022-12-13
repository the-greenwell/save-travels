package com.anthony.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.savetravels.models.Expense;
import com.anthony.savetravels.services.ExpenseService;

@RestController
@RequestMapping("/api")
public class ExpenseApiController {
	
	public final ExpenseService expenseServ;
	
	public ExpenseApiController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}

	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(){
		return expenseServ.getAll();
	}
	@PostMapping("/expenses")
	public Expense createExpense(@RequestParam("name") String name, @RequestParam("vendor") String vendor, @RequestParam("amount") Double amount, @RequestParam("description") String description) {
		Expense expense = new Expense(name, vendor, amount, description);
		return expenseServ.create(expense);
	}
	@GetMapping("/expenses/{id}")
	public Expense getOneExpense(@PathVariable("id") Long id) {
		return expenseServ.getOne(id);
	}
	@PutMapping("/expenses/{id}")
	public Expense getOneAndUpdate(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("vendor") String vendor, @RequestParam("amount") Double amount, @RequestParam("description") String description) {
		return expenseServ.update(id, name, vendor, amount, description);
	}
	@DeleteMapping("/expenses/{id}")
	public String delete(@PathVariable("id") Long id) {
		return expenseServ.deleteById(id);
	}
}
