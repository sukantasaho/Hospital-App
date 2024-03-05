package john.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import john.hospital.dbObjects.FileInfo;

public interface IFileInfoRepository extends JpaRepository<FileInfo, Integer> 
{
	public Optional<FileInfo> findByUniqueFileName(String uniqueFileName);
}
