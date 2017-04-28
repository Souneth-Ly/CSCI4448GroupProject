package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import spring.model.Dean;

@Repository("deanDao")
public class DeanDaoImpl extends AbstractDao implements DeanDao{

	public void saveDean(Dean dean) {
		if(getDean()==null){
			persist(dean);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Dean> findAllDeans() {
		Criteria criteria = getSession().createCriteria(Dean.class);
		if(criteria.list()==null)
			return null;
		return (List<Dean>) criteria.list();
	}

	public void deleteDeanByName(String name) {
		Query query = getSession().createSQLQuery("delete from Dean where name = :name");
		query.setString("name", name);
		query.executeUpdate();
	}

	
	public Dean findByUserName(String username){
		Criteria criteria = getSession().createCriteria(Dean.class);
		criteria.add(Restrictions.eq("userName",username));
		return (Dean) criteria.uniqueResult();
	}
	
	public Dean getDean(){
		if(findAllDeans().isEmpty()){
			return null;
		}
		return findAllDeans().get(0);
	}
	
	public void updateDean(Dean dean){
		getSession().update(dean);
	}
	
}
