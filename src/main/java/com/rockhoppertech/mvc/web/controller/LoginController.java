package com.rockhoppertech.mvc.web.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rockhoppertech.mvc.domain.User;
import com.rockhoppertech.mvc.service.UserService;
import com.rockhoppertech.mvc.web.LoginForm;

/**
 * Handles requests for the application login page.
 * 
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 * 
 */
@Controller
@RequestMapping(value = "/login")
@SessionAttributes("loginForm")
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	private UserService userService;

	@Inject
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// it's a session attribute
	@ModelAttribute("loginForm")
	public LoginForm createForm() {
		logger.info("login create form");
		return new LoginForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createForm(Locale locale, Model model) {
		logger.info("login get");
		return "login";
	}

	/**
	 * @param loginForm
	 * @param bindingResult
	 * @param request
	 * @param sessionStatus
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			@Valid @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult bindingResult, WebRequest request,
			SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {

		logger.info("post user: " + loginForm);

		if (bindingResult.hasErrors()) {
			logger.error(bindingResult.getErrorCount() + " binding errors");
			return null;

		} else {
			List<User> results = null;
			try {
				results = this.userService.findByUsername(loginForm
						.getUsername());
			} catch (Exception e) {
				logger.debug("Bad credential match for {}. unknown user",
						loginForm.getUsername());
				redirectAttributes.addFlashAttribute("message",
						"Bad credential match");
				return "redirect:login";
			}

			if (results.size() == 0) {
				logger.debug("Bad credential match for {}. unknown user",
						loginForm.getUsername());
				redirectAttributes.addFlashAttribute("message",
						"Bad credential match");
				return "redirect:login";
			}

			logger.debug("list " + results);
			User u = results.get(0);
			if (u.getUsername().equals(loginForm.getUsername())
					&& u.getPassword().equals(loginForm.getPassword())) {
				logger.info("Logged in successful");
				redirectAttributes.addFlashAttribute("message",
						"You are logged in");
				request.setAttribute("user", u, WebRequest.SCOPE_SESSION);
				sessionStatus.setComplete();
				return "redirect:welcome";
			} else {
				logger.debug("Bad credential match " + u);
				redirectAttributes.addFlashAttribute("message",
						"Bad credential match");
				return "redirect:login";
			}
		}

	}

}
