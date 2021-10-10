package xyz.sporty_shoes.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xyz.sporty_shoes.config.entity.PurchaseReports;

@Repository
public class PurchaseReportsDaoImpl implements PurchaseReportsDao {

//	@Autowired
	private Session session;
	
	@Autowired
	public PurchaseReportsDaoImpl(Session session) {
		this.session = session;
	}
	
	public PurchaseReportsDaoImpl() {
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	@Transactional
	public List<PurchaseReports> listPurchaseReports() {
		return session.createQuery("from PurchaseReports").getResultList();
	}

	@Override
	@Transactional
	public PurchaseReports getPurchaseReportsById(int id) {
		PurchaseReports purchaseReports = session.get(PurchaseReports.class, id);
		return purchaseReports;
	}

	@Override
	@Transactional
	public void addPurchaseReports(PurchaseReports purchaseReports) {
		session.save(purchaseReports);
	}

	@Override
	@Transactional
	public void updatePurchaseReports(PurchaseReports purchaseReports, int id) {
		PurchaseReports pr= getPurchaseReportsById(id);
		pr = purchaseReports;
		session.saveOrUpdate(pr);
		System.out.println("Purchase Reports updated.");
	}

	@Override
	@Transactional
	public void deletePurchaseReportsById(int id) {
		session.createQuery("delete from Purchase_Reports c where c.id='" + id + "'").executeUpdate();
		System.out.println("PurchaseReports deleted.");
	}

}
