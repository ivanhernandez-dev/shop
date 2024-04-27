package tv.codely.inventory.products.domain;

import tv.codely.inventory.shared.domain.CategoryId;
import tv.codely.inventory.shared.domain.ProductId;
import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.product.ProductCreatedDomainEvent;

import java.util.Objects;

public final class Product extends AggregateRoot {
	private final ProductId id;
	private final ProductName name;
	private final ProductDescription description;
	private final ProductPrice price;
	private final ProductWeight weight;
	private final ProductColor color;
	private final ProductMaterial material;
	private final CategoryId categoryId;

	private Product() {
		this.id = null;
		this.name = null;
		this.description = null;
		this.price = null;
		this.weight = null;
		this.color = null;
		this.material = null;
		this.categoryId = null;
	}

	public Product(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight, ProductColor color, ProductMaterial material, CategoryId categoryId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.weight = weight;
		this.color = color;
		this.material = material;
		this.categoryId = categoryId;
	}

	public static Product create(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductWeight weight, ProductColor color, ProductMaterial material, CategoryId categoryId) {
		Product product = new Product(id, name, description, price, weight, color, material, categoryId);

		product.record(new ProductCreatedDomainEvent(id.value(), name.value(), price.value(), description.value(), weight.value(), color.value(), material.value(), categoryId.value()));

		return product;
	}

	public ProductId id() {
		return this.id;
	}

	public ProductName name() {
		return this.name;
	}

	public ProductDescription description() {
		return this.description;
	}

	public ProductPrice price() {
		return this.price;
	}

	public ProductWeight weight() {
		return this.weight;
	}

	public ProductColor color() {
		return this.color;
	}

	public ProductMaterial material() {
		return this.material;
	}

	public CategoryId categoryId() {
		return this.categoryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(this.id, product.id) && Objects.equals(this.name, product.name) && Objects.equals(this.description, product.description) && Objects.equals(this.price, product.price) && Objects.equals(this.weight, product.weight) && Objects.equals(this.color, product.color) && Objects.equals(this.material, product.material) && Objects.equals(this.categoryId, product.categoryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.description, this.price, this.weight, this.color, this.material, this.categoryId);
	}
}
