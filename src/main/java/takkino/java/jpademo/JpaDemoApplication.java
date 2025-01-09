package takkino.java.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import takkino.java.jpademo.entities.Product;
import takkino.java.jpademo.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private  ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}


	@Override
	public void run(String... args) {
		productRepository.save(new Product("Computer",300.0,21));
		productRepository.save(new Product("Phones",100.0,311));
		productRepository.save(new Product("Smartphone",200.0,211));

		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			System.out.println("Product: " + product.getName() + "ID : "+ product.getId() + " Price: " + product.getPrice() + " Quantity: " + product.getQuantity());
			System.out.println("+++++++++++");
		}
			System.out.println("+++++++++++");
		System.out.println("La liste des products dont le nom contient 'ne'");
		List<Product> products2 = productRepository.findByNameContainsIgnoreCase("ne");
		products2.forEach(product -> {
			System.out.println("Product: " + product.getName() + "ID : "+ product.getId() + " Price: " + product.getPrice() + " Quantity: " + product.getQuantity());
			System.out.println("+++++++++++");
		});
		System.out.println("+++++++++++");
		System.out.println("La liste des produits avec search query");
		List<Product> product3 = productRepository.search("Phones", 10.0);
		product3.forEach(product -> {
			System.out.println("Product: " + product.getName() + " ID: " + product.getId()
					+ " Price: " + product.getPrice() + " Quantity: " + product.getQuantity());
			System.out.println("+++++++++++");
		});

	}
}
