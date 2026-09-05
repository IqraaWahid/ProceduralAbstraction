/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author i2wahid
 */
public class ProceduralAbstraction {
    /*
    Requires: None
    Modifies: None
    Effects: Returns the smallest positive integer n for which n!
    (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
    integer x. Otherwise returns 1.
    */
    public static int reverseFactorial(int x) {
        int fac=1;
        
        //x=119
        if(x>0){
            for(int i=1;i<=x;i++){//i=5
                fac=fac*i;//fac=120
                
                if(fac>=x){
                    return i;
                }
            }
        }
        
        return 1;//otherwise return 1
    }
    
    /*
    Requires: None
    Modifies: None
    Effects: If the matrix arr satisfies Nice property, prints the sum and
    returns true. Otherwise returns false.
    */
    public static boolean isMatrixNice(int [][] arr) {
        if(arr==null || arr.length==0){
            return false;
        }
    
        //check if matrix is a square matrix:
        int row=arr.length;
        for(int i=0;i<row;i++){
            if(arr[i].length!=row){
                return false;
            }
        }
        
        //The sum of the integers in each row, each column and both the diagonals are same.
        //target:
        int target=0;
        for(int j=0;j<arr[0].length;j++){
            target=target+arr[0][j];
        }
        
        //row
        for(int i=0;i<row;i++){
            int rowSum=0;
            for(int j=0; j<arr[i].length; j++){
                rowSum=rowSum+arr[i][j];
            }
            if(rowSum!=target){
                return false;
            }
        }
        
        //column:
        for(int j=0;j<row;j++){
            int columnSum=0;
            for(int i=0;i<row;i++){
                columnSum=columnSum+arr[i][j];
            }
            if(columnSum!=target){
                return false;
            }
        }
        
        //left diagonal:
        int diagonalSumL=0;
        for(int i=0;i<row;i++){
            diagonalSumL=diagonalSumL+arr[i][i];
        }
        if(diagonalSumL!=target){
            return false;
        }
        
        //right diagonal:
        int diagonalSumR=0;
        for(int i=0;i<row;i++){
            diagonalSumR=diagonalSumR+arr[i][row-i-1];
        }
        if(diagonalSumR!=target){
            return false;
        }
        
        System.out.println("The sum is " + target);
        return true;
    }
    
    public static void main (String [] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a number for x: ");
        int x=input.nextInt();
        
        System.out.println("The value of n is: " + reverseFactorial(x));
        
        System.out.println();
        
        //get info about array from user
        System.out.print("# of rows of matrix: ");
        int r=input.nextInt();
        
        System.out.print("# of columns of matrix:  ");
        int c=input.nextInt();
        
        int [][] arr=new int [r][c];
        
        System.out.println("Enter " + (r*c) + " numbers to fill the array: ");
        
        //populate the array:
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                    arr[i][j]=input.nextInt();
            }
        }
        
        System.out.println(isMatrixNice(arr));
        
        /*
        //test array output:
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        */
    }

}
