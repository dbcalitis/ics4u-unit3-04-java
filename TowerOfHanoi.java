/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Daria Bernice Calitis
* @version 1.0
* @since   2022-11-16
*/

import java.util.Scanner;

/**
 * The TowerOfHanoi Class.
 */
final class TowerOfHanoi {
    /**
     * TowerOfHanoi() Instantiation Prevention.
     *
     * <p>
     * Prevent instantiation.
     * Optional: throw an exception e.g. AssertionError
     * if this ever *is* called.
     * </p>
     *
     * @throws IllegalStateException - exception.
     */
    private TowerOfHanoi() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The hanoi function.
     *
     * <p>
     * Solves the Tower of Hanoi in the least amount of steps.
     * </p>
     *
     * @param nOfDisks - the number of disks.
     * @param startPeg - the starting peg.
     * @param endPeg - the ending peg.
     */
    static void hanoi(final int nOfDisks, final int startPeg,
                             final int endPeg) {
        // This function calculates where the disks should be placed in
        final int pegNumber = 6;
        final String toPeg = " to peg ";
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg "
                + String.valueOf(startPeg) + toPeg
                + String.valueOf(endPeg));
        } else {
            hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
            System.out.println("Move disk " + String.valueOf(nOfDisks)
                + " from the peg " + String.valueOf(startPeg) + toPeg
                + String.valueOf(endPeg));
            hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }

    /**
     * Main.
     *
     * <p>
     * No params.
     * </p>
     *
     * @param args - No params.
     */
    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // input
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            final int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // process
                hanoi(nOfDisks, startPeg, endPeg);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (java.util.InputMismatchException ex) {
            System.err.print("\nThis is not an integer");
        }
    }
}
