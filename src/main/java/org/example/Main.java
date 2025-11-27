package org.example;

import org.example.book.*;
import org.example.strategy.*;
import org.example.*;


public class Main{ // <--- Metoda main trebuie incadrata intr-o clasa

    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1"); // [cite: 53]
        Paragraph p1 = new Paragraph("Paragraph 1"); // [cite: 54]
        cap1.add(p1); // [cite: 55]
        Paragraph p2 = new Paragraph("Paragraph 2"); // [cite: 56]
        cap1.add(p2); // [cite: 57]
        Paragraph p3 = new Paragraph("Paragraph 3"); // [cite: 58]
        cap1.add(p3); // [cite: 59]
        Paragraph p4 = new Paragraph("Paragraph 4"); // [cite: 60]
        cap1.add(p4); // [cite: 61]

        System.out.println("Printing without Alignment"); // [cite: 62]
        System.out.println(); // [cite: 63]
        cap1.print(); // [cite: 64]

        // NOTA: Am scos p1.setAlignStrategy(new AlignCenter()) pentru a oglindi codul tau.
        p2.setAlignStrategy(new AlignRight()); //
        p3.setAlignStrategy(new AlignLeft()); // [cite: 66]

        System.out.println(); // [cite: 68]
        System.out.println("Printing with Alignment"); // [cite: 69]
        System.out.println(); // [cite: 70]
        cap1.print(); // [cite: 71]
    }
}