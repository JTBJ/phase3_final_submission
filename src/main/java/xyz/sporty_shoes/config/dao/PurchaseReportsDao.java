package xyz.sporty_shoes.config.dao;

import java.util.List;

import xyz.sporty_shoes.config.entity.PurchaseReports;

public interface PurchaseReportsDao {

	public List<PurchaseReports> listPurchaseReports();
	
	public PurchaseReports getPurchaseReportsById(int id);
	
	public void addPurchaseReports(PurchaseReports purchaseReports);
	
	public void updatePurchaseReports(PurchaseReports purchaseReports, int id);
	
	public void deletePurchaseReportsById(int id);
		
}
