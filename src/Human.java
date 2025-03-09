public class Human {
    private String name;
    private int age;
    
    public void writeMyName(){
        System.out.println(this.name);
    }

    public String getName(){
        return this.name;    
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}   
