/**
 * Created by Peerachai Banyongrakkul Section 1 5988070
 * 15/11/2017
 * BSTreeArray.java
 * @author USER 
 */
public class BSTreeArray 
{
    
    int[] T;
    int size;
    int root;
    
    
    // Constructor
    public BSTreeArray(int s, int root)
    {
        T = new int[s];
        this.size = s; 
        this.T[0] = root;
        this.root = T[0];
        System.out.println("Root is " + root);
        // initialize data in array to null with -1
        for(int i = 1 ; i<s ; i++)
        {
            T[i] = -1;
        }
    }
    
    
    /**
     * Insertion method by following the rule of binary search tree.
     * Rule: left subtree <= parent < right subtree
     * @param key 
     */
    public void insert(int key)
    {
        if(root == -1)
        {
            root = key;
        }
        else
        {
            int parentPos = 0;
            int childPos;
            int parent;
            while(true)
            {
                parent = T[parentPos];
                if(key <= parent)
                {
                    childPos = (parentPos*2)+1;
                    if(T[childPos] == -1)
                    {
                        System.out.println("Insert " + key + " at index " + childPos);
                        T[childPos] = key;
                        break;
                    }
                }
                else
                {
                    childPos = (parentPos*2)+2;
                    if(T[childPos] == -1)
                    {
                        System.out.println("Insert " + key + " at index " + childPos);
                        T[childPos] = key;
                        break;
                    }
                }
                parentPos = childPos;
            }
        }
    }
    
    
    /**
     * Method for Searching data and finding its depth including duplicate data.
     * eg. BST.searchAndFindDepth(5)
     * Output: 5 is found at index 3 and 7 and 15 and their average depth is 3
     * @param key
     * @return index
     */
    public int searchAndFindDepth(int key)
    {
        boolean check = true;
        int count = 1;
        int countDep = 0;
        int sumDep = 0;
        int avgDep;
        int parent;
        int childPos = 0;
        int parentPos = 0;
        int dup[] = new int[100];
        if(root == -1)
        {
            System.out.println("Root is null");
            return -1;
        }
        else
        {
            if(root == key)
            {
                System.out.println(key + " is at index " + 0 + " and its depth is " + countDep);
                return 0;
            }
            else
            {
                while(childPos <= T.length)
                {   
                    parent = T[parentPos];
                    if(key < parent)
                    {
                        childPos = (parentPos*2)+1;
                        check = false;
                        countDep++;
                    }
                    else if(key > parent)
                    {
                        childPos = (parentPos*2)+2;
                        check = false;
                        countDep++;
                    }
                    else
                    {
                        if(T[parentPos] != T[(parentPos*2)+1])
                        {
                            System.out.println(key + " is found at index " + childPos + " and its depth is " + countDep);
                            check = true;
                            break;
                        }
                        else
                        {
                            dup[0] = parentPos;
                            while(true)
                            {
                                sumDep += countDep;
                                parentPos = childPos;
                                childPos = (parentPos*2)+1;
                                if(T[parentPos] == T[childPos])
                                {
                                    dup[count] = childPos;
                                    countDep++;
                                    count++;
                                }
                                else
                                {
                                    break;
                                }
                            }
                            avgDep = sumDep/count;
                            System.out.print(key + " is found at index ");
                            for(int i = 0 ; i< count ; i++)
                            {
                                if(count-i == 1)
                                {
                                    System.out.print(dup[i] + " and their average depth is " + avgDep);
                                }
                                else
                                {
                                    System.out.print(dup[i] + " and ");
                                }
                            }
                        }
                        check = true;
                        break;
                    }
                    parentPos = childPos;
                }
            }
        }
        if(check == true)
        {
            return childPos;
        }
        else
        {
            System.out.println("Not Found");
            return -1;
        }
    }
    
    
    /**
     * Method for printing Binary Search Tree Array.
     */
    public void print()
    {
        System.out.println("BSTree Array: ");
        for(int i = 0 ;i<size-1;i++)
        {
            System.out.print(T[i]+" ");
        }
    }
    
}
