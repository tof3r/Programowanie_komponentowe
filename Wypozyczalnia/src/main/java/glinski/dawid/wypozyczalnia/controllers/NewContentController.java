package glinski.dawid.wypozyczalnia.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import glinski.dawid.wypozyczalnia.book.Ksiazka;
import glinski.dawid.wypozyczalnia.book.KsiazkaServiceImpl;
import glinski.dawid.wypozyczalnia.client.Klient;
import glinski.dawid.wypozyczalnia.client.KlientServiceImpl;
import glinski.dawid.wypozyczalnia.employee.Pracownik;
import glinski.dawid.wypozyczalnia.employee.PracownikServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		if(newID>0)
			model.addAttribute("success",true);
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

	// ////////////////pracownik////////////////////////
	@RequestMapping(value = "/add_employee", method = RequestMethod.GET)
	public String newEmployee(Model model) {
		model.addAttribute("pracownik", new Pracownik());
		return "add_employee";
	}

	@RequestMapping(value = "/add_employee", method = RequestMethod.POST)
	public String newEmployeePOST(Model model, Pracownik pracownik) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		pracownikServImpl = (PracownikServiceImpl) context
				.getBean("employeeServiceImpl");
		pracownikServImpl.dodajPracownika(pracownik);
		return "add_employee";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(ModelMap model, Principal principal) {
			List<Pracownik> pracownicy = pracownikServImpl.wszyscyPracownicy();
			model.addAttribute("klienci", pracownicy);
			return "employees";
	}
	
	// //////////////ksiazka///////////////////////
	@RequestMapping(value = "/add_book", method = RequestMethod.GET)
	public String newBook(Model model) {
		model.addAttribute("ksiazka", new Ksiazka());
		return "add_book";
	}

	@RequestMapping(value = "/add_book", method = RequestMethod.POST)
	public String newBookPOST(Model model, Ksiazka ksiazka,
			@RequestParam("gatunki") int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"content-module.xml");

		ksiazkaServImpl = (KsiazkaServiceImpl) context
				.getBean("ksiazkaServiceImpl");
		ksiazka.setId_gatunku(id);
		ksiazkaServImpl.dodajKsiazke(ksiazka);
		return "add_book";
	}
}
