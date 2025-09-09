//  Way Too Long Words
#include<iostream>
#include <string>
using namespace std;

string abbreviate(const string& word) {
    if (word.length() <= 10)
        return word;
    
    return word[0] + to_string(word.length() - 2) + word.back();
}

void func(string arr[], int n) {
    for (int i = 0; i < n; i++) {
        cout << abbreviate(arr[i]) << endl;
    }
}

int main() {
    int n;
    cin >> n;
    string arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    func(arr, n); 
    return 0;
}
