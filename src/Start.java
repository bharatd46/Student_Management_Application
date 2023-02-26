import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.*;

public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to student app");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("press 1 to add student");
			System.out.println("press 2 to delete student");
			System.out.println("press 3 to display student");
			System.out.println("press 4 to update student");
			System.out.println("press 5 to exit app");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				//add student
				System.out.println("enter user name: ");
				String name=br.readLine();
				
				System.out.println("enter user phone: ");
				String phone=br.readLine();
				
				System.out.println("enter user city: ");
				String city=br.readLine();
				
				//creating a object
				Studnet st = new Studnet(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("student is added successfully...");
				}else {
					System.out.println("something went wrong try again...");
				}
				System.out.println(st);
			}else if(c==2) {
				//delete student
				System.out.println("Enter the student id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean f =StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("student is deleted successfully...");
				}else {
					System.out.println("something went wrong while deleting try again...");
				}
			}else if(c==3) {
				StudentDao.showAllstudent();
				//display student
			}else if(c==4) {
				System.out.println("Enter the student id to update which data: ");
				int userID = Integer.parseInt(br.readLine());
				
				System.out.println("enter user name: ");
				String name=br.readLine();
				
				System.out.println("enter user phone: ");
				String phone=br.readLine();
				
				System.out.println("enter user city: ");
				String city=br.readLine();
				
				//creating a object
				Studnet stu = new Studnet(name, phone, city);
				
				boolean u = StudentDao.updateStudent(userID, stu);
				
				if(u) {
					System.out.println("student is added successfully...");
				}else {
					System.out.println("something went wrong try again...");
				}
				System.out.println(u);
				
			}
			else if(c==5) {
				//exit app
				break;
			}else {
				
			}
		}
		System.out.println("thank you for using application");
	}
}
