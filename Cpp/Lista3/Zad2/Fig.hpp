#pragma once

class Cal
{
    public:
        virtual double Pole(int a, int b);
        virtual double Obw(int a, int b);
};

class Figure: Cal{};
class Quad: Figure{};

class Disc: Figure
{
    public:
    double Pole(int a, int b);
    double Obw(int a, int b);
};
class Pentagon: Figure
{
    public:
    double Pole(int a, int b);
    double Obw(int a, int b);
};
class Hexagon: Figure
{
    public:
    double Pole(int a, int b);
    double Obw(int a, int b);
};

class Square: Quad
{
    public:
    double Pole(int a, int b);
    double Obw(int a, int b);
};
class Rectangle: Quad
{
    public:
    double Pole(int a, int b);
    double Obw(int a, int b);
};
class Rhombus: Quad
{
    public:
    double Pole(int a, int b);
    double Obw(int a, int b);
};
