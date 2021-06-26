package kodlamaio.hrms.dataAccess.abstracts;




//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{
	
	
	JobAdvertisement getById(int id);
	
	//@Query("From JobAdvertisement where isActived = true") //Aktif iş ilanları listelendi
	//List<JobAdvertisement> getAllByActiveJobAdverts();
	
	//@Query("From JobAdvertisement where isActived=true Order By releaseDate") //Aktif iş ilnları tarihe göre listelendi
	//List<JobAdvertisement> getAllByReleasionDateAsc();
	
	
	//@Query("From JoAdvertisement where isActived=true and employer.companyName=:compnayName")
	//List<JobAdvertisement> getAllActiveJobAdvertisementEmployer_CompanyName(String companyName);
	
	
	
	

}
