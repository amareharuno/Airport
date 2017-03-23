package netcraker.bsuir.eremeeva.airport.entities.Employees;

public abstract class AbstractEmployee {
    private String firstName;
    private String lastName;
    private static int incrementa = 0;
    private int id;


    protected AbstractEmployee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = incrementa++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEmployee that = (AbstractEmployee) o;

        if (id != that.id) return false;
        if (!firstName.equals(that.firstName)) return false;
        return lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return  "Employee" + id + ". " +
                firstName + ' ' +
                lastName + " - " +
                this.getClass();
    }
}
