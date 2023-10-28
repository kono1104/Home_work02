import java.util.List;

public interface GenealogyFileHandler {
    void writeToFile(String fileName, List<Person> people);

    List<Person> readFromFile(String fileName);
}
