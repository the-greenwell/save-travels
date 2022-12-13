package com.anthony.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=1, message="Name cannot be blank")
	private String name;
	@NotBlank
	@Size(min=1, message="Vendor cannot be blank")
	private String vendor;
	@NotNull
	@Min(value=0, message="Must be a valid price")
	private Double amount;
	@NotBlank
	@Size(min=1, message="Description cannot be blank")
	private String description;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	public Expense() {
	}
	public Expense(Long id, @NotNull @Size(min = 1, message = "Name cannot be blank") String name,
			@NotNull @Size(min = 1, message = "Vendor cannot be blank") String vendor,
			@NotNull @Min(value = 0, message = "Must be a valid price") Double amount,
			@NotNull @Size(min = 1, message = "Description cannot be blank") String description) {
		this.id = id;
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	public Expense(@NotNull @Size(min = 1, message = "Name cannot be blank") String name,
			@NotNull @Size(min = 1, message = "Vendor cannot be blank") String vendor,
			@NotNull @Min(value = 0, message = "Must be a valid number") Double amount,
			@NotNull @Size(min = 1, message = "Description cannot be blank") String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
