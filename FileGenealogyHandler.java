import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileGenealogyHandler implements GenealogyFileHandler {
    @Override
    public void writeToFile(String fileName, List<Person> people) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(people);
            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> readFromFile(String fileName) {
        List<Person> people = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            people = (List<Person>) ois.readObject();
            System.out.println("Данные успешно загружены из файла: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return people;
    }
}