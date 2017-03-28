package com.example.think.blogtest;

/**
 * Created by HuangMei on 2017/3/27.
 */

public class SortAlgorithm {

    //bubble sort part
    public static void bubbleSort(int[] numbers){
        int tmp;
        int length = numbers.length;
        boolean isChange = false;
        for (int i = 0; i < length; i ++){
            for (int j = i + 1; j < length; j ++){
                if (numbers[j] > numbers[j + 1]){
                    isChange = true;
                    tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
                if (!isChange){
                    return;
                }
            }
        }
    }


    //quick sort part

    public static int getMiddle(int[] numbers, int high, int low){
        int middle = low;
        int tmp = numbers[middle];
        while (low < high){
            while (low < high && numbers[low] < tmp){
                low ++;
            }
            numbers[high] = numbers[low];

            while (low < high && numbers[high] > tmp){
                high --;
            }
            numbers[low] = numbers[high];
        }

        numbers[low] = tmp;
        return middle;
    }

    public static void quickSort(int[] numbers, int high, int low){
        if (low < high){
            int middle = getMiddle(numbers, high, low);
            quickSort(numbers, high, middle + 1);
            quickSort(numbers, middle - 1, low);
        }
    }

    //chose sort part
    public static void choseSort(int[] numbers){
        int len = numbers.length;
        int k;
        int  tmp;
        for (int i = 0; i < len; i ++){
            k = i;
            for (int j = i + 1; j < len; j ++){
                if (numbers[j] < numbers[k]){
                    k = j;
                }
            }

            tmp = numbers[k];
            numbers[k] = numbers[i];
            numbers[i] = tmp;
        }
    }


    // insert sort part
    public static void insertSort(int[] numbers){
        int len = numbers.length;
        int tmp;
        for (int i = 1; i < len; i ++){
            tmp = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > tmp){
                numbers[j + 1] = numbers[j];
                j --;
            }
          numbers[j + 1] = tmp;
        }

        //或者 循环算法改成如下样式
        int j = 0;
        for (int i = 0; i < len; i ++){
            tmp = numbers[i];
            for (j = i; j > 0 && numbers[j - 1] < tmp; j --){
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = tmp;
        }

        //或者，按照自己的思路
        for (int i = 1; i < len; i ++){
            tmp = numbers[i];
            for (j = i - 1; j >= 0; j --){
                if (tmp < numbers[j]){
                    numbers[j + 1] = numbers[j];
                }
            }

            numbers[j] = tmp;
        }
    }




}
