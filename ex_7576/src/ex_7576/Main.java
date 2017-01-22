package ex_7576;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
   int row, column, length;

}

public class Main {
   static int ad[][], row, column, sum = 0, count = 0,temp=0;
   static Point p[];
   static boolean Visit[][];

   static Point P_in, P_d;

   public static void Check(Point p, boolean B[][], int a, int b, int AD[][]) {
      AD[a][b] = 1;
      B[a][b] = true;
      P_d.row = a;
      P_d.column = b;
      P_d.length--;
   }

   public static void BFS() {

      Queue<Point> que = new LinkedList<Point>();

      HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

      P_d.row = 1;
      P_d.column = 1;
      P_d.length = sum;

      que.offer(P_d);

      while (!que.isEmpty()&& P_d.length!=0) {
         P_d = que.poll();
//         System.out.println("P_d length = "+ P_d.length);
         if(P_d.length==0 && sum -P_d.length !=0){
            System.out.println(-1);
            System.exit(-1);
         }
         count++;
         
         Visit[row][column] = false;
         Visit[1][1] = false;
         for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
               if (ad[i][j] == 1) {
                  if (i + 1 <= row && ad[i + 1][j] == 0 && !Visit[i + 1][j]) { // 아랫
                     Check(P_d, Visit, i + 1, j, ad);
//                     System.out.println("아래 ad["+i+"]["+j+"]");
                     que.offer(P_d);
                  }
                  else if (i - 1 > 0 && ad[i - 1][j] == 0 && !Visit[i - 1][j]) {// 위
                     Check(P_d, Visit, i - 1, j, ad);
//                     System.out.println("위 ad["+i+"]["+j+"]");
                     que.offer(P_d);
                     
                  }
                  else if (j + 1 <= column && ad[i][j + 1] == 0 && !Visit[i][j + 1]) { // 오른쪽
                     Check(P_d, Visit, i, j + 1, ad);
//                     System.out.println("오른쪽 ad["+i+"]["+j+"]");
                     que.offer(P_d);
                  }
                  else if (j - 1 > 0 && ad[i][j - 1] == 0 && !Visit[i][j - 1]) { // 왼쪽
                     Check(P_d, Visit, i, j - 1, ad);
//                     System.out.println("왼쪽 ad["+i+"]["+j+"]");
                     que.offer(P_d);
                  }
               }
            }
         }
         
         
         // System.out.println("count = "+ count);

      }
   
   }

   public static void main(String[] ar) {
      int data = 0;
      Scanner sc = new Scanner(System.in);

      column = sc.nextInt();
      row = sc.nextInt();
      ad = new int[row + 1][column + 1];
      Visit = new boolean[row + 1][column + 1];
      P_d = new Point();

      for (int i = 1; i <= row; i++) {
         for (int j = 1; j <= column; j++) {
            data = sc.nextInt();
            ad[i][j] = data;
            if (ad[i][j] == 0)
               sum++;
         }
      }
      if (sum == row * column)
         System.out.println(0);
      else {
         BFS();
         System.out.println(count);
         
      }


      sc.close();

   }

}