import java.util.*;

 

class Determinant 

{

 

    public static double determinant(double A[][])

    {
        int N=A.length;
        double det=0;

        if(N == 1)

        {

            det = A[0][0];

        }

        else if (N == 2)

        {

            det = A[0][0]*A[1][1] - A[1][0]*A[0][1];

        }

        else

        {

            det=0;

            for(int j1=0;j1<N;j1++)

            {

                double[][] m = new double[N-1][N-1];

                

                for(int i=1;i<N;i++)

                {

                    int j2=0;

                    for(int j=0;j<N;j++)

                    {

                        if(j == j1)

                            continue;

                        m[i-1][j2] = A[i][j];

                        j2++;

                    }

                }

                det += Math.pow(-1.0,1.0+j1+1.0)* A[0][j1] * determinant(m);

            }

        }

        return det;

    }

 

 

    public static void main(String args[])

    {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the order of the square matrix");

        int n = in.nextInt();

 

        System.out.println("Enter the elements of the square matrix");

        double[][] mat = new double[n][n];

        for(int i=0; i<n; i++)

        {

            for(int j=0; j<n; j++)

            {

                mat[i][j] = in.nextDouble();

            }

        }

 


 

        System.out.println("The determinant of the Matrix is : "+determinant(mat));
}}