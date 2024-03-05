package john.hospital.dbObjects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PATIENT_INFO2")
public class Patient 
{

	@Id
	@SequenceGenerator(name = "patientInfo_gen", sequenceName = "patientInfo_seq1", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "patientInfo_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "PID")
    private Integer pid;
	
	@Column(name = "NAME", length = 30)
    private String name;
	
	@Column(name = "AGE")
    private Integer age;
	
	@Column(name = "ADDRESS", length = 30)
    private String address;
	
	@Column(name = "AADHAR")
    private Long aadhar;
	
	@Column(name = "MOBNO")
    private Long mobNo;
	
	@Column(name = "PINCODE")
    private Integer pincode;
	
	@Column(name = "EMAIL", length = 30)
    private String email;
    
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "FILE_ID")
    private FileInfo file;
    
    @Column(name="RECORD_STATUS", length = 10)
    private String recordStatus = "A";
    
    

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
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

	public FileInfo getFile() {
		return file;
	}

	public void setFile(FileInfo file) {
		this.file = file;
	}
}
