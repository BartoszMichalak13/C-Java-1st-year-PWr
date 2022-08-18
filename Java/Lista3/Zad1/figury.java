import java.lang.Math;
interface Cal
{
    public double Pole(int a, int b);
    public double Obw(int a, int b);
}
abstract class Figure implements Cal{};
abstract class Quad extends Figure{};

class Disc extends Figure
{
    public double Pole(int r, int b)
    {
        return Math.PI*(r*r); 
    }
     
    public double Obw(int r, int b)
    {
        return Math.PI*(r*2); 
    }
};
class Pentagon extends Figure
{
    public double Pole(int a, int b)
    {
        return (5*a*a*(1.0/Math.tan(0.2*Math.PI)))/4; 
    }
     
    public double Obw(int a, int b)
    {
        return 5*a; 
    }
};
class Hexagon extends Figure
{
    public double Pole(int a, int b)
    {
        return (3*a*a*Math.sqrt(3))/2; 
    }
     
    public double Obw(int a, int b)
    {
        return 6*a; 
    }
};

class Square extends Quad
{
    public double Pole(int a, int b)
    {
        return a*a; 
    }
     
    public double Obw(int a, int b)
    {
        return 4*a; 
    }
};
class Rectangle extends Quad
{
    public double Pole(int a, int b)
    {
        return a*b; 
    }
     
    public double Obw(int a, int b)
    {
        return (2*a)+(2*b); 
    }
};
class Rhombus extends Quad
{

    public double Pole(int a, int deg)
    {
        double rad=Math.toRadians(deg);
        return a*a*Math.sin(rad); 
    }
     
    public double Obw(int a, int b)
    {
        return 4*a; 
    }
};
