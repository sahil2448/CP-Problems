#include<iostream>
using namespace std;

int compare(string emt1,string emt2){

    for(int i=0;i<emt1.length();i++){
        if(emt1==emt2){
            return 0;
        }
        else if(emt1<emt2){
            return -1;
        }
        else{
            return 1;
        }
    }

}
int main(){
    string s1,s2;
    cin>>s1;
    cin>>s2;
    
    string emt1="";
    string emt2="";
    for(int i=0; i<s1.length();i++){
        emt1 += (char)tolower(s1[i]);
    }
    for(int i=0; i<s2.length();i++){
        emt2 += (char)tolower(s2[i]);
    }
    cout<<compare(emt1,emt2);


}