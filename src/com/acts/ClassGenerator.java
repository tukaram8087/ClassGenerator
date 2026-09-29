package com.acts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClassGenerator {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter package name: ");
            String packageName = sc.nextLine();

            System.out.print("Enter class name: ");
            String className = sc.nextLine();

            System.out.print("Enter field name: ");
            String fieldName = sc.nextLine();

            System.out.print("Enter field data type (e.g., String, int, float): ");
            String fieldType = sc.nextLine();

            String fileName = className + ".java";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            writer.write("package " + packageName + ";");
            writer.newLine();
            writer.newLine();
            writer.write("public class " + className + " {");
            writer.newLine();
            writer.write("    private " + fieldType + " " + fieldName + ";");
            writer.newLine();
            writer.newLine();
            writer.write("    public " + className + "() {");
            writer.newLine();
            writer.write("    }");
            writer.newLine();
            writer.newLine();
            writer.write("    public " + className + "(" + fieldType + " " + fieldName + ") {");
            writer.newLine();
            writer.write("        this." + fieldName + " = " + fieldName + ";");
            writer.newLine();
            writer.write("    }");
            writer.newLine();
            writer.newLine();
            writer.write("    public " + fieldType + " get" + capitalize(fieldName) + "() {");
            writer.newLine();
            writer.write("        return " + fieldName + ";");
            writer.newLine();
            writer.write("    }");
            writer.newLine();
            writer.newLine();
            writer.write("    public void set" + capitalize(fieldName) + "(" + fieldType + " " + fieldName + ") {");
            writer.newLine();
            writer.write("        this." + fieldName + " = " + fieldName + ";");
            writer.newLine();
            writer.write("    }");
            writer.newLine();
            writer.write("}");

            writer.close();
            sc.close();
            System.out.println("Class file '" + fileName + "' generated successfully!");

        } catch (IOException e) {
            System.out.println("Error generating class: " + e.getMessage());
        }
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}