package john.hospital.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import freemarker.template.TemplateException;

import org.springframework.http.MediaType;
import john.hospital.dto.FileInfoDTO;
import john.hospital.dto.PatientDTO;
import john.hospital.dto.ResponseDTO;
import john.hospital.mail.IPatientMailSystem;
import john.hospital.service.IPatientServiceMgnt;

@Controller
public class PatientOperationController {

	@Autowired
	private IPatientServiceMgnt service;
	
	@Autowired
	private IPatientMailSystem mail;
	
	@GetMapping("/")
	public String displayHomePage()
	{
		return "home_page";
	}
	
	@GetMapping("/getPatientForm")
	public String displayRegisterForm()
	{
		return "patient_register_form";
	}
	 
	@PostMapping("/register")
	public String registerPatient(RedirectAttributes attr, @ModelAttribute PatientDTO dto) throws IllegalStateException, IOException, TemplateException
	{ 
		 
		   ResponseDTO resDTO = service.register(dto);
		   String res = "Patient and Its Associated object Saved Successfully With Id-"+resDTO.getId();
		   attr.addFlashAttribute("res", res);
		   Map<String, Object> model = new HashMap<String, Object>();
		    model.put("patient", resDTO);
		   String msg = mail.patientCreationMailTriggering(model, new String[] {"ssukanta531@gmail.com","ssukanta520@gmail.com","mksahooktr165@gmail.com","suksahoo1992@gmail.com","suksahoo1993@gmail.com"});
		   attr.addFlashAttribute("emailMsg", msg);
		   
		   return "redirect:getAllPatientsInfo";
	}
	
	@GetMapping("/getAllPatientsInfo")
	public String getAllPatientsInfo(Map<String, Object> map)
	{
		List<ResponseDTO> resListDTO = service.getAllPatients();
		map.put("resList", resListDTO);
		
		return "response_page";
	}
	@GetMapping(value = "/downloadAndView")
	public ResponseEntity<InputStreamResource> downloadAndViewFile(@RequestParam String uniqueFileName) throws FileNotFoundException
	{
		   FileInfoDTO fDTO = service.getFileByUniqueFileName(uniqueFileName);
		   
		    String filePath = fDTO.getFilePath();
		    String fileName = fDTO.getFileName();
		    File file = new File(filePath);
		    HttpHeaders headers = new HttpHeaders();      
		    headers.add("content-disposition", "inline;filename=" +fileName);
		    String contentType = fDTO.getFileType();
		    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		    return ResponseEntity.ok()
		            .headers(headers)
		            .contentLength(file.length())
		            .contentType(MediaType.parseMediaType(contentType))
		            .body(resource);
	}
	@GetMapping("/delete")
	public String deletePatientWithFile(RedirectAttributes attr, @RequestParam Integer id)
	{
		String status = service.delete(id);
 	   String response = null;
 	   if(status.equals("success"))
 	   {   
 		   response = "Record Deleted Successfully With Refference Id-"+id;
 		   attr.addFlashAttribute("res", response);
 		   
 		   return "redirect:getAllPatientsInfo";
 	   }
 	   
 		   response = "Record is not found with id-"+id;
 	   
 	return "redirect:getAllPatientsInfo";
		  
	}
	 
}
