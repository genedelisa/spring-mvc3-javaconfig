package com.rockhoppertech.mvc.web.controller;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.rockhoppertech.mvc.domain.User;
import com.rockhoppertech.mvc.service.UserService;
import com.rockhoppertech.mvc.web.LoginForm;

/**
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LoginControllerTest {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginControllerTest.class);

	@Autowired
	private LoginController loginController;

	@Autowired
	private UserService userService;

	private LocalValidatorFactoryBean localValidatorFactory;

	private final Validator validator;

	{
		this.validator = Validation.buildDefaultValidatorFactory()
				.getValidator();
		this.localValidatorFactory = new LocalValidatorFactoryBean();
		this.localValidatorFactory.setProviderClass(HibernateValidator.class);
		this.localValidatorFactory.afterPropertiesSet();
	}

	@Configuration
	static class LoginControllerTestConfiguration {
		@Bean
		public UserService userService() {
			return Mockito.mock(UserService.class);
		}

		@Bean
		public LoginController loginController() {
			return new LoginController();
		}
	}

	@Before
	public void setup() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("bar@bar.com", "pa$$word"));
		when(this.userService.findByUsername("someValidName")).thenReturn(
				userList);
	}

	@Test
	public void shouldLoginSuccessfully() {

		LoginForm loginForm = new LoginForm();
		loginForm.setUsername("bar@bar.com");
		loginForm.setPassword("pa$$word");

		// set up the mock
		UserService service = mock(UserService.class);
		List<User> userList = new ArrayList<User>();
		userList.add(new User("bar@bar.com", "pa$$word"));
		when(service.findByUsername(loginForm.getUsername())).thenReturn(
				userList);

		LoginController controller = new LoginController();
		controller.setUserService(service);
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		MockHttpServletRequest sr = new MockHttpServletRequest();
		WebRequest request = new ServletWebRequest(sr);
		SessionStatus sessionStatus = new SimpleSessionStatus();
		DataBinder dataBinder = new DataBinder(loginForm);
		BindingResult bindingResult = dataBinder.getBindingResult();

		String view = controller.login(loginForm, bindingResult, request,
				sessionStatus, redirectAttributes);

		logger.info("The view {}", view);
		assertEquals("redirect:welcome", view);

		User user = (User) request.getAttribute("user",
				WebRequest.SCOPE_SESSION);
		logger.info("The user {}", user);
		assertNotNull("the user is in the session", user);

	}

	@Test
	public void shouldNotLoginSuccessfully() {

		LoginForm loginForm = new LoginForm();
		loginForm.setUsername("baduser");
		loginForm.setPassword("pa$$word");

		// set up the mock
		UserService service = mock(UserService.class);
		List<User> userList = new ArrayList<User>();
		userList.add(new User("foo@foo.com", "pa$$word"));
		when(service.findByUsername(loginForm.getUsername())).thenReturn(
				userList);

		LoginController controller = new LoginController();
		controller.setUserService(service);
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		MockHttpServletRequest sr = new MockHttpServletRequest();
		WebRequest request = new ServletWebRequest(sr);
		SessionStatus sessionStatus = new SimpleSessionStatus();
		DataBinder dataBinder = new DataBinder(loginForm);
		BindingResult bindingResult = dataBinder.getBindingResult();
		String view = controller.login(loginForm, bindingResult, request,
				sessionStatus, redirectAttributes);

		logger.info("The view {}", view);
		assertEquals("The view is login", "redirect:login", view);

		assertNull("the user is not in the session",
				request.getAttribute("user", WebRequest.SCOPE_SESSION));

		String message = (String) redirectAttributes.getFlashAttributes().get(
				"message");
		logger.info("the message '{}'", message);
		assertNotNull("the message is in the flashmap", message);

	}

	@Test
	public void shouldFailValidationVia303() {
		LoginForm loginForm = new LoginForm();
		loginForm.setUsername("bar@bar.com");
		loginForm.setPassword("i"); // bad value

		Set<ConstraintViolation<LoginForm>> constraintViolations = this.validator
				.validate(loginForm);

		// Set<ConstraintViolation<LoginForm>> constraintViolations = validator
		// .validateProperty(loginForm, "password");

		assertThat("erros exist", constraintViolations.size(), greaterThan(0));
		logger.info("violation count {}", constraintViolations.size());

	}

	@Test
	public void shouldFailDataBindingValidation() {

		LoginForm loginForm = new LoginForm();
		loginForm.setUsername("bar@bar.com");
		loginForm.setPassword("i"); // bad value
		DataBinder dataBinder = new DataBinder(loginForm);
		dataBinder.setValidator(this.localValidatorFactory);
		dataBinder.validate();
		BindingResult bindingResult = dataBinder.getBindingResult();

		logger.info("error count {}", bindingResult.getErrorCount());
		assertThat("erros exist", bindingResult.getErrorCount(), greaterThan(0));
	}

}
