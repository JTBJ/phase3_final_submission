package xyz.sporty_shoes.config.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xyz.sporty_shoes.config.entity.ShoeCategory;

@Repository
public class ShoeCategoryDaoImpl implements ShoeCategoryDao {

	private Session session;
	
	@Autowired
	public ShoeCategoryDaoImpl(Session session) {
		this.session = session;
	}

	public ShoeCategoryDaoImpl() {
	}

	@Override
	@Transactional
	public List<ShoeCategory> listShoeCategorys() {
		return session.createQuery("from ShoeCategory").getResultList();
	}

	@Override
	@Transactional
	public ShoeCategory getShoeCategoryById(int id) {
		ShoeCategory shoeCategory = session.get(ShoeCategory.class, id);
		return shoeCategory;
	}

	@Override
	@Transactional
	public void addShoeCategory(ShoeCategory shoeCategory) {
		session.save(shoeCategory);
	}

	@Override
	@Transactional
	public void updateShoeCategory(ShoeCategory shoeCategory, int id) {
		ShoeCategory sc = getShoeCategoryById(id);
		sc = shoeCategory;
		session.saveOrUpdate(sc);
		System.out.println("Shoe category updated.");
	}

	@Override
	@Transactional
	public void deleteShoeCategoryById(int id) {
		session.createQuery("delete from ShoeCategory sc where sc.id='" + id + "'").executeUpdate();
		System.out.println("Shoe category deleted with an id of " + id);
	}

}
