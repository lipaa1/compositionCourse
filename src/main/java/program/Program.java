/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package program;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;
import entities.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.xml.crypto.Data;


public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date(dd/MM/yyyy: ");
        Date birthDate = sdf.parse(sc.next());
        
        Client client = new Client(name, email, birthDate);
        
        System.out.println();
        System.out.println("Enter order data:");
        System.out.print("Status:");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        
        Order order = new Order(new Date(), status, client);
        
        System.out.print("How many items to this order? ");
        int qtd = sc.nextInt();
        
        for(int i = 1; i<=qtd; i++){
            
            System.out.println("ENTER #" + i +" ITEM DATA:");
            System.out.print("PRODUCT NAME: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            System.out.print("PRODUCT PRICE: ");
            double priceProduct = sc.nextDouble();
            
            Product product = new Product(nameProduct, priceProduct);
            
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            
            OrderItem orderItem = new OrderItem(quantity, priceProduct, product);
            
            order.addItem(orderItem);
        }
        
        System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
        
        sc.close();
    }
}
