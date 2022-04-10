/*依赖文件*/
#include </usr/local/include/liblas/liblas.hpp>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>
#include <pcl/io/pcd_io.h>
#include <pcl/point_types.h>
#include <time.h>
using namespace std;
int main()
{
    std::ifstream fp;
    fp.open("../data/1.las",ios::in|ios::binary);
    std::ofstream outfile("../data/1.pcd", ios::trunc);
    liblas::ReaderFactory readerFactory;
    liblas::Reader reader = readerFactory.CreateWithStream(fp);
    while (reader.ReadNextPoint())
    {
	double x = reader.GetPoint().GetX();
	double y = reader.GetPoint().GetY();
	double z = reader.GetPoint().GetZ();
        uint16_t i = reader.GetPoint().GetIntensity();
        outfile << x  << " " << y << " " << z << " " << i << endl;
    }
    fp.close();
    outfile.close();
    cout << "finished!" << endl;
    return 0;
}