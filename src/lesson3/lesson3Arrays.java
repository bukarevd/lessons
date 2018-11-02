package lesson3;

import java.util.Arrays;

public class lesson3Arrays {
    public static void main(String[] args) {
//        Arrays
        int[] arr; //объявление переменной массива
        int arr1[]; // тоже самое, чаще пользуются первый способом

        arr = new int[10]; //массив со значениями по умолчанию
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

        int a = 90;
        int[] arr3 = {2,3,4,5,6,7,8,a};
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr3.length);

//      доступ к элементам массива

        System.out.println(arr3[2]);

        arr3[1] = 123;
        System.out.println(Arrays.toString(arr3));

        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 10;
        }
        System.out.println(Arrays.toString(arr));

//        копирование массива

        int[] arr4 = {2 ,6, 8, 3};
        int[] arr5 = arr4;  // arr5 содержит ссылку на массив как и arr4

        int[] cloneArray = arr4.clone(); // полная копия массива
//        System.arraycopy(srcArr, int srcPos, dstArr, int dstPos, int lenght);  Частичная копия массива
        int[] arr6 = new int[10];
        System.arraycopy(arr4, 1, arr6, 2, 1);
        System.out.println(Arrays.toString(arr6));

        int[] copyArr4 = Arrays.copyOf(arr4, 3);
        System.out.println(Arrays.toString(copyArr4));

        int[] copyRangeArr4 = Arrays.copyOfRange(arr4, 1, 3);
        System.out.println(Arrays.toString(copyRangeArr4));

//        arr4 = new int[]{1, 2, 3, 4, 5, 6, 7}; переопределение массива
//        перебор значений
        for (int i = 0; i < arr4.length; i++){
            arr4[i] += 100;
        }

        for (int num: arr4) {
            System.out.println("num = " + num);
            num += 100;
        }
         arr4 = new int[] {2 ,6, 8, 3};
         arr5 = new int[] {2 ,6, 8, 3};

        System.out.println(arr4 == arr5);//Нельзя сравнивать 2 массива дааным способом (false)
        System.out.println(arr4.equals(arr5)); //Нельзя сравнивать 2 массива дааным способом (false)
        System.out.println(Arrays.equals(arr4, arr5)); // Только этим методом можно сравнивать массивы (true)

        int[] arr7 = new int[14];
        Arrays.fill(arr7, 233); //заполняет массив значением val
        System.out.println(Arrays.toString(arr7));
        arr7 = new int[]{3,6,4,11,6,17};
        Arrays.sort(arr7, 1, 6); //Сортирует массив или часть массива
        System.out.println(Arrays.toString(arr7));

        System.out.println(Arrays.binarySearch(arr7, 111)); //поиск в массиве значения, если значение отрицательное, то значения в массиве нет

    }
}
