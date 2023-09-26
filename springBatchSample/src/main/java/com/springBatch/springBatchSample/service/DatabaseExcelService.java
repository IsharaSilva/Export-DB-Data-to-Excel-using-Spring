package com.springBatch.springBatchSample.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBatch.springBatchSample.entity.Customer;
import com.springBatch.springBatchSample.repository.CustomerRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class DatabaseExcelService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void generateExcel(HttpServletResponse response) throws Exception {
			
		List<Customer> customers = customerRepository.findAll();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Customers Info");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("customer_id");
		row.createCell(1).setCellValue("country");
		row.createCell(2).setCellValue("first_name");
		row.createCell(3).setCellValue("contact");
		row.createCell(4).setCellValue("dob");
		row.createCell(5).setCellValue("email");
		row.createCell(6).setCellValue("gender");
		row.createCell(7).setCellValue("last_name");
		int dataRowIndex = 1;

		for (Customer customer : customers) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(customer.getId());
			dataRow.createCell(1).setCellValue(customer.getCountry());
			dataRow.createCell(2).setCellValue(customer.getFirstName());
			dataRow.createCell(3).setCellValue(customer.getContactNo());
			dataRow.createCell(4).setCellValue(customer.getDob());
			dataRow.createCell(5).setCellValue(customer.getEmail());
			dataRow.createCell(6).setCellValue(customer.getGender());
			dataRow.createCell(7).setCellValue(customer.getLastName());
			dataRowIndex++;
		}

		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();

	}
}
