public class Human {
    private String name;
    private int age;
    
    /* Ez a metodus kiirja az ember nevet  */
    public void writeMyName(){
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}   
