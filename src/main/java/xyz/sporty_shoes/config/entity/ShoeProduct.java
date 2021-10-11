package xyz.sporty_shoes.config.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("shoeProduct")
@Entity
@Table(name = "shoe_product")
public class ShoeProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shoe_product_id")
	private int id;
	
	@Column(name = "shoe_name")
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private ShoeCategory productCategory;

	public ShoeProduct() {
	}

	public ShoeProduct(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShoeCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ShoeCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "ShoeProduct [id=" + id + ", name=" + name + ", productCategory=" + productCategory + ", customer="
				+ "]";
	}
	
}
