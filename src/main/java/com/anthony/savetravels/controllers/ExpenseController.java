package com.anthony.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthony.savetravels.models.Expense;
import com.anthony.savetravels.services.ExpenseService;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

	public final ExpenseService expenseServ;
	public ExpenseController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	@GetMapping("")
	public String allExpenses(Model model, @ModelAttribute("expense") Expense expense) {
		model.addAttribute("allExpenses", expenseServ.getAll());
		return "showAll.jsp";
	}
	@PostMapping("")
	public String newExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/expense";
		}
		expenseServ.create(expense);
		return "redirect:/expense";
	}
	@GetMapping("/{id}")
	public String oneExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseServ.getOne(id);
		model.addAttribute("expense", expense);
		return "showOne.jsp";
	}
	@GetMapping("/{id}/edit")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseServ.getOne(id));
		return "edit.jsp";
	}
	@PutMapping("/{id}/edit")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		expenseServ.update(expense);
		return "redirect:/expense/" + expense.getId();
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseServ.deleteById(id);
		return "redirect:/expense/";
	}
}
