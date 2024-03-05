package john.hospital.service;

import java.io.IOException;
import java.util.List;

import john.hospital.dto.FileInfoDTO;
import john.hospital.dto.PatientDTO;
import john.hospital.dto.ResponseDTO;

public interface IPatientServiceMgnt 
{
       public ResponseDTO register(PatientDTO dto) throws IllegalStateException, IOException;
       public List<ResponseDTO> getAllPatients();
       public ResponseDTO getSinglePatient(Integer id);
       public FileInfoDTO getFileByUniqueFileName(String uniqueFileName);
       public String delete(Integer id);
}
