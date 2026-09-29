package dev.tukaram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassGenerator {

    public static void main(String[] args)  {

        try {
			BufferedReader br =
			        new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter class and file name: ");
			String className = br.readLine();

			String fileName = className + ".java";

			File file = new File(fileName);

			if (file.createNewFile()) {
			    System.out.println("Java file created successfully.");
			} else {
			    System.out.println("File already exists.");
			    return;
			}

			System.out.print("Enter package name: ");
			String pack = br.readLine();

			System.out.print("Enter constructor access specifier (public/private/protected): ");
			String accessSpecifier = br.readLine();

			BufferedWriter writer =
			        new BufferedWriter(new FileWriter(file));

			writer.write("package " + pack + ";");
			writer.newLine();
			writer.newLine();

			writer.write("public class " + className + " {");
			writer.newLine();
			writer.newLine();

			writer.write("\t" + accessSpecifier + " " + className + "() {");
			writer.newLine();
			writer.write("\t}");
			writer.newLine();

			writer.write("}");

			writer.close();

			System.out.println("Java class generated successfully.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}