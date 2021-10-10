package xyz.sporty_shoes.config.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "purchase_reports")
@Qualifier("purchaseReports")
public class PurchaseReports {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private int id;
	
	@UpdateTimestamp
	@Column(name = "date_added")
	private Date dateAdded;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private ShoeCategory shoeCategory;

	public PurchaseReports() {
	}

	public PurchaseReports(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public ShoeCategory getShoeCategory() {
		return shoeCategory;
	}

	public void setShoeCategory(ShoeCategory shoeCategory) {
		this.shoeCategory = shoeCategory;
	}

	@Override
	public String toString() {
		return "PurchaseReports [id=" + id + ", dateAdded=" + dateAdded + ", shoeCategory=" + shoeCategory + "]";
	}

}
