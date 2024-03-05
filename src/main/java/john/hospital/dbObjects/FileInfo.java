package john.hospital.dbObjects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PATIENT_FILE_HISTORY2")
public class FileInfo 
{

	@Id
	@SequenceGenerator(name = "file_gen", sequenceName = "file_seq1", initialValue = 50000, allocationSize = 1)
	@GeneratedValue(generator = "file_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "FILE_ID")
	private Integer fileId;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="FILE_TYPE")
	private  String fileType;
	 
	@Column(name="FILE_PATH")
	private String filePath;
	
	@Column(name="UNIQUE_FILE_NAME")
	private String uniqueFileName;
	
	@Column(name="RECORD_STATUS", length = 10)
    private String recordStatus = "A";
	
	 public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUniqueFileName() {
		return uniqueFileName;
	}

	public void setUniqueFileName(String uniqueFileName) {
		this.uniqueFileName = uniqueFileName;
	}
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	 
	 
}
