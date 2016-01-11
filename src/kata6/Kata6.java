package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata6 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        System.out.println("Inicio");
        String name = "C:\\Users\\Javi\\Documents\\NetBeansProjects\\Kata4\\DATA\\emails.txt";
        ArrayList<Person> arrayMail = MailListReader.read(name);
ArrayList<Person1> person = PersonLoader.read();

        HistogramBuilder<Person> builder = new HistogramBuilder<>(arrayMail);
        HistogramBuilder<Person1> builder1 = new HistogramBuilder<>(person);
        
        Histogram<String> domains = builder.build(new Attribute<Person,String>(){
            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {
            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {
            @Override
            public String get(Person1 item) {
               return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Float> pesos = builder1.build(new Attribute<Person1, Float>() {
            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        Histogram<Character> genero = builder1.build(new Attribute<Person1, Character>() {
            @Override
            public Character get(Person1 item) {
                return item.getGenero().charAt(0);
            }
        });
        
        new HistogramDisplay(domains, "DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
        new HistogramDisplay(domains1, "DOMINIOS").execute();
        new HistogramDisplay(pesos, "PESOS").execute();
        new HistogramDisplay(genero, "GENERO").execute();
        System.out.println("Fin");
    }
    
}
