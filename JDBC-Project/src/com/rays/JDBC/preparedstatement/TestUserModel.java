package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

//		testAdd();
//	    testDelete();
//		testUpdate();
//		testFindByLogin();
		testAuthetication();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("mihir");
		bean.setLastName("malviya");
		bean.setLogin("mihit_m");
		bean.setPassword("mi1234");
		bean.setDob(sdf.parse("2001-03-08"));
		model.add(bean);
	}

	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(3);
		model.delete(bean);
	}

	public static void testUpdate() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setFirstName("Krati");
		bean.setLastName("Trivedi");
		bean.setLogin("krati27_");
		bean.setPassword("krati123");
		bean.setId(2);
		bean.setDob(sdf.parse("2002-09-27"));
		model.update(bean);

	}
	

	public static void testFindByLogin() throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean existsBean = model.findByLogin("krati27_");
		
		if(existsBean != null) {
			System.out.println("login id is already exist");
		} else {
			System.out.println("no record found");
		}
		
	}
	
	public static void testAuthetication() throws Exception {
		
		UserModel model = new UserModel();
		UserBean existsBean = model.authenticate("krati27_", "krati123");
		
		if (existsBean != null) {
			System.out.println("login successfull");
		} else {
			throw new Exception("username or password is incorrect");
		}
	}
	
	

}
