package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		
		testAdd();
		
		
	}
	
	public static void testAdd() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		bean.setFirstName("Krati");
		bean.setLastName("Trivedi");
		bean.setLogin("krati27_");
		bean.setPassword("kra123");
		bean.setDob(sdf.parse("2002-09-27"));
		model.add(bean);
		
	}

}
