package com.example.think.blogtest;

import android.util.Log;

/**
 * Created by HuangMei on 2017/3/27.
 */

public class SortAlgorithm {

    //bubble sort part
    public static void bubbleSort(int[] numbers) {
        int tmp;
        int length = numbers.length;
        boolean isChange = false;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    isChange = true;
                    tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
                if (!isChange) {
                    return;
                }
            }
        }
    }


    //quick sort part

    public static int getMiddle(int[] numbers, int high, int low) {
        int middle = low;
        int tmp = numbers[middle];
        while (low < high) {
            while (low < high && numbers[low] < tmp) {
                low++;
            }
            numbers[high] = numbers[low];

            while (low < high && numbers[high] > tmp) {
                high--;
            }
            numbers[low] = numbers[high];
        }

        numbers[low] = tmp;
        return middle;
    }

    public static void quickSort(int[] numbers, int high, int low) {
        if (low < high) {
            int middle = getMiddle(numbers, high, low);
            quickSort(numbers, high, middle + 1);
            quickSort(numbers, middle - 1, low);
        }
    }

    //chose sort part
    public static void choseSort(int[] numbers) {
        int len = numbers.length;
        int k;
        int tmp;
        for (int i = 0; i < len; i++) {
            k = i;
            for (int j = i + 1; j < len; j++) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }

            tmp = numbers[k];
            numbers[k] = numbers[i];
            numbers[i] = tmp;
        }
    }


    // insert sort part
    public static void insertSort(int[] numbers) {
        int len = numbers.length;
        int tmp;
        int j ;
        int k ;

        //按照自己的思路， 复杂度较高

//        for (int i = 1; i < len; i++) {
//            tmp = numbers[i];
//            j = 0;
//            while(j < i){
//                if (tmp < numbers[j]){
//                    for (k = i - 1; k >= j; k --){
//                        numbers[k + 1] = numbers[k];
//                    }
//                    numbers[j] = tmp;
//                    break;
//                }
//                j ++;
//            }
//        }

        //按照自己的思路，复杂度降低
//        for (int i = 1; i < len; i ++){
//            tmp = numbers[i];
//            j = i - 1;
//            while (j >= 0 && numbers[j] > tmp){
//                numbers[j + 1] = numbers[j];
//                j --;
//            }
//            numbers[j + 1] = tmp;
//        }


        //或者 循环算法改成如下样式

        for (int i = 0; i < len; i++) {
            tmp = numbers[i];
            for (j = i; j > 0 && numbers[j - 1] < tmp; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = tmp;
        }

        for (int i = 0; i < numbers.length; i++) {
            Log.e("numbersort111 ++++", numbers[i] + "   ");
        }
    }


    public static void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
//        for (int increment = data.length / 2; increment > 0; increment /= 2) {
//            for (int i = increment; i < data.length; i++) {
//                temp = data[i];
//                for (j = i; j >= increment; j -= increment) {
//                    if (temp > data[j - increment])//如想从小到大排只需修改这里
//                    {
//                        data[j] = data[j - increment];
//                    } else {
//                        break;
//                    }
//
//                }
//                data[j] = temp;
//            }
//        }

        //自己的思路。。复杂度有点高
        int len = data.length;
//        for (int gap = len / 2; gap > 0; gap /= 2){
//            for (int i = 0; i < gap; i ++){
//                j = gap + i;
//                int k ;
//                while(j < len){
//                    k = j;
//                    temp = data[k];
//                    while (k > i){
//                        if (temp < data[k - gap]){
//                            data[k] = data[k - gap];
//                            k -= gap;
//                        } else
//                            break;
//                    }
//                    data[k] = temp;
//
//                    j += gap;
//                }
//            }
//        }

        for (int gap = len / 2; gap > 0; gap /= 2){
            for (int i = gap; i < len; i ++){
                temp = data[i];
                for (j = i - gap; j < i; j += gap){
                    if (data[j] > temp){
                        data[j + gap] = data[j];
                    } else
                        break;
                }
                data[j - gap] = temp;
            }
        }

        for (int i = 0; i < data.length; i++) {
            Log.e("numbersort111 ++++", data[i] + "   ");
        }
    }


}
