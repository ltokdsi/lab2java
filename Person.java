public class Person {
    private Name name;
    private int height;
    private Person father;

    // Конструктор для создания человека с именем и ростом
    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    // Конструктор для создания человека с именем, ростом и отцом
    public Person(Name name, int height, Person father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    public Name getName() {
        return name;
    }

    public String getEffectiveSurname() {
        String s = name.getSurname();
        if ((s == null || s.trim().isEmpty()) && father != null) {
            s = father.getEffectiveSurname();
        }
        return s;
    }

    public String getEffectiveFirstName() {
        return name.getFirstName();
    }

    public String getEffectivePatronymic() {
        String p = name.getPatronymic();
        if ((p == null || p.trim().isEmpty()) && father != null) {
            String fatherName = father.getEffectiveFirstName();
            if (fatherName != null && !fatherName.trim().isEmpty()) {
                p = fatherName + "ович";
            }
        }
        return p;
    }

    @Override
    public String toString() {
        String s = getEffectiveSurname();
        String f = getEffectiveFirstName();
        String p = getEffectivePatronymic();

        Name effectiveName = new Name(s, f, p);
        return effectiveName.toString() + ", рост: " + height;
    }
}
