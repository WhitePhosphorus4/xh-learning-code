#include <iostream>
using namespace std;
int main()
{
    float a,b,c;
	cin>>a>>b>>c;
	if(a>b)
	{ if(b>c)
	  cout<<c<<" "<<b<<" "<<a<<endl;
	  else
	  {if(a<c)
	  cout<<b<<" "<<a<<" "<<c<<endl;
	  else
	  cout<<b<<" "<<c<<" "<<a<<endl;
	  }
	}
  else
     {
	 	if(a>c)
	 	cout<<c<<" "<<a<<" "<<b<<endl;
	 	else
	 	{if(c>b)
	 	cout<<a<<" "<<b<<" "<<c<<endl;
	 	else
	 	cout<<a<<" "<<c<<" "<<b<<endl;
		 }
     }
    // cout<<(int)','<<endl;
    return 0;
}