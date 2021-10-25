package menu;

import control.PhonebookManager;
import model.Phonebook;
import storage.PhoneBookFile;

import java.io.IOException;
import java.util.Scanner;

public class MenuPhoneBookManager {
    PhonebookManager phonebookManager = PhonebookManager.getInstance();
    PhoneBookFile phoneBookFile = PhoneBookFile.getInstance();

    private MenuPhoneBookManager() {
    }

    public static MenuPhoneBookManager getInstance() {
        return MenuPhoneBookManager.MenuPhoneBookManagerHelper.INSTANCE;
    }

    private static class MenuPhoneBookManagerHelper {
        private static final MenuPhoneBookManager INSTANCE = new MenuPhoneBookManager();
    }
    public void runMenu(){
        Scanner number = new Scanner(System.in);
        int choice = -1;

        while (choice != 0){
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhập");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi từ file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = number.nextInt();
            switch (choice){
                case 1:
                    phonebookManager.showAllPhoneBook();
                    break;
                case 2:
                    phonebookManager.addPhoneBook(inputPhoneBook());
                    break;
                case 3:
                    phonebookManager.editPhoneBook(inputId());
                    break;
                case 4:
                    phonebookManager.removePhoneBook(inputId());
                    break;
                case 5:
                    searchById();
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    writeFile();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("KHÔNG CÓ VUI LÒNG TRỌN LẠI");
            }
        }
    }

    private void writeFile() {
        try {
            phoneBookFile.writeFile(phonebookManager.getLibraryCardArrayList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        try {
            phonebookManager.setLibraryCardArrayList(phoneBookFile.readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void searchById() {
        Phonebook phonebook = phonebookManager.searchNumberPhoneById(inputId());
        if(phonebook != null){
            System.out.println(phonebook);
        }else {
            System.out.println("Không tìm thấy Số điện thoại");
        }
    }

    private static Phonebook inputPhoneBook() {
        Scanner scanner = new Scanner(System.in);
        String id, group, name, gender, address, yearOfBirth, email, numberPhone;
        System.out.println("NHẬP THÔNG TIN DANH BẠ");
        System.out.print("Nhập id: ");
        id = scanner.nextLine();
        System.out.print("Nhập nhóm: ");
        group = scanner.nextLine();
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        address = scanner.nextLine();
        System.out.print("Nhập năm sinh: ");
        yearOfBirth = scanner.nextLine();
        System.out.print("Nhập email: ");
        email = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        numberPhone = scanner.nextLine();

        return new Phonebook(id,group,name,gender,address,yearOfBirth,email,numberPhone);
    }

    private String inputId() {
        System.out.print("Nhập Id: ");
        Scanner string = new Scanner(System.in);
        return string.nextLine();
    }
}
