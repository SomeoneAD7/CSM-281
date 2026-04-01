/*
 * Algorithm:
 * 1. Read a number n from the user
 * 2. If n < 2, it is NOT prime (by definition)
 * 3. If n == 2, it IS prime
 * 4. If n is even and > 2, it is NOT prime
 * 5. Loop i from 3 to sqrt(n), stepping by 2
 *    a. If n % i == 0, n is NOT prime
 * 6. If no divisor found, n IS prime
 * 7. Print the result
 */

#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(int n) {
    if (n < 2) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;

    int limit = (int)sqrt((double)n);
    for (int i = 3; i <= limit; i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}

int main() {
    int number;
    cout << "Enter a number to check if it is prime: ";
    cin >> number;

    if (isPrime(number)) {
        cout << number << " is a PRIME number." << endl;
    } else {
        cout << number << " is NOT a prime number." << endl;
    }

    return 0;
}
