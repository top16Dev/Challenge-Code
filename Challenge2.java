/* Online Java Compiler and Editor */
import java.util.Random;
public class HelloWorld{

     public static void main(String []args){
         Random rand = new Random();
         int list_count = (int)(Math.random() * 100000);
         int max = (int)Math.pow(2, 31) - 1, min = -(int)Math.pow(2, 31);
         int S = rand.nextInt(max);
         int list[] = new int[list_count];
         for(int i = 0; i < list_count; i++){
             list[i] = rand.nextInt(max) * (rand.nextInt(2) == 0 ? (1) : -1);
             
         }
         int flag = 0;
         for(int i = 0; i < list_count && flag == 0; i++){
             for(int j = 0; j < list_count && flag == 0; j++){
                 if(i == j) continue;
                 if(list[i] > 0 && list[j] > 0 && (list[i] > S || list[j] > S)) continue;
                 if(list[i] + list[j] == S) flag = 1;
             }
         }
        System.out.println(S);
        if(flag == 0) System.out.println("Can't");
        else System.out.println("Can");
     }
}