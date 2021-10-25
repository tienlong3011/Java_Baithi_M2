package storage;

import model.Phonebook;

import java.io.*;
import java.util.ArrayList;

public class PhoneBookFile {
    private static PhoneBookFile phoneBookFile;

    private PhoneBookFile() {
    }
    //Singleton
    public static PhoneBookFile getInstance(){
        if(phoneBookFile == null){
            phoneBookFile = new PhoneBookFile();
        }
        return phoneBookFile;
    }

    public ArrayList<Phonebook> readFile() throws IOException, ClassNotFoundException {
        File file = new File("phoneBookList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<Phonebook> list = (ArrayList<Phonebook>)object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(ArrayList<Phonebook> students) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("phoneBookList.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
