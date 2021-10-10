package xyz.sporty_shoes.config.dao;

import java.util.List;

import xyz.sporty_shoes.config.entity.ShoeCategory;

public interface ShoeCategoryDao {

	public List<ShoeCategory> listShoeCategorys();

	public ShoeCategory getShoeCategoryById(int id);

	public void addShoeCategory(ShoeCategory shoeCategory);

	public void updateShoeCategory(ShoeCategory shoeCategory, int id);

	public void deleteShoeCategoryById(int id);

}
