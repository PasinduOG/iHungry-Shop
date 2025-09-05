import java.util.*;
class IHungry{
	
	final static double BURGERPRICE=500;
	public static final int PREPARING=0;
	public static final int DELIVERED=1;
	public static final int CANCELLLED=2;
	
	public static String[] orderIdArray=new String[]{"B0001","B0002","B0003","B0004"};
	public static int orderCount=orderIdArray.length;
	public static String[] customerIdArray=new String[]{"0702436642","0715518744","0702436642","0702345678"};
	public static String[] nameArray=new String[]{"Pasindu","Sawen","Pasindu","Ravindu"};
	public static int[] qtyArray=new int[]{2,3,7,5};
	public static int[] orderStatusArray={0,1,2,1};
	
	public static String generateOrderId(){
		int nextId=orderCount+1;
		String orderId;
		if(nextId<10){
			orderId="B000"+nextId;
		}else if(nextId<100){
			orderId="B00"+nextId;
		}else if(nextId<1000){
			orderId="B0"+nextId;
		}else{
			orderId="B"+nextId;
		}
		return orderId;
	}
	
	public static String getOrderStatusName(int index){
		if(index==PREPARING){
			return "Preparing";
		}else if(index==DELIVERED){
			return "Delivered";
		}else if(index==CANCELLLED){
			return "Cancelled";
		}else{
			return "";
		}
	}
	
	public static String getName(String key){
		for(int i=0; i<customerIdArray.length; i++){
			if(customerIdArray[i].equalsIgnoreCase(key)){
				return nameArray[i];
			}
		}
		return "";
	}
	
	public static boolean indexOf(String key){
		for(int i=0; i<customerIdArray.length; i++){
			if(key.equalsIgnoreCase(customerIdArray[i])){
				return true;
			}
		}
		return false;
	}
	
	public static boolean searchId(String[] arr, String customerId){
		for(int i=0; i<arr.length; i++){
			if(arr[i].equalsIgnoreCase(customerId)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean searchName(String[] arr, String customerName){
		for(int i=0; i<arr.length; i++){
			if(arr[i].equalsIgnoreCase(customerName)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidCustomerId(String customerId){
		if(customerId.length()!=10){
			return false;
		}
		if(customerId.charAt(0)!='0'){
			return false;
		}
		for(int i=0; i<customerId.length(); i++){
			if(customerId.charAt(i)<'0' || customerId.charAt(i)>'9'){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidOrderId(String orderId){
		if(orderId.length()!=5){
			return false;
		}
		if(orderId.charAt(0)!='B' && orderId.charAt(0)!='b'){
			return false;
		}
		for(int i=1; i<orderId.length(); i++){
			if(orderId.charAt(i)<'0' || orderId.charAt(i)>'9'){
				return false;
			}
		}
		return true;
	}
	
	public static void extendArray(){
		String[] tempOrderId=new String[orderIdArray.length+1];
		for(int i=0; i<orderIdArray.length; i++){
			tempOrderId[i]=orderIdArray[i];
		}
		orderIdArray=tempOrderId;
		
		String[] tempCusId=new String[customerIdArray.length+1];
		for(int i=0; i<customerIdArray.length; i++){
			tempCusId[i]=customerIdArray[i];
		}
		customerIdArray=tempCusId;
		
		String[] tempName=new String[nameArray.length+1];
		for(int i=0; i<nameArray.length; i++){
			tempName[i]=nameArray[i];
		}
		nameArray=tempName;
		
		int[] tempQty=new int[qtyArray.length+1];
		for(int i=0; i<qtyArray.length; i++){
			tempQty[i]=qtyArray[i];
		}
		qtyArray=tempQty;
		
		int[] tempStatus=new int[orderStatusArray.length+1];
		for(int i=0; i<orderStatusArray.length; i++){
			tempStatus[i]=orderStatusArray[i];
		}
		orderStatusArray=tempStatus;
	}
	
	public static boolean isDeliveredOrderId(String orderId){
		for(int i=0; i<orderIdArray.length; i++){
			if(orderId.equalsIgnoreCase(orderIdArray[i])){
				if(orderStatusArray[i]==DELIVERED){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isCancelledOrderId(String orderId){
		for(int i=0; i<orderIdArray.length; i++){
			if(orderId.equalsIgnoreCase(orderIdArray[i])){
				if(orderStatusArray[i]==CANCELLLED){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isOrderStatusId(int newOrderId){
		if(newOrderId==PREPARING || newOrderId==DELIVERED || newOrderId==CANCELLLED){
			return true;
		}
		return false;
	}
	
	public static void placeOrder(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("-----------------------------------------------------------");
			System.out.println("|                       Place Order                       |");
			System.out.println("-----------------------------------------------------------\n\n");
			
			String newOrderId=generateOrderId();
			System.out.printf("ORDER ID - %s\n", newOrderId);
			System.out.println("================\n\n\n");
			
			System.out.print("Enter Customer ID (phone no.) : ");
			String customerId=input.next();
			while(!isValidCustomerId(customerId)){
				System.out.println("\tInvalid phone number... Try again...!\n");
				System.out.print("Enter Customer ID (phone no.) : ");
				customerId=input.next();
			}
			String index=getName(customerId);
			String customerName="";
			if(index.equals("")){
				System.out.print("Enter Customer Name           : ");
				customerName=input.next();
			}else{
				System.out.printf("Customer Name                 : %s\n",index);
			}
			
			System.out.print("Enter Burger Quantity         - ");
			int qty=input.nextInt();
			
			double total=(double)BURGERPRICE*qty;
			System.out.printf("Total Value                   - %.2f\n",total);
			
			System.out.print("\tAre you confirm order - ");
			String confirm=input.next().toLowerCase();
			if(confirm.equals("y")){
				orderCount+=1;
				extendArray();
				
				orderStatusArray[orderStatusArray.length-1]=PREPARING;
				orderIdArray[orderIdArray.length-1]=newOrderId; //add new order id to extended index
				customerIdArray[customerIdArray.length-1]=customerId; //add new customer id to extended index
				if(index.equals("")){
					nameArray[nameArray.length-1]=customerName; //add new user name to extended index
				}else{
					nameArray[nameArray.length-1]=index; //add existing user name to extended index
				}
				qtyArray[qtyArray.length-1]=qty; //add quantity of orders to extended index
				
				
				System.out.println("\n\tYour order is entered to the system successfully...");
				L2:do{
					System.out.print("\nDo you want to place another order (Y/N): ");
					String addNewOrder=input.next().toLowerCase();
					if(addNewOrder.equals("y")){
						continue L1;
					}else if(addNewOrder.equals("n")){
						break L1;
					}else{
						System.out.print("Wrong option");
						continue L2;
					}
				}while(true);
			}else if(confirm.equals("n")){
				L3:do{
					System.out.print("\nDo you want to retry: ");
					String addNewOrder=input.next().toLowerCase();
					if(addNewOrder.equals("y")){
						continue L1;
					}else if(addNewOrder.equals("n")){
						break L1;
					}else{
						System.out.print("Wrong option");
						continue L3;
					}
				}while(true);
			}else{
				continue L1;
			}
		}while(true);
	}
	
	public static void searchBestCustomer(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("-------------------------------------------------------------");
			System.out.println("|                       BEST Customer                       |");
			System.out.println("-------------------------------------------------------------\n\n");
			
			System.out.println("--------------------------------------");
			System.out.printf("%-12s %-15s %7s\n","CustomerID","Name","Total");
			System.out.println("--------------------------------------");
			
			String[] bestCustIdArr=new String[0]; //Duplicate removed array
			String[] bestCustNameArr=new String[0]; //Duplicate removed array
			double[] bestCustTotalArr=new double[qtyArray.length]; //Duplicate removed array
			
			for(int i=0; i<customerIdArray.length; i++){
				if(!searchId(bestCustIdArr,customerIdArray[i])){
					String[] tempCustomerIdArr=new String[bestCustIdArr.length+1];
					for(int j=0; j<bestCustIdArr.length; j++){
						tempCustomerIdArr[j]=bestCustIdArr[j];
					}
					bestCustIdArr=tempCustomerIdArr;
					bestCustIdArr[bestCustIdArr.length-1]=customerIdArray[i];
				}
			}
			
			for(int i=0; i<nameArray.length; i++){
				if(!searchName(bestCustNameArr,nameArray[i])){
					String[] tempCustomerNameArr=new String[bestCustNameArr.length+1];
					for(int j=0; j<bestCustNameArr.length; j++){
						tempCustomerNameArr[j]=bestCustNameArr[j];
					}
					bestCustNameArr=tempCustomerNameArr;
					bestCustNameArr[bestCustNameArr.length-1]=nameArray[i];
				}
			}
			
			for(int i=0; i<bestCustIdArr.length; i++){
				double total=0;
				for(int j=0; j<customerIdArray.length; j++){
					if(customerIdArray[j].equalsIgnoreCase(bestCustIdArr[i])){
						total+=qtyArray[j]*BURGERPRICE;
					}
				}
				bestCustTotalArr[i]=total;
			}
			
			for(int i=0; i<bestCustTotalArr.length-1; i++){
				for(int j=0; j<bestCustTotalArr.length-1; j++){
					if(bestCustTotalArr[j]<bestCustTotalArr[j+1]){
						String tempId=bestCustIdArr[j];
						bestCustIdArr[j]=bestCustIdArr[j+1];
						bestCustIdArr[j+1]=tempId;
						
						double tempTotal=bestCustTotalArr[j];
						bestCustTotalArr[j]=bestCustTotalArr[j+1];
						bestCustTotalArr[j+1]=tempTotal;
						
						String tempName=bestCustNameArr[j];
						bestCustNameArr[j]=bestCustNameArr[j+1];
						bestCustNameArr[j+1]=tempName;
					}
				}
			}
			
			for(int i=0; i<bestCustIdArr.length; i++){
				System.out.printf("%-12s %-15s %8.2f\n",bestCustIdArr[i],bestCustNameArr[i],bestCustTotalArr[i]);
				System.out.println("--------------------------------------");
			}
			
			L2:do{
				System.out.print("\n\tDo you want to go back to main menu? (Y/N)> ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					break L1;
				}else if(retry.equals("n")){
					continue L1;
				}else{
					System.out.println("\n\t\tWrong option\n");
					continue L2;
				}
			}while(true);
		}while(true);
	}
	
	public static void searchOrder(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("|                       SEARCH ORDER DETAILS                       |");
			System.out.println("--------------------------------------------------------------------\n");
			
			System.out.print("Enter order Id - ");
			String orderId=input.next();
			while(!isValidOrderId(orderId)){
				System.out.println("\tInvalid Order ID...Please try again...\n");
				System.out.print("Enter order Id - ");
				orderId=input.next();
			}
			
			boolean haveDetails=false;
			for(int i=0; i<orderIdArray.length; i++){
				if(orderId.equalsIgnoreCase(orderIdArray[i])){
					System.out.println("\n-----------------------------------------------------------------------------");
					System.out.printf("%-10s %-12s %-15s %-10s %-12s %-12s|\n","OrderID", "CustomerID", "Name", "Quantity", "OrderValue", "Status");
					System.out.println("-----------------------------------------------------------------------------");
					System.out.printf("%-10s %-12s %-15s %-10d %-12.2f %-12s|\n",orderIdArray[i], customerIdArray[i], nameArray[i], qtyArray[i], qtyArray[i]*BURGERPRICE, getOrderStatusName(orderStatusArray[i]));
					System.out.println("-----------------------------------------------------------------------------");
					haveDetails=true;
				}
			}
			if(!haveDetails){
				L2:do{
					System.out.print("\n\n\nInvalid Order ID. Do you want to enter again? (Y/N)> ");
					String retry=input.next().toLowerCase();
					if(retry.equals("y")){
						continue L1;
					}else if(retry.equals("n")){
						break L1;
					}else{
						System.out.print("Wrong option");
						continue L2;
					}
				}while(true);
			}
			L3:do{
				System.out.print("\nDo you want to search another order details (Y/N)>: ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					continue L1;
				}else if(retry.equals("n")){
					break L1;
				}else{
					System.out.print("Wrong option");
					continue L3;
				}
			}while(true);
		}while(true);
	}
	
	public static void searchCustomer(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("|                       SEARCH CUSTOMER DETAILS                       |");
			System.out.println("-----------------------------------------------------------------------\n\n");
			
			System.out.print("Enter customer Id - ");
			String customerId=input.next();
			while(!isValidCustomerId(customerId)){
				System.out.println("\tInvalid phone number... Try again...!\n");
				System.out.print("Enter Customer ID (phone no.) : ");
				customerId=input.next();
			}
			
			if(!indexOf(customerId)){
				System.out.println("\n\n\tThis customer ID is not added yet....");
			}else{
				System.out.printf("\n\n\nCustomerID - %s\n",customerId);
				System.out.printf("Name       - %s\n",getName(customerId));
				
				System.out.println("\nCustomer Order details");
				System.out.println("========================\n");
				
				System.out.println("-----------------------------------------");
				System.out.printf(" %-10s %8s %13s \n","Order_ID","Order_Quantity","Total_Value");
				System.out.println("-----------------------------------------");
				for(int i=0; i<customerIdArray.length; i++){
					if(customerId.equalsIgnoreCase(customerIdArray[i])){
						System.out.printf(" %-10s %8d %19.2f\n",orderIdArray[i],qtyArray[i],qtyArray[i]*BURGERPRICE);
						System.out.println("-----------------------------------------");
					}
				}
			}
			L3:do{
				System.out.print("\nDo you want to search another customer details (Y/N)>: ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					continue L1;
				}else if(retry.equals("n")){
					break L1;
				}else{
					System.out.print("Wrong option");
					continue L3;
				}
			}while(true);
		}while(true);
	}
	
	public static void viewOrders(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("------------------------------------------------------------------");
			System.out.println("|                       VIEW ORDER DETAILS                       |");
			System.out.println("------------------------------------------------------------------\n");
			
			System.out.println("[1] Delivered Order");
			System.out.println("[2] Preparing Order");
			System.out.println("[3] Cancel Order");
			System.out.println("[4] Exit to Main Menu");
			
			System.out.print("\nEnter an option to continue > ");
			int option=input.nextInt();
			
			switch(option){
				case 1 : 
					deliveredOrder();
					break;
				case 2 :
					preparingOrder();
					break;
				case 3 :
					cancelOrder();
					break;
				case 4 :
					break L1;
				default :
					System.out.println("\tInvalid option...");
					System.out.print("Do you want to try again? (Y/N) : ");
					String retry=input.next().toUpperCase();
					if(retry.equals("Y")){
						continue L1;
					}else{
						break L1;
					}
			}
		}while(true);
	}
	
	public static void deliveredOrder(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("---------------------------------------------------------------");
			System.out.println("|                       DELIVERED ORDER                       |");
			System.out.println("---------------------------------------------------------------\n\n");
			
			System.out.println("-------------------------------------------------------------------");
			System.out.printf(" %-10s %-16s %-13s %8s %13s |\n","OrderID", "CustomerID", "Name", "Quantity", "OrderValue");
			System.out.println("-------------------------------------------------------------------");
			for(int i=0; i<orderStatusArray.length; i++){
				if(orderStatusArray[i]==DELIVERED){
					System.out.printf(" %-10s %-16s %-13s %5d %16.2f |\n",orderIdArray[i], customerIdArray[i], nameArray[i], qtyArray[i], qtyArray[i]*BURGERPRICE);
					System.out.println("-------------------------------------------------------------------");
				}
			}
			L2:do{
				System.out.print("\nDo you want to go to main menu? (Y/N)> ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					break L1;
				}else if(retry.equals("n")){
					continue L1;
				}else{
					System.out.println("\n\tWrong option");
					continue L2;
				}
			}while(true);
		}while(true);
	}
	
	public static void preparingOrder(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("---------------------------------------------------------------");
			System.out.println("|                       PREPARING ORDER                       |");
			System.out.println("---------------------------------------------------------------\n\n");
			
			System.out.println("-------------------------------------------------------------------");
			System.out.printf(" %-10s %-16s %-13s %8s %13s |\n","OrderID", "CustomerID", "Name", "Quantity", "OrderValue");
			System.out.println("-------------------------------------------------------------------");
			for(int i=0; i<orderStatusArray.length; i++){
				if(orderStatusArray[i]==PREPARING){
					System.out.printf(" %-10s %-16s %-13s %5d %16.2f |\n",orderIdArray[i], customerIdArray[i], nameArray[i], qtyArray[i], qtyArray[i]*BURGERPRICE);
					System.out.println("-------------------------------------------------------------------");
				}
			}
			L2:do{
				System.out.print("\nDo you want to go to main menu? (Y/N)> ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					break L1;
				}else if(retry.equals("n")){
					continue L1;
				}else{
					System.out.println("\n\tWrong option");
					continue L2;
				}
			}while(true);
		}while(true);
	}
	
	public static void cancelOrder(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("---------------------------------------------------------------");
			System.out.println("|                       CANCELLED ORDER                       |");
			System.out.println("---------------------------------------------------------------\n\n");
			
			System.out.println("-------------------------------------------------------------------");
			System.out.printf(" %-10s %-16s %-13s %8s %13s |\n","OrderID", "CustomerID", "Name", "Quantity", "OrderValue");
			System.out.println("-------------------------------------------------------------------");
			for(int i=0; i<orderStatusArray.length; i++){
				if(orderStatusArray[i]==CANCELLLED){
					System.out.printf(" %-10s %-16s %-13s %5d %16.2f |\n",orderIdArray[i], customerIdArray[i], nameArray[i], qtyArray[i], qtyArray[i]*BURGERPRICE);
					System.out.println("-------------------------------------------------------------------");
				}
			}
			L2:do{
				System.out.print("\nDo you want to go to main menu? (Y/N)> ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					break L1;
				}else if(retry.equals("n")){
					continue L1;
				}else{
					System.out.println("\n\tWrong option");
					continue L2;
				}
			}while(true);
		}while(true);
	}
	
	public static void updateOrderDetails(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("|                       UPDATE ORDER DETAILS                       |");
			System.out.println("--------------------------------------------------------------------\n\n");
			
			System.out.print("Enter order Id - ");
			String orderId=input.next();
			while(!isValidOrderId(orderId)){
				System.out.println("\tInvalid Order ID...Please try again...\n");
				System.out.print("Enter order Id - ");
				orderId=input.next();
			}
			
			if(isDeliveredOrderId(orderId)){
				System.out.println("\nThe Order is already delivered...You can not update this order...");
			}else if(isCancelledOrderId(orderId)){
				System.out.println("\nThe Order is already cancelled...You can not update this order...");
			}else{
				for(int i=0; i<orderIdArray.length; i++){
					if(orderId.equalsIgnoreCase(orderIdArray[i])){
						System.out.printf("\nOrderID       - %s\n",orderIdArray[i]);
						System.out.printf("CustomerID    - %s\n",customerIdArray[i]);
						System.out.printf("Name          - %s\n",nameArray[i]);
						System.out.printf("Quantity      - %d\n",qtyArray[i]);
						System.out.printf("OrderValue    - %.2f\n",qtyArray[i]*BURGERPRICE);
						System.out.printf("OrderStatus   - %s\n",getOrderStatusName(orderStatusArray[i]));
					}
				}
				
				L2:do{
					System.out.println("\nWhat do you want to update ?");
					System.out.println("\t(01) Quantity");
					System.out.println("\t(02) Status\n");
					
					System.out.print("Enter your option - ");
					int option=input.nextInt();
				
					switch(option){
						case 1 :
							updateQuantity(orderId);
							break;
						case 2 :
							updateStatus(orderId);
							break;
						default :
							System.out.println("\tWrong option...\n");
							continue L2;
				}
				}while(true);
			}
			
			L3:do{
				System.out.print("\n\nDo you want to update another order details (Y/N)>: ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					continue L1;
				}else if(retry.equals("n")){
					break L1;
				}else{
					System.out.print("Wrong option");
					continue L3;
				}
			}while(true);
		}while(true);
	}
	
	public static void updateQuantity(String orderId){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("Quantity Update");
			System.out.println("================");
			for(int i=0; i<orderIdArray.length; i++){
				if(orderId.equalsIgnoreCase(orderIdArray[i])){
					System.out.printf("\nOrderID       - %s\n",orderIdArray[i]);
					System.out.printf("CustomerID    - %s\n",customerIdArray[i]);
					System.out.printf("Name          - %s\n\n",nameArray[i]);
					
					System.out.print("Enter your quantity update value - ");
					qtyArray[i]=input.nextInt();
					
					System.out.println("\n\tUpdate order quantity successfully...\n");
					
					System.out.printf("New order quantity - %d\n",qtyArray[i]);
					System.out.printf("New order value - %.2f\n\n",qtyArray[i]*BURGERPRICE);
				}
			}
			L2:do{
				System.out.print("Do you want to update another order details (Y/N): ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					updateOrderDetails();
				}else if(retry.equals("n")){
					mainMenu();
				}else{
					System.out.print("Wrong option");
					continue L2;
				}
			}while(true);
		}while(true);
	}
	
	public static void updateStatus(String orderId){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("Status Update");
			System.out.println("================");
			for(int i=0; i<orderIdArray.length; i++){
				if(orderId.equalsIgnoreCase(orderIdArray[i])){
					System.out.printf("\nOrderID       - %s\n",orderIdArray[i]);
					System.out.printf("CustomerID    - %s\n",customerIdArray[i]);
					System.out.printf("Name          - %s\n\n",nameArray[i]);
					
					System.out.println("\t(0)Preparing");
					System.out.println("\t(1)Delivered");
					System.out.println("\t(2)Cancel");
					
					System.out.print("\nEnter new order status - ");
					int newOrderId=input.nextInt();
					while(!isOrderStatusId(newOrderId)){
						System.out.println("\tInvalid status input...Please try again...");
						System.out.print("\nEnter new order status - ");
						newOrderId=input.nextInt();
					}
					orderStatusArray[i]=newOrderId;
					
					System.out.println("\n\tUpdate order quantity successfully...\n");
					
					System.out.printf("New order status - %s\n",getOrderStatusName(orderStatusArray[i]));
				}
			}
			L2:do{
				System.out.print("\n\nDo you want to update another order details (Y/N): ");
				String retry=input.next().toLowerCase();
				if(retry.equals("y")){
					updateOrderDetails();
				}else if(retry.equals("n")){
					mainMenu();
				}else{
					System.out.print("Wrong option");
					continue L2;
				}
			}while(true);
		}while(true);
	}
	
	public static void mainMenu(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("--------------------------------------------------------------");
			System.out.println("|                       iHungry Burger                       |");
			System.out.println("--------------------------------------------------------------\n\n");
			System.out.println("[1] Place Order		[2] Search Best Customer");
			System.out.println("[3] Search Order	[4] Search Customer");
			System.out.println("[5] View Orders		[6] Update Order Details");
			System.out.println("[7] Exit\n\n");
			
			System.out.print("Enter an option to continue > ");
			int option=input.nextInt();
			
			switch(option){
				case 1 :
					placeOrder();
					break;
				case 2 :
					searchBestCustomer();
					break;
				case 3 :
					searchOrder();
					break;
				case 4 :
					searchCustomer();
					break;
				case 5 :
					viewOrders();
					break;
				case 6 :
					updateOrderDetails();
					break;
				default :
					System.out.println("\tInvalid option...");
					System.out.print("Do you want to try again? (Y/N) : ");
					String retry=input.next().toUpperCase();
					if(retry.equals("Y")){
						continue L1;
					}else{
						break L1;
					}
			}
		}while(true);
	}
	
	public static void main(String args[]){
		mainMenu();
	}
	
	public static void clearConsole(){
		try{
			final String os=System.getProperty("os.name");
			if(os.contains("Windows")){
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch(final Exception e){
			e.printStackTrace();
		}
	}
}
