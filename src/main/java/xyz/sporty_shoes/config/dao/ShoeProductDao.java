package xyz.sporty_shoes.config.dao;

import java.util.List;

import xyz.sporty_shoes.config.entity.ShoeProduct;

public interface ShoeProductDao {

	public List<ShoeProduct> listShoeProducts();

	public ShoeProduct getShoeProductById(int id);

	public void addShoeProduct(ShoeProduct shoeProduct);

	public void updateShoeProduct(ShoeProduct shoeProduct, int id);

	public void deleteShoeProduct(int id);
}
