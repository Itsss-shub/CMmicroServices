package com.bank.homeloan.restapi.app.serviceimpl;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bank.homeloan.restapi.app.exception.CustomerApplicationsNotFoundException;
import com.bank.homeloan.restapi.app.model.CustomerDetails;
import com.bank.homeloan.restapi.app.model.SanctionLetter;
import com.bank.homeloan.restapi.app.repository.CustomerRepo;
import com.bank.homeloan.restapi.app.servicei.CustomerServiceI;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.mail.internet.MimeMessage;


@Service
public class CustomerServiceImpl implements CustomerServiceI{

	@Autowired CustomerRepo cri;
	
    @Autowired private JavaMailSender jmsender;
	
	@Autowired @Value("$spring.mail.username") String myMail;
	
	@Override
	public List<CustomerDetails> getAllLoanAppl() {
		List<CustomerDetails> appl = cri.findByStatus("DocVerify");
		
		if(!appl.isEmpty()) {
			return appl;
		}
		else
		{
			throw new CustomerApplicationsNotFoundException("no application  found on in the database");
		}
	}

	@Override
	public List<CustomerDetails> getAllRejcetedLoanAppl() {
		List<CustomerDetails> appl = cri.findByStatus("DocRejceted");
		
		if(!appl.isEmpty()) {
			return appl;
		}
		else
		{
			throw new CustomerApplicationsNotFoundException("no application  found on in the database");
		}
	}

	@Override
	public CustomerDetails getById(Integer customerDetailsId, SanctionLetter st) {
		System.out.println(st);
		Optional<CustomerDetails> app = cri.findById(customerDetailsId);
	
		CustomerDetails appl = app.get();
			if(appl!=null) {
				
				appl.getSanctionLetter().setSanctionLetterId(customerDetailsId);
				appl.getSanctionLetter().setSanctionDate(st.getSanctionDate());
				appl.getSanctionLetter().setApplicantName(st.getApplicantName());
				appl.getSanctionLetter().setContact(st.getContact());
				appl.getSanctionLetter().setLoanAmountSanctioned(st.getLoanAmountSanctioned());
				appl.getSanctionLetter().setInterestType(st.getInterestType());
				appl.getSanctionLetter().setRateOfInterest(st.getRateOfInterest());
				appl.getSanctionLetter().setLoanTenure(st.getLoanTenure());
				appl.getSanctionLetter().setMonthlyEmiAmount(st.getMonthlyEmiAmount());
				appl.getSanctionLetter().setModeOfPayment(st.getModeOfPayment());
				
				String title = "APANA Finance Ltd.";

				Document document = new Document(PageSize.A4);

				String content1 = "\n\n Dear " + appl.getCustomerName()
				+ ","
				+ "\nAPANA Finance Ltd. is Happy to informed you that your loan application has been approved. ";

				String content2 = "\n\nWe hope that you find the terms and conditions of this loan satisfactory "
				+ "and that it will help you meet your financial needs.\n\nIf you have any questions or need any assistance regarding your loan, "
				+ "please do not hesitate to contact us.\n\nWe wish you all the best and thank you for choosing us."
				+ "\n\nSincerely,\n\n" + "Shubham Mane (Credit Manager)";

				ByteArrayOutputStream opt = new ByteArrayOutputStream();
				
				PdfWriter.getInstance(document, opt);
				document.open();

				Image img = null;
				try {
					img=Image.getInstance("C:\\Users\\lenovo\\OneDrive\\Desktop\\zipproject\\apanaFinaceLogo.png");
					img.scalePercent(50, 50);
					img.setAlignment(Element.ALIGN_RIGHT);
					document.add(img);

				} catch (BadElementException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
				Paragraph titlepara = new Paragraph(title, titlefont);
				titlepara.setAlignment(Element.ALIGN_CENTER);
				document.add(titlepara);

				Font titlefont2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
				Paragraph paracontent1 = new Paragraph(content1, titlefont2);
				document.add(paracontent1);

				PdfPTable table = new PdfPTable(2);
				table.setWidthPercentage(100f);
				table.setWidths(new int[] { 2, 2 });
				table.setSpacingBefore(10);

				PdfPCell cell = new PdfPCell();
				cell.setBackgroundColor(CMYKColor.WHITE);
				cell.setPadding(5);

				Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				font.setColor(5, 5, 161);

				Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
				font.setColor(5, 5, 161);

				cell.setPhrase(new Phrase("Loan amount Sanctioned", font));
				table.addCell(cell);

				cell.setPhrase(new Phrase(String.valueOf("₹ " + appl.getSanctionLetter().getLoanAmountSanctioned()),
						font1));
				table.addCell(cell);

				cell.setPhrase(new Phrase("loan tenure", font));
				table.addCell(cell);

				cell.setPhrase(new Phrase(String.valueOf(appl.getSanctionLetter().getLoanTenure()), font1));
				table.addCell(cell);

				cell.setPhrase(new Phrase("interest rate", font));
				table.addCell(cell);

				cell.setPhrase(
						new Phrase(String.valueOf(appl.getSanctionLetter().getRateOfInterest()) + " %", font1));
				table.addCell(cell);

				cell.setPhrase(new Phrase("Sanction letter generated Date", font));
				table.addCell(cell);

				
				appl.getSanctionLetter().setSanctionDate(new Date());
				cell.setPhrase(
						new Phrase(String.valueOf(appl.getSanctionLetter().getSanctionDate()), font1));
				table.addCell(cell);

				cell.setPhrase(new Phrase("Total loan Amount with Intrest", font));
				table.addCell(cell);

				document.add(table);

				Font titlefont3 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
				Paragraph paracontent2 = new Paragraph(content2, titlefont3);
				document.add(paracontent2);
				
				document.close();
				
				ByteArrayInputStream byt = new ByteArrayInputStream(opt.toByteArray());
				byte[] bytes = byt.readAllBytes();
				//customerdetails1.getCustomerSanctionLetter().setSanctionLetter(bytes);
				appl.getSanctionLetter().setSanctionLetter(bytes);
				
				MimeMessage mimemessage = jmsender.createMimeMessage();
				
				byte[] sanctionLetter = appl.getSanctionLetter().getSanctionLetter();

				try {
					MimeMessageHelper mimemessageHelper = new MimeMessageHelper(mimemessage, true);
					mimemessageHelper.setFrom(myMail);
					mimemessageHelper.setTo(appl.getCustomerEmailId());
					mimemessageHelper.setSubject("Apna Finance Corp Ltd-Home Loan Sanction Letter");
					String text = "Dear " + appl.getCustomerName()+
		               "\n" +
		               "We are pleased to inform you that your application for a home loan has been approved. The details of your loan are as follows:\n" +
		               "\n" +
		       
		               "Tenure: " + appl.getSanctionLetter().getLoanTenure() + " years\n" +
		               "Annual Interest Rate: " + appl.getSanctionLetter().getRateOfInterest() + "%\n" +
		               "Total Amount Sanction: $" + String.format("%.2f", appl.getSanctionLetter().getLoanAmountSanctioned()) + "\n" +
		               "\n" +
		               "Thank you for choosing Apna Finance Corp Ltd. We look forward to serving you.\n" +
		               "\n" +
		               "Sincerely,\n" +
		               "Shubham Mane,\n"+
		               "Credit Manager"+
		               "Apna Finance Corp Ltd";
					mimemessageHelper.setText(text);

					mimemessageHelper.addAttachment("loanSanctionLetter.pdf", new ByteArrayResource(sanctionLetter));
					jmsender.send(mimemessage);

				} catch (Exception e) {
					System.out.println("Email Failed to Send!!!!!!");
					e.printStackTrace();
				}
				
				appl.setStatus("sanction");
				
				return cri.save(appl);
			
		
		}else {
			throw new CustomerApplicationsNotFoundException("no appliction present on data base with this id : "+customerDetailsId);
		}
	}


	
   
}
