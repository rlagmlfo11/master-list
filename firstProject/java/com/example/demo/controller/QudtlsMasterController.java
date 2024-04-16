package com.example.demo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.QudtlsMaster;
import com.example.demo.service.QudtlsMasterService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class QudtlsMasterController {

	LocalDate now = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	String formattedDate = now.format(formatter);

	@Autowired
	private QudtlsMasterService qudtlsMasterService;

	@GetMapping("/qudtlsMaster")
	public String listQudtls(Model model) {
		model.addAttribute("qudtlsemf", qudtlsMasterService.getAllQudtls());
		return "qudtlsMaster";
	}

	@GetMapping("/download/csv")
	public void downloadCSV(HttpServletResponse response) throws IOException {
		// Set the content type to CSV
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=\"List_" + formattedDate + ".csv\"");

		// Example data, replace this with your method to fetch data
		List<QudtlsMaster> qudtlsemf = qudtlsMasterService.getAllQudtls();

		// Write column headers
		response.getWriter().write("ID,Name,Age,Job,Rank,Reason\n");

		// Write data
		for (QudtlsMaster qudtls : qudtlsemf) {
			response.getWriter().write(String.format("%d,%s,%d,%s,%s,%s\n", qudtls.getId(), qudtls.getName(),
					qudtls.getAge(), qudtls.getJob(), qudtls.getRank(), qudtls.getReason()));
		}

		response.getWriter().flush();
		response.getWriter().close();

	}

}
