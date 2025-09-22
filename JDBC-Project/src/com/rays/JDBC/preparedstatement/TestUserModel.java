package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

//		testAdd();
//	    testDelete();
//		testUpdate();
//		testFindByLogin();
//		testAuthetication();
		testChangePassword();
//		testSearch();

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
	
	public static void testChangePassword() throws Exception {
	
		UserModel model = new UserModel();
		model.changePassword("krati23", "krati123", "krati27_");
	}
	
	
	public static void testSearch() throws Exception {
		
		UserModel model = new UserModel();
		List list = model.search(null);
		Iterator<UserBean> it = list.iterator();
		
		while (it.hasNext()) {
			UserBean bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
			
		}
		
	}
	
	

}
