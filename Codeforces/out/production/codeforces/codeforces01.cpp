// WATERMELON
#include <iostream>
using namespace std;

string Watermelon(int w) {
    // Check if weight is even and greater than 2
    if (w % 2 == 0 && w > 2) {
        return "YES";
    } else {
        return "NO";
    }
}

int main() {
    int w;
    cin >> w;

    // Output
    cout << Watermelon(w) << endl;

    return 0;
}
