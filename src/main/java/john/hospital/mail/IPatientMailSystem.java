package john.hospital.mail;

import java.io.IOException;
import java.util.Map;

import freemarker.template.TemplateException;
import john.hospital.dto.PatientDTO;

public interface IPatientMailSystem 
{
     public  String patientCreationMailTriggering(Map<String,Object> map, String[] toEmails) throws IOException, TemplateException;
     
}
