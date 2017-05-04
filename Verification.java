import java.util.ArrayList;
import java.util.Scanner;

public class Verification {
	
//	public  void  Veri (){
	public static void main(String[] args){

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		ArrayList<Person> ArrPerson = new ArrayList<Person>();
		Person admin = new Person(1,44127, "Admin", "Admin");
		ArrPerson.add(admin);
		DataBase data1 = new DataBase(ArrPerson);
		
		ArrayList<BlackList> ArrBlackList = new ArrayList<BlackList>();
		BlackList bl1 = new BlackList(28745);
		ArrBlackList.add(bl1);
		DataBaseID dataBL = new DataBaseID(ArrBlackList);
		
		System.out.println("House Panel");
		System.out.println("Press 1 for admin panel, 2 for guest panel");
		int Hchoice = scanner.nextInt();
	 while( Hchoice != 1 && Hchoice != 2){
		  System.out.println("Press 1 for admin panel, 2 for guest panel");
		  Hchoice = scanner.nextInt();
		  if(Hchoice == 1 && Hchoice ==2){
				  break;
		  }
	  }
	 String pass ="csulaCS";
	 String Pinput;
	 Boolean access = false;
	 int countA =0;
	 while(Hchoice ==1){
		 System.out.println("Enter password for admin panel");
		 Pinput = scanner.next();
		 if(Pinput.equals(pass)){
			access = true; 
			System.out.println("access");
			break;
		 }
		 else{
			 System.out.println("access denied");
			 countA++;
		 }
		 if( countA ==3){
			 System.out.println("Exit");
			 break;
		 }
	 }
	 
		while (access == true) {
			System.out.println(
					"Press 1 = create account, 2 = list of accounts , 3 = change users info , 4 = blacklist pass code,"
					+ "5 = delete user account , 6 = go to user panel , 7 = exit");
			int choice = scanner.nextInt();

			if (choice == 1) {

				System.out.println("\n");
				System.out.println("Adding to database");
				System.out.println("How many guests to add into the database : ");
				Integer count = scanner.nextInt();
				System.out.println("\n");

				int guestC = 0;

				int id = admin.id + 1;
				String f, l;
				Integer passC;

				while (count >0) {
					System.out.println("Enter pass code " + guestC + " : ");
				    scanner.nextLine();
				    passC = scanner.nextInt();
					System.out.println("Enter First Name " + guestC + " : ");
				    scanner.nextLine();
				    f = scanner.nextLine();
					System.out.println("Enter Last Name " + guestC + " : ");
					l = scanner.nextLine();

					Person test = new Person(id,passC, f, l);
					ArrPerson.add(test);

					id++;
					guestC++;

					if (count == guestC) {
						break;
					}
				}
			}
			if (choice == 3) {
				String changeF,changeL;
				System.out.println("Enter an ID number to change user account infor ");
				Integer idNumb = scanner.nextInt();

				data1.displayByID(idNumb);
				System.out.println("Enter First Name "  + " : ");
			    scanner.nextLine();
			    changeF = scanner.nextLine();
				System.out.println("Enter Last Name "  + " : ");
				changeL = scanner.nextLine();
				
				data1.changeFN(changeF, idNumb);
				data1.changeLN(changeL, idNumb);
			}

			if (choice == 2) {
				
				System.out.println(data1.printDatabase());
			}
			if(choice ==4){
				
				dataBL.printDatabaseBL();
			}
			if(choice ==5){
				System.out.println("Enter an ID number to delete user account ");
				Integer idNumb = scanner.nextInt();
				data1.delete(idNumb);
			}
			if(choice ==6){
				System.out.println("Guest Panel");
				break;
			}
			if (choice == 7) {
				System.out.println("Exit");
				break;
			}
		}
		while(Hchoice ==2 ){
			System.out.println("Guest Panel");
			break;
		}
	}
}
