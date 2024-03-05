package john.hospital.dto;

public class FileInfoDTO 
{
	private Integer id;
	private String fileName;
	private String fileType;
	private String filePath;
	private String uniqueFileName;
	
	public String getUniqueFileName() {
		return uniqueFileName;
	}
	public void setUniqueFileName(String uniqueFileName) {
		this.uniqueFileName = uniqueFileName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
  
	
}
