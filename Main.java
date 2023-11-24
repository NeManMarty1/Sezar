import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int menu;

    do{
        menu = scanner.nextInt();
        scanner.nextLine();
        if(menu == 1){
            String filePath = scanner.nextLine();
            reader(filePath);
        }if(menu == 2){
            String filePath = scanner.nextLine();
            System.out.println("Введите строку которую вы хотите добавить");
            String writeText = scanner.nextLine();
            writelast(filePath , writeText);
            reader(filePath);
        }if(menu == 3){
            String filePath = scanner.nextLine();
            System.out.println("Введите текст на который вы хотите перезаписать файл");
            String writeText = scanner.nextLine();
            reWriteFile(filePath , writeText);
            reader(filePath);
        }if(menu == 4){

            String fileName = scanner.nextLine();
            System.out.println("Введите ключ: ");
            int key = scanner.nextInt();
            String fileContent = reader(fileName);
            String fileRewrite = sezar(fileContent, key);
            reWriteFile(fileName, fileRewrite);
            reader(fileName);
        }
    }while(menu != -1);




    }

    public static String reader(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File " + filePath + " not found");
        }
        return filePath;
    }
    public static void writelast(String filePath , String writeText){


        try {
            Files.write(Paths.get(filePath), writeText.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println("Вы не смогли добавить строку");
        }
    }

    public static void reWriteFile(String filePath , String text){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Ты смог!!!");
        } catch (IOException e) {
            System.out.println("Вы не смогли это сделать");

        }
    }

    private static String sezar(String filePath, int key) {
        char[] suggestion = new char[filePath.length()];
        for (int i = 0; i < filePath.length(); i++) {
            suggestion[i] = (char) ((int) (filePath.charAt(i)) + key);
        }
        return String.valueOf(suggestion);
    }

}