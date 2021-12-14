#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int n1, n2;
    cin >> n1;
    int *a = new int [n1];
    a[0] = 1;
    for (int i=0; i<n1; i++)
    {
       cin >> a[i]; 
    }
    cin >>n2;
    int *b = new int [n2];
    for (int i=0; i<n2; i++)
    {
        cin >> b[i];
    }
    
    vector<int> arr;
       
    int i=0, j=0;
    while(i<n1 && j<n2)
    {
        if(a[i] < b[j])
        {
            i++;
            continue;
        }
        else if(a[i] > b[j])
        {
            j++;
            continue; 
        }
        else if(a[i] == b[j])
        {
            arr.push_back(a[i]);
            i++;
            j++;
            continue;
        }
    }
    
    int size = arr.size();
    cout << size << endl;
    for(int i=0; i<size-1; i++)
    {
        cout << arr[i] << " " ;
    }
    cout << arr[size-1];
    return 0;
}


/*
41
1 6 7 12 17 21 25 28 33 34 35 37 40 42 44 45 48 51 53 55 60 63 67 70 73 75 77 81 82 85 87 89 93 98 101 104 109 110 115 119 121 
17
0 3 5 7 8 10 14 16 17 21 22 25 27 29 33 37 39 

13
1 3 7 9 12 14 19 21 24 29 31 32 33 
6
0 2 5 6 10 11 
*/