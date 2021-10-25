package control;

import model.Phonebook;
import storage.PhoneBookFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class PhonebookManager {
    ArrayList<Phonebook> phonebookArrayList = new ArrayList<>();


    private PhonebookManager() {
    }

    public static PhonebookManager getInstance() {
        return PhonebookManager.PhonebookManagerHelper.INSTANCE;
    }

    private static class PhonebookManagerHelper{
        private static final PhonebookManager INSTANCE = new PhonebookManager();
    }

    public PhonebookManager(ArrayList<Phonebook> libraryCardArrayList) {
        this.phonebookArrayList = libraryCardArrayList;
    }

    public ArrayList<Phonebook> getLibraryCardArrayList() {
        return phonebookArrayList;
    }

    public void setLibraryCardArrayList(ArrayList<Phonebook> libraryCardArrayList) {
        this.phonebookArrayList = libraryCardArrayList;
    }

    public void addPhoneBook(Phonebook phonebook){
        phonebookArrayList.add(phonebook);
    }

    public void editPhoneBook(String id){
        Phonebook phonebook = searchNumberPhoneById(id);
        if(phonebook != null){
            inputPhoneBook(phonebook);
        } else {
            System.out.println("Không tìm số điện thoại");
        }
    }

    public void removePhoneBook(String id) {
        Phonebook phonebook = searchNumberPhoneById(id);
        if (phonebook != null) {
            for (int i = 0; i < phonebookArrayList.size(); i++) {
                if (phonebookArrayList.get(i).equals(phonebook)) {
                    phonebookArrayList.remove(i);
                }
            }
        } else {
            System.out.println("Không tìm thấy số điện thoại");
        }
    }

    public void showAllPhoneBook(){
        for (Phonebook phonebook: phonebookArrayList) {
            System.out.println(phonebook);
        }
    }

    private void inputPhoneBook(Phonebook phonebook) {
        Scanner scanner = new Scanner(System.in);
        String group, name, gender, address, yearOfBirth, email, numberPhone;
        System.out.println("NHẬP LẠI THÔNG TIN DANH BẠ");
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
        phonebook.setGroup(group);
        phonebook.setName(name);
        phonebook.setGender(gender);
        phonebook.setAddress(address);
        phonebook.setYearOfBirth(yearOfBirth);
        phonebook.setEmail(email);
        phonebook.setNumberPhone(numberPhone);
    }


    public Phonebook searchNumberPhoneById(String code){
        Phonebook phonebook = null;
        for (Phonebook value : phonebookArrayList) {
            if (value.getId().equalsIgnoreCase(code)) {
                phonebook = value;
                break;
            }
        }
        return phonebook;
    }


}
