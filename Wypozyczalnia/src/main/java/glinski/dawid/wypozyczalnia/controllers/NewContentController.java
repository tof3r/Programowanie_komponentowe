package glinski.dawid.wypozyczalnia.controllers;

import glinski.dawid.wypozyczalnia.book.Ksiazka;
import glinski.dawid.wypozyczalnia.book.KsiazkaServiceImpl;
import glinski.dawid.wypozyczalnia.client.Klient;
import glinski.dawid.wypozyczalnia.client.KlientServiceImpl;
import glinski.dawid.wypozyczalnia.employee.Pracownik;
import glinski.dawid.wypozyczalnia.employee.PracownikServiceImpl;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewContentController {

	private KlientServiceImpl klientServImpl;
	private PracownikServiceImpl pracownikServImpl;
	private KsiazkaServiceImpl ksiazkaServImpl;

	// ////////////klient/////////////////////
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("klient", new Klient());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(Model model, Klient klient) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		klientServImpl = (KlientServiceImpl) context
				.getBean("klientServiceImpl");
		int newID = klientServImpl.dodajKlienta(klient);
		if (newID > 0)
			model.addAttribute("success", true);
		return "registered";
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String clients(ModelMap model, Principal principal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		klientServImpl = (KlientServiceImpl) context
				.getBean("klientServiceImpl");
		List<Klient> klienci = klientServImpl.wszyscyKlienci();
		model.addAttribute("klienci", klienci);
		return "clients";
	}

	@RequestMapping(value = "/clients/remove", method = RequestMethod.POST)
	public String clientRemove(HttpServletRequest request, Locale locale,
			Model model, Principal principal, @RequestParam("id") int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		klientServImpl = (KlientServiceImpl) context
				.getBean("klientServiceImpl");
		if (principal != null) {
			klientServImpl.usunKlienta(id);
			model.addAttribute("success", true);
		}
		return "clients";

	}

	// ////////////////pracownik////////////////////////
	@RequestMapping(value = "/employees/add_employee", method = RequestMethod.GET)
	public String newEmployee(Model model) {
		model.addAttribute("pracownik", new Pracownik());
		return "add_employee";
	}

	@RequestMapping(value = "/employees/add_employee", method = RequestMethod.POST)
	public String newEmployeePOST(Model model, Pracownik pracownik) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");
		model.addAttribute("type", "add_employee");
		pracownikServImpl = (PracownikServiceImpl) context
				.getBean("employeeServiceImpl");
		pracownikServImpl.dodajPracownika(pracownik);
		model.addAttribute("success_add", true);
		return "/employees";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(ModelMap model, Principal principal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		pracownikServImpl = (PracownikServiceImpl) context
				.getBean("employeeServiceImpl");
		List<Pracownik> pracownicy = pracownikServImpl.wszyscyPracownicy();
		model.addAttribute("pracownicy", pracownicy);
		return "employees";
	}

	@RequestMapping(value = "/employees/remove", method = RequestMethod.POST)
	public String employeeRemove(HttpServletRequest request, Locale locale,
			Model model, Principal principal, @RequestParam("id") int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		pracownikServImpl = (PracownikServiceImpl) context
				.getBean("employeeServiceImpl");
		if (principal != null) {
			pracownikServImpl.usunPracownika(id);
			model.addAttribute("success", true);
		}
		return "employees";

	}

	@RequestMapping(value = "/employees/edit", method = RequestMethod.POST)
	public String editPatient(HttpServletRequest request, Locale locale,
			Model model, Principal principal,
			@RequestParam("id") int id) {
		if (principal != null) {
			Pracownik pracownik = pracownikServImpl.getPracownik(id);
			model.addAttribute("pracownik",pracownik);
			model.addAttribute("type", "edit");
		}
		return "add_employee";
	}

	// //////////////ksiazka///////////////////////
	@RequestMapping(value = "/books/add_book", method = RequestMethod.GET)
	public String newBook(Model model) {
		model.addAttribute("ksiazka", new Ksiazka());
		return "add_book";
	}

	@RequestMapping(value = "/books/add_book", method = RequestMethod.POST)
	public String newBookPOST(Model model, Ksiazka ksiazka,
			@RequestParam("gatunki") int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		ksiazkaServImpl = (KsiazkaServiceImpl) context
				.getBean("ksiazkaServiceImpl");
		ksiazka.setId_gatunku(id);
		ksiazkaServImpl.dodajKsiazke(ksiazka);
		model.addAttribute("success", true);
		model.addAttribute("type", "add_book");
		return "/books";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String books(ModelMap model, Principal principal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		ksiazkaServImpl = (KsiazkaServiceImpl) context
				.getBean("ksiazkaServiceImpl");
		List<Ksiazka> ksiazki = ksiazkaServImpl.wszystkieKsiazki();
		model.addAttribute("ksiazki", ksiazki);
		return "books";
	}

	@RequestMapping(value = "/books/remove", method = RequestMethod.POST)
	public String bookRemove(HttpServletRequest request, Locale locale,
			Model model, Principal principal, @RequestParam("id") int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		ksiazkaServImpl = (KsiazkaServiceImpl) context
				.getBean("ksiazkaServiceImpl");
		if (principal != null) {
			ksiazkaServImpl.usunKsiazke(id);
			model.addAttribute("success_remove", true);
		}
		return "books";

	}
}
