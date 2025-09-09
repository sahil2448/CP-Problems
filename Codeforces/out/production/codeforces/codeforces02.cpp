// TEAM
#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n; 

    int count = 0; 

    for (int i = 0; i < n; i++) {
        int l, m, n;
        cin >> l >> m >> n; 
        if ((l + m + n) >= 2) {
            count++; 
        }
    }

    cout << count << endl; 

    return 0;
}
