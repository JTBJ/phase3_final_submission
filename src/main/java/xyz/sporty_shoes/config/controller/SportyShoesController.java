package xyz.sporty_shoes.config.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.sporty_shoes.config.dao.CustomerDao;
import xyz.sporty_shoes.config.dao.PurchaseReportsDao;
import xyz.sporty_shoes.config.dao.ShoeCategoryDao;
import xyz.sporty_shoes.config.dao.ShoeProductDao;
import xyz.sporty_shoes.config.entity.Customer;
import xyz.sporty_shoes.config.entity.PurchaseReports;
import xyz.sporty_shoes.config.entity.ShoeCategory;
import xyz.sporty_shoes.config.entity.ShoeProduct;

@Controller
public class SportyShoesController {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ShoeCategoryDao shoeCategoryDao;
	
	@Autowired
	private ShoeProductDao shoeProductDao;
	
	@Autowired
	private PurchaseReportsDao purchaseReportsDao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/show-sporty-shoes-login")
	public String sportyShoesLogin() {
		return "login";
	}

	@RequestMapping("/registration-form")
	public String registrationForm() {
		return "registration-form";
	}

	@RequestMapping("/list-sporty-shoes")
	public String listSportyShoes(Model model) {
		List<ShoeProduct> list = shoeProductDao.listShoeProducts();
		model.addAttribute("shoeProductList", list);
		return "list-sporty-shoes";
	}

	@RequestMapping("/select-sporty-shoes")
	public String selectSportyShoes(Model model) {
		List<ShoeProduct> list = shoeProductDao.listShoeProducts();
		model.addAttribute("shoeProductList", list);
		return "select-sporty-shoes";
	}
	
	@RequestMapping("/add-product-to-customer")
	public String addProductToCustomer(HttpServletRequest request, Model model) {
		PurchaseReports purchaseReports = new PurchaseReports();
		
		int productId = Integer.parseInt(request.getParameter("product_id"));
		int customerId = Integer.parseInt(request.getParameter("customer_id"));
		
		ShoeProduct shoeProduct = shoeProductDao.getShoeProductById(productId);
		Customer customer = customerDao.getCustomerById(customerId);
		
		List<ShoeProduct> list = new ArrayList<>();
		list.add(shoeProduct);
		customer.setShoeProduct(list);
		
		purchaseReports.setShoeCategory(shoeProduct.getProductCategory());
		purchaseReportsDao.addPurchaseReports(purchaseReports);
		
		customerDao.updateCustomer(customer, customerId);
		
		model.addAttribute("customer", customer);
		
		return "add-product-to-customer";
	}

	@RequestMapping("/list-users")
	public String listUsers(Model model) {
		List<Customer> list = customerDao.listCustomers();
		model.addAttribute("customerList", list);
		return "list-users";
	}
	
	@RequestMapping("/categorize-products")
	public String categorizeProducts(Model model) {
		List<ShoeCategory> list = shoeCategoryDao.listShoeCategorys();
		model.addAttribute("categoryList", list);
		return "categorize-products";
	}
	
	@RequestMapping("/categoryChanged")
	public String categoryChanged(HttpServletRequest request, Model model) {
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		String changed = request.getParameter("nameChange");
		
		ShoeCategory shoeCategory = shoeCategoryDao.getShoeCategoryById(categoryId);
		
		shoeCategory.setCategoryName(changed);
		
		shoeCategoryDao.updateShoeCategory(shoeCategory, categoryId);
		
		List<ShoeCategory> list = shoeCategoryDao.listShoeCategorys();
		
		model.addAttribute("categoryList", list);
		
		return "category-changed";
	}
	
	@RequestMapping("/filter-purchase-by-date")
	public String filterByDate(Model model) {
		List<PurchaseReports> list = purchaseReportsDao.listPurchaseReports();
		model.addAttribute("purchaseReports", list);
		return "filter-purchase-by-date";
	}

	@RequestMapping("/filter-purchase-by-Category")
	public String filterByCategory(Model model) {
		List<PurchaseReports> list = purchaseReportsDao.listPurchaseReports();
		model.addAttribute("purchaseReports", list);
		return "filter-purchase-by-category";
	}
	@RequestMapping("/change-password")
	public String changePassword() {
		return "change-password";
	}

}
