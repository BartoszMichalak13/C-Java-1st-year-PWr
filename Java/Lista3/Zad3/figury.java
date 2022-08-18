import java.lang.Math;
interface Cal1
{
    public double Pole(int a);
    public double Obw(int a);
}
interface Cal2
{
    public double Pole(int a, int b);
    public double Obw(int a, int b);
}
abstract class Figure implements Cal1
{
    public enum one implements Cal1
    {
        DISC
        {
            public double Pole(int r)
            {
                return Math.PI*(r*r); 
            }
            public double Obw(int r)
            {
                return Math.PI*(r*2);
            }
        },
        SQUARE
        {
            public double Pole(int a)
            {
                return a*a; 
            }
            public double Obw(int a)
            {
                return 4*a; 
            }
        },
        PENTAGON
        {
            public double Pole(int a)
            {
                return (5*a*a*(1.0/Math.tan(0.2*Math.PI)))/4; 
            }
            public double Obw(int a)
            {
                return 5*a;
            }
        },
        HEXAGON
        {
            public double Pole(int a)
            {
                return (3*a*a*Math.sqrt(3))/2; 
            }
            public double Obw(int a)
            {
                return 6*a; 
            }
        };
        
        
    }
    public enum two implements Cal2
    {
        RHOMBUS
        {
            public double Pole(int a, int deg)
            {
                double rad=Math.toRadians(deg);
                return a*a*Math.sin(rad); 
            }
            public double Obw(int a, int deg)
            {
                return 4*a; 
            }
        },
        RECTANGLE
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
      
    }
};
/*
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
*/