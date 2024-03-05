package john.hospital.converter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;
import org.springframework.beans.BeanUtils;
import john.hospital.dbObjects.FileInfo;
import john.hospital.dbObjects.Patient;
import john.hospital.dto.FileInfoDTO;
import john.hospital.dto.PatientDTO;
import john.hospital.dto.ResponseDTO;

public class ConverterUtil 
{
	private static final String FOLDER_PATH = "D:\\FileStorageSystem\\";
	
	public static Patient convertDTOToDBO(PatientDTO dto)
	{
		String filePath = FOLDER_PATH+dto.getFile().getOriginalFilename();
		 
		   UUID uuid = UUID.randomUUID();
		    Patient patient = new Patient();
		    //creating file object
		    FileInfo fileInfo = new FileInfo();
		    fileInfo.setFileName(dto.getFile().getOriginalFilename());
		    fileInfo.setFilePath(filePath);
		    fileInfo.setFileType(dto.getFile().getContentType());
		    fileInfo.setUniqueFileName(uuid.toString());
		    //set file object to patient
		    patient.setFile(fileInfo);
		     //set patient related properties
		    try
		    {
			  patient.setAadhar(Long.parseLong(dto.getAadhar()));
			  patient.setAddress(dto.getAddress());
			  patient.setAge(Integer.parseInt(dto.getAge()));
			  patient.setEmail(dto.getEmail());
			  patient.setMobNo(Long.parseLong(dto.getMobNo()));
			  patient.setName(dto.getName());
			  patient.setPincode(Integer.parseInt(dto.getPincode()));
		    }
		    catch (Exception e) 
		    {
				  System.out.println(e.getMessage()); 
			}
			  
		    
		return patient;
	}
	
	 
    /* This method meant for converting List of DB Object to List of DTO Object to return response(DBO List To DTO List) */
    public static List<ResponseDTO> convertDBOListToDTOList(List<Patient> dboList)
    {
    	List<ResponseDTO> dtoList = null;
    	if(!dboList.isEmpty() && dboList!=null)
    	{ 
    		  dtoList = dboList.stream()
                    .map(dbo->convertDBOToDTO(dbo))
                    .collect(Collectors.toList()); 
    	}
    	
    	return dtoList;
    }
    
    public static ResponseDTO convertDBOToDTO(Patient dbo)
    {
    	 ResponseDTO  dto = new ResponseDTO();
	     BeanUtils.copyProperties(dbo, dto);
	     FileInfoDTO fDTO = new FileInfoDTO();
	     fDTO.setFileName(dbo.getFile().getFileName());
	     fDTO.setFilePath(dbo.getFile().getFilePath());
	     fDTO.setFileType(dbo.getFile().getFileType());
	     fDTO.setUniqueFileName(dbo.getFile().getUniqueFileName());
	     dto.setDto(fDTO);
	     dto.setId(dbo.getPid());
		return dto;
    }
    
    public static FileInfoDTO convertFileInfoDBOToFileInfoDTO(FileInfo fileDBO)
    {
    	FileInfoDTO fDTO = new FileInfoDTO();
    	 BeanUtils.copyProperties(fileDBO, fDTO);
    	 fDTO.setId(fileDBO.getFileId());
    	 
    	 return fDTO;
    }
}
