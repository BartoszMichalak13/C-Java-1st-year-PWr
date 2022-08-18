#pragma once 
#include <exception>

class Small : public std::exception 
{
    public:
        const char* what() const noexcept
        {
            return " - Podano za mały argument";
        }

};
class Big : public std::exception 
{
    public:
        const char* what() const noexcept
        {
            return " - Podano za duży argument";
        }

};