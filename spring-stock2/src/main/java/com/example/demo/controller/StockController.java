package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StockController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("answer")
	public String answer(Model model, @RequestParam String stock_name, @RequestParam String stock_price, 
			@RequestParam String stock_total, @RequestParam String stock_price2){
		
		
		Integer st_price = Integer.parseInt(stock_price);
		Integer st_price2 = Integer.parseInt(stock_price2);

		Integer st_total = Integer.parseInt(stock_total);

		Integer hold = st_total / st_price;
		String hold2 = hold.toString();

		Integer value = hold * st_price2;
		
		Integer st_asset = value - st_total;
		
		model.addAttribute("name", stock_name);
		model.addAttribute("hold", hold2);
		model.addAttribute("value", value);
		model.addAttribute("asset", st_asset);

		
		return "answer";

	}
}
