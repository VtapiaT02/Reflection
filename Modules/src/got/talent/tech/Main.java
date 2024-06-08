package got.talent.tech;

import got.talent.tech.address.Address;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("avenida", "zapopan", "jal", "1234", "MX");
        System.out.println("ID: " + Address.setId());
        System.out.println(address);
        try {
            // isInstance
            Class addressClass = Class.forName("gto.talent.address.Address");
            System.out.println("Name: " + addressClass.getName());
            System.out.println(addressClass.isInstance(new Address("avenida", "zapopan", "jal", "1234", "US")));

            // Method calls:
            Method methods[] = addressClass.getMethods();
            Method setCity = null;
            for (int i = 0; i < methods.length; i++) {
                //System.out.println("Method " + 1 + ": " + methods[i].getName());

                if(methods[i].getName().equals("setCity")) {
                    setCity = methods[i];
                }

                Parameter parameters[] = methods[i].getParameters();
                for (Parameter parameter : parameters) {
                    //System.out.println("Parameters: " + parameter.getName());
                }
            }

            String arg0 = "Leon";
            System.out.println("Method setCity: " + setCity.getName());
            setCity.invoke(address, arg0);
            System.out.println("City: " + address.getCity());

            // fields
            Field fields[] = addressClass.getDeclaredFields();
            System.out.println("length " + fields.length);
            for (Field field : fields) {
                System.out.println("Field " + field.getName());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}