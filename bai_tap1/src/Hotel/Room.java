package Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
    List<Customer> customers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void inputCustomerInfo() {
        System.out.println("-----------------------------------------");
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh:");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập CMND:");
        String identity = scanner.nextLine();
        System.out.println("Nhập số ngày trọ:");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập loại phòng:");
        String type = scanner.nextLine();
        Customer customer = new Customer(name, dateOfBirth, identity, day, type);
        customers.add(customer);
    }

    public void showCustomerInfo(Customer customer) {
        String showCustomerInfo = "Tên: " + customer.getName();
        showCustomerInfo += "\tNgày sinh: " + customer.getDateOfBirth();
        showCustomerInfo += "\tChứng minh nhân dân: " + customer.getIdentity();
        showCustomerInfo += "\tSố ngày trọ: " + customer.getDay();
        showCustomerInfo += "\tLoại phòng: " + customer.getTypeOfRoom();
        System.out.println(showCustomerInfo);
    }

    public void deleteCustomerInfo(Customer customer) {
        customers.remove(customer);
    }

    public void addMultiCustomer(int n) {
        for (int i = 0; i < n; i++) {
            inputCustomerInfo();
        }
    }

    public void showListCustomer() {
        for (Customer customer : customers) {
            showCustomerInfo(customer);
        }
    }

    public int findCustomerByIdentity(String identity) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdentity().equals(identity)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateCustomerService(String identity, int day, String typeOfRoom){
        for (int i = 0; i < customers.size(); i++){
            if(customers.get(i).getIdentity().equals(identity)){
                customers.get(i).setDay(day);
                customers.get(i).setTypeOfRoom(typeOfRoom);
            }
        }
    }

    public double totalMoney(String identity) {
        int index = findCustomerByIdentity(identity);
        double totalMoney = 0;
        if (index == -1)
            return totalMoney;
        if (customers.get(index).getTypeOfRoom().equals("standard")) {
            totalMoney = customers.get(index).getDay() * 100000;
        } else if (customers.get(index).getTypeOfRoom().equals("luxury")) {
            totalMoney = customers.get(index).getDay() * 120000;
        }
        return totalMoney;
    }
}
