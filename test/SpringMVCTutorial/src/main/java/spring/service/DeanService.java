package spring.service;

import java.util.List;
import spring.model.Dean;

public interface DeanService {

	void saveDean(Dean dean);

	List<Dean> findAllDeans();

	void deleteDeanByName(String name);

	Dean findByUserName(String username);

	void updateDean(Dean dean);
	
	Dean getDean();
	
}
