package dev.ivanhernandez.inventory.products.application.update;

import dev.ivanhernandez.shared.domain.bus.command.Command;

public class UpdateProductCommand implements Command {
	private final String id;
	private final String name;
	private final String description;
	private final String price;
	private final Double weight;
	private final String color;
	private final String material;
	private final String categoryId;

	public UpdateProductCommand(String id, String name, String description, String price, Double weight, String color, String material, String categoryId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.weight = weight;
		this.color = color;
		this.material = material;
		this.categoryId = categoryId;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String description() {
		return description;
	}

	public String price() {
		return price;
	}

	public Double weight() {
		return weight;
	}

	public String color() {
		return color;
	}

	public String material() {
		return material;
	}

	public String categoryId() {
		return categoryId;
	}
}
