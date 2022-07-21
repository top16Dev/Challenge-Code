/* Online Java Compiler and Editor */
import java.util.Random;
public class HelloWorld{
     public static int[] maxSum(int[] list_numbers){
         int maxSumIndex = 0, mSum = 0, currentSum = 0, currentSumIndex = 0, maxSumLength = 0;
         int i = 0;
         for(i = 0; i < list_numbers.length; i++){
             if(list_numbers[i] == -1){
                 if(i - currentSumIndex == 0){
                     currentSumIndex = i + 1;
                     currentSum = 0;
                     continue;
                 }
                 if(mSum <= currentSum) {
                     if(mSum == currentSum && maxSumLength > i - currentSumIndex){
                         continue;
                     }
                     mSum = currentSum;
                     maxSumIndex = currentSumIndex;
                     maxSumLength = i - currentSumIndex;
                 }
                 currentSumIndex = i + 1;
                 currentSum = 0;
                 continue;
             }
             currentSum += list_numbers[i];
         }
         if(mSum <= currentSum) {
             if(!(mSum == currentSum && maxSumLength > i - currentSumIndex)){
                 mSum = currentSum;
                 maxSumIndex = currentSumIndex;
                 maxSumLength = i - currentSumIndex;
             }
         }
         currentSumIndex = i + 1;
         currentSum = 0;
         int result[] = new int[maxSumLength];
         for(i = maxSumIndex; i < maxSumIndex + maxSumLength; i++){
             result[i - maxSumIndex] = list_numbers[i];
         }
         return result;
     }
     public static int[] minAvg(int[] list_numbers){
         int minAvgIndex = 0, currentSumIndex = 0, minAvgLength = 0;
         double mAvg = 999999.0, currentSum = 0;
         int i = 0;
         for(i = 0; i < list_numbers.length; i++){
             if(list_numbers[i] == -1){
                 if(i - currentSumIndex == 0){
                     currentSumIndex = i + 1;
                     currentSum = 0;
                     continue;
                 }
                 double curAvg = currentSum / (double)(i - currentSumIndex);
                 if(mAvg > curAvg) {
                     mAvg = curAvg;
                     minAvgIndex = currentSumIndex;
                     minAvgLength = i - currentSumIndex;
                 }
                 currentSumIndex = i + 1;
                 currentSum = 0;
                 continue;
             }
             currentSum += (double)list_numbers[i];
         }
	 if(list_numbers[i - 1] != -1) {
         	double curAvg = currentSum / (double)(i - currentSumIndex + 1);
         	if(mAvg > curAvg) {
          	   mAvg = curAvg;
          	   minAvgIndex = currentSumIndex;
         	   minAvgLength = i - currentSumIndex;
         	}
	 }
         int result[] = new int[minAvgLength];
         for(i = minAvgIndex; i < minAvgIndex + minAvgLength; i++){
             result[i - minAvgIndex] = list_numbers[i];
         }
         return result;
     }
     public static void main(String []args){
         Random rand = new Random();
         int max = 100;
         int total_length = rand.nextInt(max);
         int list[] = {1, 5, -1, 1, 2, 2, -1, 1};
         int list_rand[] = new int[total_length];
         for(int i = 0; i < total_length; i++){
             if(rand.nextInt(3) == 1) list_rand[i] = -1;
             else list_rand[i] = rand.nextInt(10) + 1;
             if(list_rand[i] == -1) System.out.print("null ");
             else System.out.print(list_rand[i] + " ");
         }
         System.out.println();
         System.out.println();
         int res1[] = maxSum(list_rand);
         int res2[] = minAvg(list_rand);
         for(int i = 0; i < res1.length; i++){
            if(i == res1.length - 1) System.out.println(res1[i]);
            else System.out.print(res1[i] + ", ");
         }
         System.out.println();
         for(int i = 0; i < res2.length; i++){
            if(i == res2.length - 1) System.out.println(res2[i]);
            else System.out.print(res2[i] + ", ");
         }
     }
}