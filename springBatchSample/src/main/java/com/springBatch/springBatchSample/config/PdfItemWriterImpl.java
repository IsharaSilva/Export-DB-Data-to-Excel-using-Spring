package com.springBatch.springBatchSample.config;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.springBatch.springBatchSample.entity.Customer;
import com.springBatch.springBatchSample.generic.PdfItemWriter;

import java.io.FileOutputStream;

import org.springframework.batch.item.Chunk;

public class PdfItemWriterImpl implements PdfItemWriter<Customer> {

	private String outputPath;
	private static final int ITEM_LIMIT = 250;
	private Document currentDocument;
	private PdfWriter currentPdfWriter;
	private int currentItemCount;
	private final Object lock = new Object();

	public PdfItemWriterImpl(String outputPath) {
		this.outputPath = outputPath;
		createNewPdf();
	}

	private int pdfFileCounter = 1;

	private void createNewPdf() {
		synchronized (lock) {
			currentDocument = new Document();
			String newPdfFilePath = outputPath + "_" + pdfFileCounter + ".pdf";
			pdfFileCounter++;
			try {
				currentPdfWriter = PdfWriter.getInstance(currentDocument, new FileOutputStream(newPdfFilePath));
				currentDocument.open();
				currentItemCount = 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void write(Chunk<? extends Customer> chunk) throws Exception {
		try {
			for (Customer customer : chunk) {
				Paragraph paragraph = new Paragraph();
				paragraph.add("ID: " + customer.getId());
				paragraph.add("\nFirst Name: " + customer.getFirstName());
				paragraph.add("\nLast Name: " + customer.getLastName());
				paragraph.add("\nContact No: " + customer.getContactNo());
				paragraph.add("\nCountry: " + customer.getCountry());
				paragraph.add("\nDOB: " + customer.getDob());
				paragraph.add("\nEmail: " + customer.getEmail());
				paragraph.add("\nGender: " + customer.getGender());

				if (currentItemCount >= ITEM_LIMIT) {
					currentPdfWriter.flush();
					currentDocument.close();
					createNewPdf();
				}

				currentDocument.add(paragraph);
				currentItemCount++;
			}
		} finally {
			if (currentDocument != null) {
				currentPdfWriter.flush();
				currentDocument.close();
			}
		}
	}
}
