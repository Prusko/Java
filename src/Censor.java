public class Censor {
    public static void main(String[] args) throws Exception {
        String eredmeny = censor("A kutya nagyon aranyos kutya", "kutya", "cica");
        System.out.println(eredmeny);
    }
    
    static String censor(String text, String toChange, String newWord){
        if (text.contains(toChange)){
            text = text.replaceAll(toChange, newWord);
        }
        return text;
    }
}