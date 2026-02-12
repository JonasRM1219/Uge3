import java.util.Scanner;

public class Uge3 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Opgave 1: BANK
        System.out.println("OPGAVE 1: BANK\n");
        deposit100(); deposit100(); withdraw50(); printBalance();

        System.out.println("\nEkstra:");
        System.out.print("Indsæt: "); deposit(scan.nextDouble());
        System.out.print("Hæv: "); withdraw(scan.nextDouble());
        printBalance();

        // Opgave 2: POINT
        System.out.println("\n\nOPGAVE 2: POINT\n");
        addAssignmentPoints(25); addExamPoints(40); addProjectPoints(30);
        printTotalOriginal();

        System.out.println("\nEkstra:");
        addPoints(25, "assignment"); addPoints(40, "exam"); addPoints(30, "project");
        printTotal();

        // Opgave 3: PRIS
        System.out.println("\n\nOPGAVE 3: PRIS\n");
        double slutPris = calculateFinalPrice(500, 20);
        System.out.println("Slutpris: " + slutPris + " kr");

        System.out.println("\nEkstra:");
        System.out.print("Kundetype (standard/guld/platin): ");
        double pris = calculatePriceWithCustomerType(500, scan.next());
        System.out.println("Pris med rabat: " + pris + " kr");

        // Opgave 4: STATISTIK
        System.out.println("\n\nOPGAVE 4\n");
        int[] tal = {45, 67, 23, 89, 34, 56, 78};

        System.out.println("Gennemsnit: " + calculateAverage(tal));
        System.out.println("Max: " + findMax(tal));
        System.out.println("Min: " + findMin(tal));
        System.out.println("Tal over gennemsnit: " + countAboveAverage(tal));

        System.out.println("\nEkstra:");
        printAllStats(tal);


        System.out.println("\n\nOPGAVE 5: Debug\n");
        debugAssignment();
    }

    // BANK
    static double balance = 0;
    static String accountName = "Jonas";

    static void deposit100() { balance += 100; System.out.println("+100 kr"); }
    static void withdraw50() {
        if(balance >= 50) { balance -= 50; System.out.println("-50 kr"); }
        else System.out.println("Ikke nok penge!");
    }
    static void deposit(double x) { balance += x; System.out.println("+" + x + " kr"); }
    static void withdraw(double x) {
        if(balance >= x) { balance -= x; System.out.println("-" + x + " kr"); }
        else System.out.println("Ikke nok penge!");
    }
    static void printBalance() { System.out.println("Saldo: " + balance + " kr"); }

    // POINT
    static int a = 0, e = 0, p = 0;

    static void addAssignmentPoints(int x) { a += x; System.out.println("Assignment: +" + x); }
    static void addExamPoints(int x) { e += x; System.out.println("Exam: +" + x); }
    static void addProjectPoints(int x) { p += x; System.out.println("Project: +" + x); }
    static void printTotalOriginal() { System.out.println("Total: " + (a+e+p)); }

    static void addPoints(int x, String type) {
        if(type.equals("assignment")) { a += x; System.out.println("Assignment: +" + x); }
        else if(type.equals("exam")) { e += x; System.out.println("Exam: +" + x); }
        else if(type.equals("project")) { p += x; System.out.println("Project: +" + x); }
    }

    static int getTotal() { return a + e + p; }

    static void printTotal() {
        int total = getTotal();
        System.out.println("Total: " + total);
        if(total <= 50) System.out.println("Karakter: -3");
        else if(total <= 70) System.out.println("Karakter: 00");
        else if(total <= 85) System.out.println("Karakter: 7");
        else System.out.println("Karakter: 12");
    }

    // PRIS
    static double applyDiscount(double pris, double rabat) { return pris * (1 - rabat/100); }
    static double addTax(double pris) { return pris * 1.25; }
    static double calculateFinalPrice(double pris, double rabat) {
        return addTax(applyDiscount(pris, rabat));
    }

    static double calculatePriceWithCustomerType(double pris, String type) {
        double rabat = 0;
        switch(type) {
            case "guld": rabat = 15; break;
            case "platin": rabat = 25; break;
            default: rabat = 0;
        }
        return calculateFinalPrice(pris, rabat);
    }

    // STATISTIK
    static double calculateAverage(int[] numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return (double)sum / numbers.length;
    }

    static int findMax(int[] numbers) {
        int max = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    static int findMin(int[] numbers) {
        int min = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    static int countAboveAverage(int[] numbers) {
        double avg = calculateAverage(numbers);
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] > avg) {
                count++;
            }
        }
        return count;
    }

    static void printAllStats(int[] numbers) {
        System.out.println("STATISTIK OVERSIGT");
        System.out.print("Tal: ");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("Gennemsnit: " + calculateAverage(numbers));
        System.out.println("Største tal: " + findMax(numbers));
        System.out.println("Mindste tal: " + findMin(numbers));
        System.out.println("Antal over gennemsnit: " + countAboveAverage(numbers));

    }

    //  Opgave 5 Debug

    static void debugAssignment() {
        int a = 7, b = 42;

        // Fix 1: Gem returværdien fra minimum() i en variabel
        int smaller = minimum(a, b);

        // Fix 2: if skal have () omkring betingelsen
        if (smaller == a) {
            System.out.println("a (7) is the smallest!");
            // Fix 3: else kan ikke have en betingelse
        } else {
            System.out.println(b + " is the smallest!");
        }
    }

    // Fix 4: skal have returtype int og være static
    static int minimum(int a, int b) {
        // Fix 5: Deklarér variablen udenfor if-else
        int smaller;

        if (a < b) {
            // Fix 6: Tildel værdi, deklarer ikke en ny variabel
            smaller = a;
        } else {
            // Fix 7: Samme her - tildel værdi
            smaller = b;
        }

        // Fix 8: Returnér variablen
        return smaller;
    }
}