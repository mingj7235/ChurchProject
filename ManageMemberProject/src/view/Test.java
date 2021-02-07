package view;

import controller.UserDAO;

public class Test {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		for (int i = 0; i < dao.FindMemberAll().size(); i++) {
			System.out.println(dao.FindMemberAll().get(i).getAge());
		}
	}
}
