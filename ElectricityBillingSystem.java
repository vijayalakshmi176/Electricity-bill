import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

class Customer {
    String customerID;
    String name;
    String address;

    public Customer(String customerID, String name, String address) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
    }
}

class Bill {
    Customer customer;
    int unitsConsumed;
    double totalAmount;
    Date billDate;

    public Bill(Customer customer, int unitsConsumed) {
        this.customer = customer;
        this.unitsConsumed = unitsConsumed;
        this.totalAmount = calculateTotalAmount(unitsConsumed);
        this.billDate = new Date(); // Record the billing date
    }

    private double calculateTotalAmount(int units) {
        // Add your billing logic here
        // For simplicity, let's assume a flat rate of $0.10 per unit
        return units * 0.10;
    }
}

class ElectricityBillingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Electricity Billing System");

        // Customer information
        System.out.print("Enter Customer ID: ");
        String customerID = input.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();
        System.out.print("Enter Customer Address: ");
        String address = input.nextLine();

        Customer customer = new Customer(customerID, name, address);

        // Enter units consumed
        System.out.print("Enter Units Consumed: ");
        int unitsConsumed = input.nextInt();

        Bill bill = new Bill(customer, unitsConsumed);

        // Display the bill
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("\nBill Summary:");
        System.out.println("Bill Date: " + dateFormat.format(bill.billDate));
        System.out.println("Customer ID: " + bill.customer.customerID);
        System.out.println("Customer Name: " + bill.customer.name);
        System.out.println("Customer Address: " + bill.customer.address);
        System.out.println("Units Consumed: " + bill.unitsConsumed);
        System.out.println("Total Amount: $" + bill.totalAmount);

        // Additional security measures can be added as needed.
        // For example, you can add data encryption, access control, and audit trails to enhance security.
    }
}

