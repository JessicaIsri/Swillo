package br.gov.sp.fatec.swillo;

import br.gov.sp.fatec.swillo.enums.CategoryEnum;
import br.gov.sp.fatec.swillo.models.Products;
import br.gov.sp.fatec.swillo.models.User;
import br.gov.sp.fatec.swillo.services.ProductsService;
import br.gov.sp.fatec.swillo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SwilloApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductsService productsService;

	@Test
	void contextLoads() {
	}

	@Test
	void createUserTest()  throws Exception  {
		User user = new User();
		user.setName("Usuário de Teste");
		user.setEmail("teste@mail.com.br");
		user.setPassword("123");
		User newUser = userService.createUser(user);
		assertEquals(user.getEmail(), newUser.getEmail());
		userService.removeById(user.getId());
	}

	@Test
	void updateUserTest() throws Exception {
		User user = new User();
		user.setName("Usuário de Teste Update");
		user.setEmail("testeUpdate@mail.com.br");
		user.setPassword("123");
		User newUser = userService.createUser(user);
		User updateUser = user;
		updateUser.setName("Nome Alterado");
		User userUpdated = userService.updateById(updateUser);
		assertEquals(userUpdated.getName(), updateUser.getName());
		userService.removeById(updateUser.getId());
	}

	@Test
	void deletUser() {
		User user = new User();
		user.setName("Usuário de Teste Delete");
		user.setEmail("testeDelete@mail.com.br");
		user.setPassword("123");
		User newUser = userService.createUser(user);
		assertDoesNotThrow(() -> {userService.removeById(newUser.getId());});
	}

	@Test
	void createProduct() {
		Products products = new Products();
		products.setName("Swillo IPA 600 ml");
		products.setCategory(CategoryEnum.IPA);
		products.setValue(15.0);

		Products productCreated = productsService.createProduct(products);

		assertEquals(productCreated.getName(), productCreated.getName());
		productsService.deleteProductById(productCreated.getId());
	}

	@Test
	void updateProduct() {
		Products products = new Products();
		products.setName("Swillo IPA 600 ml");
		products.setCategory(CategoryEnum.IPA);
		products.setValue(15.0);
		Products productCreated = productsService.createProduct(products);
		productCreated.setCategory(CategoryEnum.APA);
		Products productUpdate = productsService.updateProduct(productCreated);
		assertEquals(CategoryEnum.APA, productUpdate.getCategory());
		productsService.deleteProductById(productCreated.getId());

	}

}
