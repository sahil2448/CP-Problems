#include<iostream>
using namespace std;

int Operation(int X, int n, string arr[]){
    for(int i=0;i<n;i++){
        if(arr[i]=="++X" || arr[i]=="X++"){
            X = X+1;
        }
        else if(arr[i]=="--X" || arr[i]=="X--"){
            X = X-1;
        }
    }
    return X;
}
int main(){
    int X = 0;
    int n;
    cin>>n;
    string arr[n];
    for(int i = 0; i<n ;i++){
        cin>>arr[i];
    }
    cout<<Operation(X,n,arr);
}