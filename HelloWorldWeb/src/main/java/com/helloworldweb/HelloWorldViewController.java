package com.helloworldweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.helloworldweb.dao.ProductDAO;
import com.helloworldweb.entity.Product;

@Controller
public class HelloWorldViewController {
	@Autowired
	private RestFacade restFacade;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("helloworld")
	public String view() {
		return "helloworld.jsp";
	}
	
	@RequestMapping("acceptFormData")
	public ModelAndView acceptFormData(@RequestParam("helloworldtext") String helloworldtext) {
		System.out.println("Print the information from web page: " + helloworldtext);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("helloworld.jsp");
		modelAndView.addObject("helloworldoutput", helloworldtext);
		modelAndView.addObject("restOutput", restFacade.getRestOutput());
		modelAndView.addObject("databaseOutput", productDAO.getProducts());
		modelAndView.addObject("sortedDatabaseOutput", productDAO.listProductsOrderByIdentifier());
		return modelAndView;
	}
	
	
	@RequestMapping(value = "createProduct", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView createProduct(@RequestParam("id") long pId,
									  @RequestParam("identifier") String pIdentifier,
									  @RequestParam("partnumber") String pPartNumber,
									  @RequestParam("status") String pStatus) {
		System.out.println("Received control in createProduct: " + pId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("helloworld.jsp");
		Product vProduct = new Product();
		vProduct.setId(pId);
		vProduct.setIdentifier(pIdentifier);
		vProduct.setPartnumber(pPartNumber);
		vProduct.setStatus(pStatus);
		Product vCreatedProduct = productDAO.saveProduct(vProduct);
		modelAndView.addObject("createdProduct", vCreatedProduct);
		return modelAndView;
	}
}
