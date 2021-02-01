package Hotel;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Room rooms = new Room();
        Scanner sc = new Scanner(System.in);
        do {
            showMenus();
            System.out.println("choise :");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise){
                case 1:
                    System.out.println("nhập số lượng khách");
                    int n = Integer.parseInt(sc.nextLine());
                    rooms.addMultiCustomer(n);
                    rooms.showListCustomer();
                    break;
                case 2:
                    System.out.println("Nhập tên khách hàng : ");
                    String identity = sc.nextLine();
                    int index = rooms.findCustomerByIdentity(identity);
                    rooms.deleteCustomerInfo(rooms.customers.get(index));
                    break;
                case 3:
                    rooms.showListCustomer();
                    break;
                case 4:
                    System.out.println("Nhập tên khách hàng cần tìm ");
                    identity = sc.nextLine();
                    index = rooms.findCustomerByIdentity(identity);
                    rooms.showCustomerInfo(rooms.customers.get(index));
                    break;
                case 5:
                    System.out.println("Nhập tên khách hàng cần thanh toán : ");
                    identity = sc.nextLine();
                    System.out.println("Tổng số tiền phải thanh toán là: " + rooms.totalMoney(identity));
                    break;
                case 6:
                    System.out.println(" Nhập tên khách hàng :");
                    identity = sc.nextLine();
                    System.out.println("Cập nhật dịch vụ");
                    int days = Integer.parseInt(sc.nextLine());
                    System.out.println("Vui lòng nhâp loại phòng ");
                    String type = sc.nextLine();
                    rooms.updateCustomerService(identity, days, type);
                    rooms.showCustomerInfo(rooms.customers.get(rooms.findCustomerByIdentity(identity)));
                    break;
            }
        }while (true);
    }
  static void showMenus(){
        System.out.println("1.Thêm khách hàng ");
        System.out.println("2.Xóa khách hàng");
        System.out.println("3.Hiển thị khách hàng");
        System.out.println("4.Tìm kiếm khách hàng");
        System.out.println("5.Thanh toán");
        System.out.println("6.Cập nhật khách hàng");
    }
}
