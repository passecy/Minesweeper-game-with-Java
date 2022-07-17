import java.util.Scanner;
import java.util.Random;
class Scratch {
    public static void main(String[] args) {


        //creating empty matrix with the input from the user
        int a;
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Even Value:");
            a = input.nextInt();
            if (a%2==0) {


                break;

            }else {
                System.out.println("Please enter a proper value!");

            }

        }








        //placing %25 mine to the matrix randomly
        int[][]empty=new int[a][a];
        int i = 0;
        while (i<(a*a)/4){
            Random rand=new Random();
            int row= rand.nextInt(a);
            int column=rand.nextInt(a);
            if (empty[row][column]==0) {
                empty[row][column]=1;


            }
            else{
                continue;
            }

            i=i+1;
        }



        //answer box for all inputs
        int[][]answers=new int[a][a];
        for (int k = 0; k <a; k++) {
            for (int l = 0; l <a; l++) {
                int z=0;
                for (int m =-1; m <2; m++) {
                    for (int n = -1; n <2; n++) {
                        try {
                            assert empty[k + m] != null;
                            if (empty[k+m][l+n]==1){
                                z=z+1;

                            }

                        }
                        catch (Exception ignored){
                        }



                    }

                }
                if(empty[k][l]==1){
                    z=z-1;
                }
                answers[k][l]=z;


            }

        }













        //welcome screen, only appears once
        int[][]output=new int[a][a];
        System.out.println("Welcome to the minesweeper game!!");

        for (int k = 0; k <a; k++) {
            for (int l = 0; l <a; l++) {
                if (output[k][l] == 0) {
                    System.out.print("- ");


                }


            }System.out.println();

        }
        System.out.println();
        System.out.println("=================================");







        int j=0;

        int[][] inputs =new int[a][a];

        while (j<3*(a*a)/4){



            //takes input from the player and saves them in to the inputs' matrix to be used later
            System.out.println("Row:");
            int answerR= input.nextInt();

            System.out.println("Column:");
            int answerC=input.nextInt();

            if ((answerC>a-1)||(answerC<0)||(answerR<0)||(answerR>a-1)||(inputs[answerR][answerC]==1)) {
                System.out.println("Please enter proper values!");
                continue;

            }
            inputs[answerR][answerC]=1;
            System.out.println("=================================");
            System.out.println();
            j=j+1;




            //the appearance of the game box after the choice of the player
            for (int k = 0; k <a; k++) {
                for (int l = 0; l <a; l++) {
                    if ((inputs[k][l] == 1)&&((empty[k][l]!= 1))) {

                        System.out.print(answers[k][l]+" ");


                    } else if ((inputs[k][l] == 1)&&((empty[k][l]== 1))) {
                        System.out.print("* ");

                    } else {
                        System.out.print("- ");
                    }


                }System.out.println();

            }










            //ends the game and writes the answer box if player chooses a mine

            if (empty[answerR][answerC]== 1) {
                System.out.println("GAME OVER!");
                System.out.println();
                System.out.println("=================================");
                System.out.println();
                System.out.println("Locations of the mines:");
                for (int k = 0; k <a; k++) {
                    for (int l = 0; l <a; l++) {
                        if (empty[k][l] == 1) {
                            System.out.print("* ");

                        }
                        else {
                            System.out.print("- ");
                        }

                    }
                    System.out.println();
                }
                System.out.println();
                break;


        }
            System.out.println();
            System.out.println("=================================");


        }

        //since there is a certain number of correct choices
        if(j==3*(a*a)/4){
            System.out.println();
            System.out.println("You win the game!!!!");


        }
    }
}







