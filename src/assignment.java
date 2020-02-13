
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nicolaswong
 */
public class assignment {

    static ListStack H1 = new ListStack();
    static ListStack H2 = new ListStack();
    static ListStack H3 = new ListStack();
    static ListStack[] H = new ListStack[]{H1, H2, H3};
    static int cargo;
    static Scanner sc = new Scanner(System.in);
    static ArrayList store = new ArrayList();
    static ArrayList output = new ArrayList();
    static int outputIndex = 1;

    public static void main(String[] args) {
        //break loop until the user input 0        
        while (true) {
            //catch non-integer value and same input
            try {
                System.out.print("Enter cargo number (enter <= 0 exit) : ");
                cargo = Integer.parseInt(sc.nextLine());

                if (cargo <= 0) { // 0 or <0 go to progress
                    break;
                }
                if (store.contains(cargo)) { // if input has same number throw exception
                    throw new DuplicatonException();
                }
                store.add(cargo);

            } catch (NumberFormatException ex) {
                System.out.println("Please input integer!");
                continue;
            } catch (DuplicatonException eex) {
                System.out.println("Please input other number!");
                continue;
            }
        }
        //print store value and run progress function
        System.out.println("\n\nNumber of Tracks = 3");
        System.out.println("Number of Cargos = " + store.size());
        System.out.print("Input order of cars (from left to right) is : ");
        for (int i = 0; i < store.size(); i++) {
            System.out.print(store.get(i) + " ");
        }
        System.out.println("\n");
        progress();
    }

    public static void progress() {
        int cars = 0;
        //get each value from list
        for (int i = 0; i < 9; i++) {
            try {
                cars = (int) store.remove(0);
                if (!arrange(cars)) {
                    System.out.println("Fail to rearrange the cars!");
                    break;
                }
            } catch (Exception ex) {
            }
            rearrange();
//            System.out.println("in " + store.toString());
//            System.out.println("H1 " + H1.toString());
//            System.out.println("H2 " + H2.toString());
//            System.out.println("H3 " + H3.toString());
//            System.out.print("out " + Arrays.toString(output.toArray()));
//            System.out.println();
        }
    }

    public static void rearrange() {
        //handle HBT output by sequence order    
        int i = 0;
        if (!H1.isEmpty() || !H2.isEmpty() || !H3.isEmpty()) {
            while (i < 3) {
                for (i = 0; i < H.length; i++) {
                    if (!H[i].isEmpty()) {
                        if (H[i].top().equals(outputIndex)) {
                            System.out.println("Move car " + H[i].top()
                                    + " from holding track " + (i + 1) + " to output track");
                            output.add(H[i].pop());
                            outputIndex++;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static boolean arrange(int cars) {
        //first check cargo number is equal outputIndex,if not go to check input track
        //empty and small than HBT last value will be pushed to HTB
        boolean isFail = true;
        if (cars == outputIndex) {
            System.out.println("Move car " + cars
                    + " from input track to output track");
            output.add(cars);
            outputIndex++;
        } else {
            for (int i = 0; i < H.length; i++) {
                if (H[i].isEmpty() || cars < (int) H[i].top()) {
                    System.out.println("Move car " + cars
                            + " from input track to holding track " + (i + 1));
                    H[i].push(cars);
                    break;
                }
            }
        }
        if ((int) H1.top() < cars && (int) H2.top() < cars && (int) H3.top() < cars) {
            isFail = false;
        }
        return isFail;
    }
}
