
/**
 * Write a description of class TicketMachine here.
 *
 * @author tukangtesting
 * @version 0.1
 */
public class TicketMachine
{
     // definisi variabel
     private int price;
     
     private int balance;
     
     private int total;
     
     // yang wajib ada
     public TicketMachine(int cost){
         price = cost;
         balance = 0;
         total = 0;
         
     }
     // basic function
     public int getPrice(){ return price; }
     
     public int getBalance(){ return balance; }
     
     // validation for insert money
     public void insertMoney(int amount){
         if(amount > 0) {
             balance = balance + amount;
         }
         else{
             System.out.println("Not positive amount : " + amount);
         }
     }

     // 
     public void printTicket(){
         if(balance >= price){
             System.out.println("##################");
             System.out.println("The BlueJ line ");
             System.out.println("Ticket ");
             System.out.println("# " + price + " cents. ");
             System.out.println("##################");
             System.out.println();
             total = total + price;
             balance = balance - price ;
             System.out.println("Balance now : " + balance);
         }
         else {
             System.out.println("You must insert another :" + (price - balance) + " cents");
         }
     }
}