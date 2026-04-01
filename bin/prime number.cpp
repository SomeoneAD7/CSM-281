#include <iostream> 
#include <cmath>

using namespace std; 

bool isPrime(int n) {
    if (n < 1){
        return false;
    } 
    
    //int limit = (int)sqrt((double)n);
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0){
            return false;
        }
    }
    return true;
}

int main() {
    int number;
    cout << "Enter a number to check if it is prime: ";
    cin >> number;

    if (isPrime(number)) {
        cout << number << " is a PRIME number." << endl;
    } 
    else {
        cout << number << " is NOT a prime number." << endl;
    }

    return 0;
}
