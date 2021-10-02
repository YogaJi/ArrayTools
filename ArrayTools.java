//Name:Yujia JI
//Student Number:A00246407
//Program Description: ArrayTools.java is a small command-line application that provides useful tools:
// Encrypt is a Caesar cipher method that accepts a String, a shift value, and returns with a new String.
// arrayAvg is a method that accepts an array and produces the average of all values.
// The reverse is a method that reverses an array that the user types in.
// arrayContains is based on arrayAvg's array that it determines if the array contains the input value.

import java.util.Scanner;
import java.util.Arrays;
public class ArrayTools{
    public static void main(String[] args){
        //Encrypt
        char str[]={'a','b','c','d','e','f','g','h','i',
        'j','k','l','m','n','o','p','q','r','s','t','u','v',
        'w','x','y','z'}; //encrypt code

        Scanner keyb = new Scanner(System.in);
        System.out.print("Encrypt: Please enter a string to encrypt.");
        String input = keyb.nextLine();
        char[] c = input.toCharArray(); //store input

        System.out.print("Please enter a value (from 1) to encrypt.");
        int value = keyb.nextInt();

        char[] encrypt = Encrypt(value,c,str); //method output
        System.out.print("Your encrypt code is:");
        System.out.println(encrypt);
        ///end of Encrypt

        System.out.print("Please enter a value (<= -1) to decrypt.");
        int deValue = keyb.nextInt();
        char[] decrypt = Decrypt(deValue,encrypt,str); //method output
        System.out.print("Your encrypt code is:");
        System.out.println(decrypt);
        ///end of Decrypt
        //arrayAvg
        System.out.print("arrayAvg: How many numbers? ");
        int num = keyb.nextInt();
        int[] avarr = new int[num]; //store numbers value
        double avg = arrayAvg(avarr,num); //method calculation
        System.out.println("The avarage is " +avg);
        //end of arrayAvg

        int[] reArray = setArray(); //method reverse
        System.out.print("Reverse: The reverse array is: ");
        System.out.println(Arrays.toString(reArray));
        //end of reverse

        System.out.print("Array Contains: Please enter an int to search: ");
        int ints = keyb.nextInt();
        boolean checked = checkArray(reArray,ints); //check with boolean
        if(checked == true){
            System.out.println("It contains.");
        }else{
            System.out.println("Not Found.");
        }//end of contains

    }//end of main

    public static char[] Encrypt(int value, char[] c,char[] str){

        char [] keys = new char[10]; //store encrypt chars
        for (int i = 0;i < c.length;i ++){
            for(int y =0; y<str.length;y++){
                if(c[i] == str[y]){
                    if(y+value>26){
                        if(y+value%26<26){
                            keys[i]=str[y+value%26];
                        }else if(y+value%26>26){
                            keys[i]=str[y+value%26-26];
                        }else{
                            keys[i]=str[0];
                        }
                    }
                }
            }
        }
        return keys;

    }//Encrypt

    public static char[] Decrypt(int deValue, char[] encrypt,char[] str){

        char [] reKeys = new char[10]; // same function as encrypt
        for (int i = 0;i < encrypt.length;i ++){
            for(int y =0; y<str.length;y++){

                if(encrypt[i] == str[y]){
                    if(deValue%26 == 0){
                        reKeys[i] = str[y];
                    }else if(y+deValue<0){
                        if(y+deValue%26<0){
                            reKeys[i]=str[y+deValue%26+26];
                        }else if(y+deValue%26>0){
                            reKeys[i]=str[y+deValue%26];
                        }
                    }else if(y+deValue == 0){
                        reKeys[i] = str[0];
                    }else{
                        reKeys[i]=str[y+deValue];
                    }
                }
            }
        }
        return reKeys;

    }//Decrypt

    public static double arrayAvg(int[] avarr,int num){
        double sum = 0;
        double avg = 0;
        Scanner keyb = new Scanner(System.in);
        System.out.println("Enter values in the array for average:");
        for(int i = 0; i < num; i++){
            avarr[i] = keyb.nextInt();
            sum = sum + avarr[i]; //calculation
        }
        avg = sum / num;
        return avg;

    }//end of arrayAvg

    public static int[] setArray(){
        double sum = 0;
        int num = 10; //set max num for the array
        int[] setArray = new int[10];
        int[] reverseArray = new int[10];

        Scanner keyb = new Scanner(System.in);
        System.out.println("Set Array: Please enter 10 ints:");

        for(int i = 0; i < num; i++){
            setArray[i] = keyb.nextInt();
        }
        for (int i = 0; i < num; i++) {
            reverseArray[i] = setArray[num - i - 1]; //reverse function
        }
        return reverseArray;

    }//end of reverse

    public static Boolean checkArray(int[] reArray, int ints){
        boolean check = false;
        for(int i = 0; i < reArray.length; i++){
            if(ints == reArray[i]){
                check = true;
                break;
            }
        }
        return check; //if no found with false

    }// end of contains

}//end of class
