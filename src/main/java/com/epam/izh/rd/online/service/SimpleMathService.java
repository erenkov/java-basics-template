package com.epam.izh.rd.online.service;

import java.util.Arrays;
import static java.lang.Math.sqrt;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        // Не изобретаем велосипед
        return Integer.compare(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        // Не изобретаем велосипед
        return Integer.max(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {

        int max = values[0];

        for (int i : values) {
            if (max < i) {
                max = i;
            }
        }

        return max;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        // Как советовали в одном из доп. видео -
        //          посмотрите что содержится в Arrays.
        return Arrays.stream(values).sum();
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        /* Если работать с примитивами (без коллекции), то так ..*/

        int count = 0;              // Переменная для количества чётных
        int[] result;

        for (int i : values) {      // Подсчитываем сколько четных
            if ((i % 2) == 0) {
                count++;
            }
        }

        result = new int[count];    // Создаем массив под четные
        int j = 0;                  // Переменная для индекса нового массива

        for (int i : values) {      // Заполняем массив
            if ((i % 2) == 0) {
                result[j] = i;
                j++;
            }
        }

        return result;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {

        if (initialVal == 0) {
            return 1L;
        } else {
            return initialVal * calcFactorial(initialVal - 1);
        }

    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if (number < 0) return 0;//
        switch (number) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            default:
                return calcFibonacci(number - 1) + calcFibonacci(number - 2);
        }
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        Arrays.sort(values);    //Статически не импортировал т.к. sort без класса вызовет рекурсию
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        /* Чтобы хоть как-то ускорить алгоритм : */

        /* 1) Отсеиваем единицу */
        if (number == 1) return false;

        /* 2) Отсеиваем четные, которые > 2 */
        if ((number % 2 == 0) && number > 2) {
            return false;
        }

        /* 3) От 3 х до кв.корня из number проверяем все нечетн. числа */
        for (int i = 3; i <= (int) sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {

        int[] result = new int[values.length];

        /* Просто в новый массив переписываем в обратном порядке */
        for (int i = 1; i <= values.length; i++) {
            result[result.length - i] = values[i - 1];
        }

        return result;
    }
}
