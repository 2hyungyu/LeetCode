package org.LeetCode;

import java.util.*;

public class MathLeetCode {

//    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
//    answer[i] == "Fizz" if i is divisible by 3.
//    answer[i] == "Buzz" if i is divisible by 5.
//    answer[i] == i (as a string) if none of the above conditions are true.
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        String fizzBuzz = "FizzBuzz";
        String fizz = "Fizz";
        String buzz = "Buzz";
        for (int i = 1 ; i <= n ; i++) {
            if ((i % 15) == 0) {
                result.add(fizzBuzz);
            } else if ((i % 3) == 0) {
                result.add(fizz);
            } else if ((i % 5) == 0) {
                result.add(buzz);
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isNotPrime = new boolean[n];

        int result = 0;
        for (int prime = 2 ; prime < n ; prime++) {
            if (!isNotPrime[prime]) {
                result++;
                for (int i = 2 ; i * prime < n ; i++) {
                    isNotPrime[i * prime] = true;
                }
            }
        }
        return result;
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        int r = n % 3;
        while (r != 1) {
            n = n / 3;
            r = n % 3;
            if (r % 3 != 0) {
                return false;
            }
        }
        return true;
    }

}
