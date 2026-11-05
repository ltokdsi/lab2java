// 1.3 Имена
public class Name {
    private String surname;
    private String firstName;
    private String patronymic;

    public Name(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String getSurname() { return surname; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (surname != null && !surname.trim().isEmpty()) res.append(surname).append(" ");
        if (firstName != null && !firstName.trim().isEmpty()) res.append(firstName).append(" ");
        if (patronymic != null && !patronymic.trim().isEmpty()) res.append(patronymic);
        return res.toString().trim();
    }
}