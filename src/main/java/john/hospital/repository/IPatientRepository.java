package john.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import john.hospital.dbObjects.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> 
{
	@Query(value = "SELECT * FROM Patient_Info2 WHERE RECORD_STATUS='A' ORDER BY PID", nativeQuery = true)
	public List<Patient> getAllPatients();
}
