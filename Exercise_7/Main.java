package com.company;

import java.lang.reflect.Field;

public class Main {

//  a)  Through reflection we can invoke methods at runtime irrespective of the access specifier used with them.
//  b)
    public static void main(String[] args){

        Person p = new Person("Marishka");

        String myName = get_name(p);

        System.out.println(myName);
    }

    static String get_name(Person p) {
        try {

            String m_name = null;
            Field privateStringField = null;
            privateStringField = Person.class.
                    getDeclaredField("m_name");
            privateStringField.setAccessible(true);
            m_name = (String) privateStringField.get(p);

            return m_name;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
