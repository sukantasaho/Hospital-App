package john.hospital.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResponseDTO {

	    private Integer id;
	    private String name;
	    private Integer age;
	    private String address;
	    private Long aadhar;
	    private Long mobNo;
	    private Integer pincode;
	    private String email;
		private FileInfoDTO dto;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Long getAadhar() {
			return aadhar;
		}
		public void setAadhar(Long aadhar) {
			this.aadhar = aadhar;
		}
		public Long getMobNo() {
			return mobNo;
		}
		public void setMobNo(Long mobNo) {
			this.mobNo = mobNo;
		}
		public Integer getPincode() {
			return pincode;
		}
		public void setPincode(Integer pincode) {
			this.pincode = pincode;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public FileInfoDTO getDto() {
			return dto;
		}
		public void setDto(FileInfoDTO dto) {
			this.dto = dto;
		}
		
		 
	 
}
