package spring.dao;

import java.util.List;
import spring.model.Dean;

public interface DeanDao {

	void saveDean(Dean dean);
	
	List<Dean> findAllDeans();
	
	void deleteDeanByName(String name);
	
	Dean findByUserName(String username);
	
	Dean getDean();
	
	void updateDean(Dean dean);
}
