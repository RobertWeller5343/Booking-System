package bookingsystem3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Bookingsystem3 {

    public static String folderDirectory3;
    public static String folderDirectory2;
    public static String folderDirectory;
    public static int room = 6;
    public static int overide = 0;
    public static String day = "day";
    public static String time = "not yet";
    public static String email = "owo";
    public static int foodoverlap = 0;
    public static int emails = 0;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("welcome");
            System.out.println("1- Book a room ");
            System.out.println("2- supply booking");
            System.out.println("3- supply dilivery schedule");
            System.out.println("4- food booking");
            System.out.println("5- see bookings");
            System.out.println("6-exit");
            int userchoice = input.nextInt();
            switch (userchoice) {
                case 1:
                    booking();
                    break;
                case 2:
                    supply();

                    break;
                case 3:
                    System.out.println("getting schedule");
                    getDir2();
                    supplyShed();
                    break;
                case 4:
                    food();

                    break;
                case 6:

                    System.exit(0);
                case 5:

                    getDir();
                    roomShed();
                    break;

            }
        }
    }

    public static void retrieve2() {
        Scanner input = new Scanner(System.in);
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory3));
            while ((inputLine = read.readLine()) != null) {
                String[] parts = inputLine.split("--");
                //System.out.println(parts[1]);
                if (parts[1].equals(day)) {
                    System.out.println("day match found checking if times overlap");
                    if (parts[2].equalsIgnoreCase(time)) {
                        System.out.println("match found");
                        foodoverlap = 1;
                    } else {
                        System.out.println("no match found");

                    }

                } else {

                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }

    public static void getDir3() {
        folderDirectory3 = System.getProperty("user.dir") + "\\food.txt";
        return;
    }

    public static void food() {
        String sandwichPlatter = "no";
        int sandwichpeople = 0;
        String pastery = "no";
        int pasteryPeople = 0;
        String water = "no";
        int waterPeople = 0;
        String coke = "no";
        int cokePeople = 0;
        String tea = "no";
        int teaPeople = 0;
        String cofee = "no";
        int cofeePeople = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("what day");
        day = input.nextLine();
        System.out.println("what time");
        time = input.nextLine();
        System.out.println("what room");
        int suproom = input.nextInt();
        System.out.println("would you like sandwiches? 1 yes 0 no");
        int order1 = input.nextInt();
        if (order1 == 1) {
            sandwichPlatter = "yes";
            System.out.println("how many people would like it");
            sandwichpeople = input.nextInt();
        }
        System.out.println("would you like pastery? 1 yes 0 no");
        int order2 = input.nextInt();
        if (order2 == 1) {
            pastery = "yes";
            System.out.println("how many people would like it");
            pasteryPeople = input.nextInt();
        }
        System.out.println("would you like water? 1 yes 0 no");
        int order3 = input.nextInt();
        if (order3 == 1) {
            water = "yes";
            System.out.println("how many people would like it");
            waterPeople = input.nextInt();
        }
        System.out.println("would you like coke? 1 yes 0 no");
        int order4 = input.nextInt();
        if (order4 == 1) {
            coke = "yes";
            System.out.println("how many people would like it");
            cokePeople = input.nextInt();
        }
        System.out.println("would you like tea? 1 yes 0 no");
        int order5 = input.nextInt();
        if (order5 == 1) {
            tea = "yes";
            System.out.println("how many people would like it");
            teaPeople = input.nextInt();
        }
        System.out.println("would you like cofee? 1 yes 0 no");
        int order6 = input.nextInt();
        if (order6 == 1) {
            cofee = "yes";
            System.out.println("how many people would like it");
            cofeePeople = input.nextInt();
        }
        getDir3();
        retrieve2();
        if (foodoverlap == 0) {
            try {
                FileWriter writeToFile = new FileWriter(folderDirectory3, true);
                PrintWriter printToFile = new PrintWriter(writeToFile);
                printToFile.println("");
                printToFile.print("--");
                printToFile.print(day);
                printToFile.print("--");
                printToFile.print(time);
                printToFile.print("--");
                printToFile.print(suproom);
                printToFile.print("--");
                printToFile.print("sandwichPlatter " + sandwichPlatter + "for " + sandwichpeople + "people");
                printToFile.print("--");
                printToFile.print("pastery " + pastery + " " + pasteryPeople);
                printToFile.print("--");
                printToFile.print("water " + water + " " + waterPeople);
                printToFile.print("--");
                printToFile.print("coke " + coke + " " + cokePeople);
                printToFile.print("--");
                printToFile.print("tea " + tea + " " + teaPeople);
                printToFile.print("--");
                printToFile.print("cofee " + cofee + " " + cofeePeople);
                printToFile.close();
                writeToFile.close();
            } catch (Exception e) {
                System.out.println("error " + e);
            }

            System.out.println("order succsessful");
            System.exit(0);
        } else {
            System.out.println("time already in use use another time");

        }
        System.exit(0);
    }

    public static void roomShed() {
        Scanner input = new Scanner(System.in);
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((inputLine = read.readLine()) != null) {
                System.out.println(inputLine);

            }
            read.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }

    public static void supplyShed() {
        Scanner input = new Scanner(System.in);
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory2));
            while ((inputLine = read.readLine()) != null) {
                System.out.println(inputLine);

            }
            read.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }

    public static void supply() {
        String projectorfinal = "no";
        String laptopfinal = "no";
        String printerfinal = "no";
        Scanner input = new Scanner(System.in);
        System.out.println("what day");
        String supDay = input.nextLine();
        System.out.println("what time");
        String suptime = input.nextLine();
        System.out.println("what room");
        int suproom = input.nextInt();
        System.out.println("would you like a projector? 1 yes 0 no");
        int projector = input.nextInt();
        System.out.println("would you like a printer? 1 yes 0 no");
        int printer = input.nextInt();
        System.out.println("would you like a laptop? 1 yes 0 no");
        int laptop = input.nextInt();
        if (projector == 1) {
            projectorfinal = "yes";
        }
        if (printer == 1) {
            printerfinal = "yes";
        }
        if (laptop == 1) {
            laptopfinal = "yes";
        }
        getDir2();
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory2, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println("");
            printToFile.print("--");
            printToFile.print(supDay);
            printToFile.print("--");
            printToFile.print(suproom);
            printToFile.print("--");
            printToFile.print(suptime);
            printToFile.print("--");
            printToFile.print("projector " + projectorfinal);
            printToFile.print("--");
            printToFile.print("printer " + printerfinal);
            printToFile.print("--");
            printToFile.print("laptop " + laptopfinal);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        System.out.println("order succsesful");
        System.exit(0);
    }

    public static void getDir2() {
        folderDirectory2 = System.getProperty("user.dir") + "\\extras.txt";
    }

    public static void booking() {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your email adress before the @ (must end with @outlook.com, @hotmail.co.uk or @gmail.com");
        String emailCheck = input.nextLine();
         String[] parts = emailCheck.split("@");
        if (parts[1].equalsIgnoreCase("outlook.com")) {
            System.out.println("email valid");
            email = emailCheck;

        } else {
            emails++;
        }
        if (parts[1].equalsIgnoreCase("gmail.com")) {
            System.out.println("email valid");
            email = emailCheck;

        } else {
            emails++;
        }
        if (parts[1].equalsIgnoreCase("hotmail.co.uk")) {
            System.out.println("email valid");
            email = emailCheck;
        } else {
            emails++;
        }
        if (emails == 3) {
            System.out.println("not a valid email");
            emails = 0;
            return;
        }
        System.out.println("what timeslot do you want morning (limited to 1 per day), afternoon or all day");
        time = input.nextLine();
        System.out.println("what day do you want 1- monday 2- tuesday 3- wednesday 4- thursday 5- fiday");
        int userchoice = input.nextInt();
        switch (userchoice) {
            case 1:

                day = "Monday";
                System.out.println("what room do you want Room 1 can only fit 2 people in it, "
                        + "room 2 = 4 people, room 3 = 8 people, "
                        + "room 4 = 15 people (Room 4 is the only room with disabled access for wheelchairs), "
                        + "room 5 = 50 people.");
                int choice = input.nextInt();
                if (choice < 6) {
                    room = choice;
                } else {
                    System.out.println("room does not exist");
                    return;
                }
                break;

            case 2:

                day = "tuesday";
                System.out.println("what room do you want Room 1 can only fit 2 people in it, "
                        + "room 2 = 4 people, room 3 = 8 people, "
                        + "room 4 = 15 people (Room 4 is the only room with disabled access for wheelchairs), "
                        + "room 5 = 50 people.");
                choice = input.nextInt();
                if (choice < 6) {
                    room = choice;
                }
                break;
            case 3:
                day = "wednesday";
                System.out.println("what room do you want Room 1 can only fit 2 people in it, "
                        + "room 2 = 4 people, room 3 = 8 people, "
                        + "room 4 = 15 people (Room 4 is the only room with disabled access for wheelchairs), "
                        + "room 5 = 50 people.");
                choice = input.nextInt();
                if (choice < 6) {
                    room = choice;
                }
                break;
            case 4:
                day = "thursday";
                System.out.println("what room do you want Room 1 can only fit 2 people in it, "
                        + "room 2 = 4 people, room 3 = 8 people, "
                        + "room 4 = 15 people (Room 4 is the only room with disabled access for wheelchairs), "
                        + "room 5 = 50 people.");
                choice = input.nextInt();
                if (choice < 6) {
                    room = choice;
                }

                break;
            case 5:
                day = "friday";
                System.out.println("what room do you want Room 1 can only fit 2 people in it, "
                        + "room 2 = 4 people, room 3 = 8 people, "
                        + "room 4 = 15 people (Room 4 is the only room with disabled access for wheelchairs), "
                        + "room 5 = 50 people.");
                choice = input.nextInt();
                if (choice < 6) {
                    room = choice;
                }
                break;

        }
        getDir();
        retrieve();
        if (overide == 0) {
            writeFile();
        } else {
            System.out.println("can not process booking");
            System.exit(0);
        }
    }

    public static void getDir() {
        folderDirectory = System.getProperty("user.dir") + "\\bookings.txt";
    }

    public static void writeFile() {
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println("");
            printToFile.print("--");
            printToFile.print(room);
            printToFile.print("--");
            printToFile.print(day);
            printToFile.print("--");
            printToFile.print(time);
            printToFile.print("--");
            printToFile.print(email);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        System.out.println("order succsesful");
        System.exit(0);
    }

    public static void retrieve() {
        int i = 0;
        Scanner input = new Scanner(System.in);
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((inputLine = read.readLine()) != null) {
                String[] parts = inputLine.split("--");
                //System.out.println(parts[1]);

                if (parts[2].equalsIgnoreCase(day)) {
                    System.out.println("day mach found checking for overlaps");
                    i = Integer.parseInt(parts[1]);
                    if (i == room && parts[3].equalsIgnoreCase(time)) {
                        System.out.println("error in timing");
                        overide = 1;
                    } else {

                    }
                    if (parts[2].equalsIgnoreCase(day)) {
                        System.out.println("day mach found checking that no more than 1 morning booking");
                        if (parts[3].equalsIgnoreCase("morning") && time.equalsIgnoreCase("morning")) {
                            System.out.println("only 1 room in the morning per day");
                            overide = 1;
                        } else {

                        }
                    }
                    if (parts[2].equalsIgnoreCase(day)) {
                        System.out.println("day mach found checking room has not been booked more than once");
                        i = Integer.parseInt(parts[1]);
                        if (i == room) {
                            System.out.println(parts[3]);
                            if (parts[3].equalsIgnoreCase("all day") || time.equalsIgnoreCase("all day")) {
                                System.out.println("error in time");
                                overide = 1;
                            } else {

                            }
                        } else {

                        }
                    } else {

                    }
                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
}
