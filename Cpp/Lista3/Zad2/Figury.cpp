#define _USE_MATH_DEFINES
#include "Fig.hpp"
#include "hed.hpp"

double Disc::Pole(int r, int b)
{
    return M_PI*(r*r); 
}
double Disc::Obw(int r, int b)
{
    return M_PI*(r*2); 
}
double Pentagon::Pole(int a, int b)
{
    double tan(double x);
    return (5*a*a*(1.0/tan(0.2*M_PI)))/4; 
}
double Pentagon::Obw(int a, int b)
{
    return 5*a; 
}
double Hexagon::Pole(int a, int b)
{
    return (3*a*a*sqrt(3))/2; 
}
double Hexagon::Obw(int a, int b)
{
    return 6*a; 
} 
double Square::Pole(int a, int b)
{
    return a*a; 
}
double Square::Obw(int a, int b)
{
    return 4*a; 
}
double Rectangle::Pole(int a, int b)
{
    return a*b; 
}
double Rectangle::Obw(int a, int b)
{
    return (2*a)+(2*b); 
}
double Rhombus::Pole(int a, int deg)
{     
    return a*a*sin(deg*M_PI/180); 
}
double Rhombus::Obw(int a, int b)
{
    return 4*a; 
}
