package john.hospital.mail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class PatientMailSystemImp implements IPatientMailSystem 
{
    
	 @Autowired
     private JavaMailSender sender;
	 
	 @Value("${spring.mail.username}")
	 private String fromEmail;
	 
	 @Autowired
	 private Configuration config;
	 
	@Override
	public  String patientCreationMailTriggering(Map<String,Object> model, String[] toEmails) throws IOException, TemplateException 
	{
		      //create the email message
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper;
				try 
				{
					helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
							                       StandardCharsets.UTF_8.name());
					helper.setFrom(fromEmail);
					helper.setTo(toEmails);
					helper.setSubject("Patient Record Template");
					helper.setSentDate(new Date());
					helper.addAttachment("batch1.jpg", new ClassPathResource("batch1.jpg"));
					freemarker.template.Template t = config.getTemplate("email-template.ftl");
					String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
					helper.setText(html,true);
					sender.send(message);
				} 
				catch (MessagingException e) 
				{
					 
					e.printStackTrace();
				}
				
				
				return "Patient Mail Sent Successfully Check Your Email";
	}

}
