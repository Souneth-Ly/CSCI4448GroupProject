package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.DeanDao;
import spring.model.Dean;

@Service("deanService")
@Transactional
public class DeanServiceImpl implements DeanService{

	@Autowired
	private DeanDao dao;
	

	public void saveDean(Dean dean) {
		dao.saveDean(dean);
	}

	public List<Dean> findAllDeans() {
		return dao.findAllDeans();
	}

	public void deleteDeanByName(String name) {
		dao.deleteDeanByName(name);
	}

	public Dean findByUserName(String username) {
		return dao.findByUserName(username);
	}

	public void updateDean(Dean dean){
		dao.updateDean(dean);
	}
	
	public Dean getDean(){
		return dao.getDean();
	}
}
