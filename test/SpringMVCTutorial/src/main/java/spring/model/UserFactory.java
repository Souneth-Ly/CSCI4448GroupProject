package spring.model;

import spring.database.DatabaseCaller;


public class UserFactory {
	
	
	public static void newUser(String type, String name,String username,String password, DatabaseCaller stu)
	{
		//____________THIS IMPLEMENTS SINGLETON___________________
		if (type.equals("Dean")) {
			if(stu.getDeanService().getDean()==null){
				Dean dean = new Dean(name,username,password);
				stu.getDeanService().saveDean(dean);
			}
		}//____________THIS IMPLEMENTS SINGLETON___________________
		else if (type.equals("Student")) {
			Student stew = new Student(name,username,password);
			stu.getStudentService().saveStudent(stew);
		} else if (type.equals("Teacher")) {
			Teacher teach = new Teacher(name,username,password);
			stu.getTeacherService().saveTeacher(teach);
		}
	}
	
}
