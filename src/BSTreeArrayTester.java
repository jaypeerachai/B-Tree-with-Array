/**
 * Created by Peerachai Banyongrakkul Section 1 5988070
 * 15/11/2017
 * BSTreeArrayTester.java
 * @author USER
 */
public class BSTreeArrayTester 
{
    
    public static void main(String[] args) 
    {
        
        //Create Binary search tree with initial root and size.
        BSTreeArray BST = new BSTreeArray(100,50);
        //Inserting data Tester
        System.out.println("Inserting data tester: ");
        BST.insert(100);
        BST.insert(10);
        BST.insert(20);
        BST.insert(40);
        BST.insert(90);
        BST.insert(60);
        BST.insert(110);
        BST.insert(5);
        BST.insert(5);
        BST.insert(5);
        System.out.println();

        // Print BSTree Array.
        BST.print();
        System.out.println();
        System.out.println();

        // Seacrhing data and finding its depth tester .
        System.out.println("Searching data tester: ");
        // In case of found data.
        System.out.print("Case 1: ");
        BST.searchAndFindDepth(90);
        // In case of Not found.
        System.out.print("Case 2: ");
        BST.searchAndFindDepth(1234);
        // In case of searching duplicate data.
        System.out.print("Case 3: ");
        BST.searchAndFindDepth(5);
        System.out.println();

    }
    
}
