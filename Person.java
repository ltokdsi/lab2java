public class Person {
    private Name name;
    private int height;
    private Person father;

    // 2.2 Человек с именем
    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    // 2.3 Человек с родителем
    public Person(Name name, int height, Person father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        String s = name.getSurname();
        String f = name.getFirstName();
        String p = name.getPatronymic();

        if (father != null) {
            if ((s == null || s.trim().isEmpty()) && father.getName().getSurname() != null) {
                s = father.getName().getSurname();
            }
            if ((p == null || p.trim().isEmpty()) && father.getName().getFirstName() != null) {
                p = father.getName().getFirstName() + "ович";
            }
        }

        Name effectiveName = new Name(s, f, p);
        return effectiveName.toString() + ", рост: " + height;
        }
    }
