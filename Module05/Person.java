
class Person {
    protected String name;

    public Person(String theName) {
        this.name = theName;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "PersonSolution{" + "name='" + this.name + '\'' + '}';
    }
}
