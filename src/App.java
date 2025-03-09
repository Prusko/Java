public class App {
    public static void main(){
        Human ember = new Human();

        System.out.println(ember.getName() != null ? "Van nev: "+ ember.getName() : "Nincs nev");
        System.out.print("Adja meg nevet: ");
        ember.setName(System.console().readLine());
        System.out.print("Adja meg eletkorat: ");
        ember.setAge(Integer.parseInt(System.console().readLine()));
        System.out.println(ember.getName() + " - " + ember.getAge());

        //itt a valtozas
        
        String[] nevek = {"Atko", "David", "Prusko", "Dusty"};
        System.out.println(String.join("\t", nevek));

        /* if (ember.getName() == null){
            System.out.println("Nincs nev");
        } else {
            System.out.println("Van nev: " + ember.getName());
        } */
    }
}
