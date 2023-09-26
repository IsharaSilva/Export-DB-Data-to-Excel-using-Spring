package com.springBatch.springBatchSample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBatch.springBatchSample.service.DatabaseExcelService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/jobs")
public class ExcelExportController {
	@Autowired
	private DatabaseExcelService databaseExcelService;
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=customers.xls";

		response.setHeader(headerKey, headerValue);
		
		databaseExcelService.generateExcel(response);
		
		response.flushBuffer();
	}

}
