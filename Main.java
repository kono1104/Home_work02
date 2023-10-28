import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenealogyFileHandler fileHandler = new FileGenealogyHandler();
        GenealogyTree tree = new GenealogyTree(fileHandler);

        // Создаем персоны и устанавливаем родственные связи
        Person person1 = new Person("Иван", 1950, "М", "Инженер", "Москва");
        Person person2 = new Person("Мария", 1955, "Ж", "Учитель", "Санкт-Петербург");
        Person person3 = new Person("Алексей", 1980, "М", "Врач", "Москва");
        Person person4 = new Person("Елена", 1985, "Ж", "Художник", "Санкт-Петербург");

        person1.addChild(person3); // Алексей - сын Ивана
        person1.addChild(person4); // Елена - дочь Ивана
        person2.addChild(person3); // Алексей - сын Марии
        person2.addChild(person4); // Елена - дочь Марии

        // Добавляем персоны в генеалогическое древо
        tree.addPerson(person1);
        tree.addPerson(person2);
        tree.addPerson(person3);
        tree.addPerson(person4);

        // Выводим родственные связи для каждой персоны
        printRelationships(person1);
        printRelationships(person2);
        printRelationships(person3);
        printRelationships(person4);
    }

    // Метод для вывода родственных связей для персоны
    private static void printRelationships(Person person) {
        System.out.println("Родственные связи для " + person.getName() + ":");
        if (person.getMother() != null) {
            System.out.println("Мать: " + person.getMother().getName());
        } else {
            System.out.println("Мать: Неизвестно");
        }

        if (person.getFather() != null) {
            System.out.println("Отец: " + person.getFather().getName());
        } else {
            System.out.println("Отец: Неизвестно");
        }

        List<Person> children = person.getChildren();
        if (!children.isEmpty()) {
            System.out.println("Дети:");
            for (Person child : children) {
                System.out.println("- " + child.getName());
            }
        } else {
            System.out.println("Дети: Нет");
        }

        System.out.println("------------------------");
    }
}