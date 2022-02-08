package com.publicissapient.creditcard;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.publicissapient.creditcard.controller.CreditCardController;
import com.publicissapient.creditcard.entity.CreditCard;
import com.publicissapient.creditcard.service.CreditCardService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CreditCardTest {

	private MockMvc mockMvc;

	@MockBean

	@InjectMocks
	private CreditCardService creditCardService;

	@Autowired

	@InjectMocks
	private CreditCardController creditCardController;

	@BeforeEach
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(creditCardController).build();
	}

	@org.junit.jupiter.api.Test
	public void testCreateCreditCard() throws Exception {
		creditCardController = new CreditCardController();
		creditCardService = new CreditCardService();
		mockMvc = MockMvcBuilders.standaloneSetup(creditCardController).build();

		when(null);
		String json = "{\n" + "  \"creditCardNumber\": \"79927398713\",\n" + "  \"userName\": \"Shruti123\",\n"
				+ "  \"limit\": \"12\"\n" + "}";

		mockMvc.perform(post("/creditcard/").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andExpect(jsonPath("$.creditCardNumber", Matchers.is("79927398713")))
				.andExpect(jsonPath("$.userName", Matchers.is("Shruti123")));

	}

	@org.junit.jupiter.api.Test
	public void testGetAllCreditDetails() throws Exception {
		List<CreditCard> creditCardList = new ArrayList<>();
		CreditCard creditCard = new CreditCard();
		creditCard.setBalance(0);
		creditCard.setCreditCardNumber("79927398713");
		creditCard.setLimit(15);
		creditCard.setUserName("Shruti");

		creditCardList.add(creditCard);

		creditCardController = new CreditCardController();
		// creditCardService = new CreditCardService();
		mockMvc = MockMvcBuilders.standaloneSetup(creditCardController).build();

		when(creditCardService.getAllCreditCardDetails()).thenReturn(creditCardList);

		mockMvc.perform(get("/creditcard//details").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.creditCardNumber", Matchers.is("79927398713")))
				.andExpect(jsonPath("$.limit", Matchers.is("12")))
				.andExpect(jsonPath("$.userName", Matchers.is("Shruti123")));

	}
}
