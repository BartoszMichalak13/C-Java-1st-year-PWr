#pragma once

#include<iostream>
#include<string>
#include<sstream>
using namespace std;

int main();
/**
 * Klasa elementu drzewa
 * @param elem wartosc elementu
 * @param left pointer do elementu na lewo od elem
 * @param right pointer do elementu na right od elem
 */
template<typename T>
class TreeElem 
{         
  public:                                    
    T elem;
    TreeElem<T>* left;
    TreeElem<T>* right;
    TreeElem(T elem)
    {
      this->elem=elem;
      left=NULL;
      right=NULL;
    }
    /**
     * draw() funkcja rysujaca drzewo
     * @return
     */
    string draw(){return elem.toString();}
    ~TreeElem()
    {
      delete[] elem;
      delete[] *left;
      delete[] *right;
    };
};
/**
 * Klasa Drzewa
 * @param root wskaznik na korzen drzewa
 */
template<typename T>
class Tree
{
  private:
    TreeElem<T>* root;
    /**
     * Funkcja ins dodajaca do drzewa element elem
     * @param elem elemnt dodawany do drzewa
     * @param w wskaznik na wezel drzewa
     * @return
     */
    TreeElem<T> *ins(T elem, TreeElem<T>* w) 
    {
      if( w==NULL ) 
        return new TreeElem<T>(elem);
      if( elem<(w->elem) ) 
        w->left = ins(elem, w->left);
      else if( elem>(w->elem))
        w->right = ins(elem, w->right);
      return w;
    }
    /**
     * Funkcja isElem sprawdzajaca czy dany element istnieje w drzewie
     * @param elem szukany element
     * @param w wskaznik na wezel w ktorym obecnie sie znajdujemy
     * @return Czy znalazlo element czy nie
     */
    bool isElem(T elem, TreeElem<T>* w) 
    {
      if( w==NULL ) 
        return false;
      if(elem==(w->elem)) 
        return true;
      if(elem<(w->elem)) 
        return isElem(elem, w->left);
      else
        return isElem(elem, w->right);
    }
    /**
     * Funkcja rysujaca drzewa
     * @param w wskaznik na wezel drzewa w ktorym sie znajdujemy
     * @return Drzewo
    */
    string toS(TreeElem<T>* w) 
    { 
      stringstream ss;
      string vals;
      if( w!=NULL )
      {
        ss<<w->elem;
        ss>>vals;
        return "("+vals+":"+toS(w->left)+":"+toS(w->right)+")";
      }
      return "()";
    }
    /**
     * Funkcja usuwajaca element
     * @param elem usuwany element
     * @param w wskaznik na obency wezel
     * @return drzewo bez elem
     */
    TreeElem<T> *del(T elem, TreeElem<T>* w)//lisc lub node 2kids/1kid
    {
      if (w == NULL)
        return w;
      if(elem<(w->elem))
        w->left = del(elem,w->left);
      else if(elem>(w->elem))
        w->right = del(elem,w->right);
      else//"elem==w.elem" 
      {
        if (w->left == NULL&&w->right == NULL)
        {
          if(w==root)
            root=NULL;
          w=NULL;
          return w;
        }
        else if (w->left == NULL)
        {
          if(w==root)
            root=w->right;
          return w->right;
        }
        else if (w->right == NULL)
        {
          if(w==root)
            root=w->left;
          return w->left;
        }
        w->elem = findmin(w->right);
        w->right = del(w->elem,w->right);
      }
      return w;
    }
  public:
    Tree(){root=NULL;}
    ~Tree()
    {
      delete[] root;
    };
    /**
     * Funkcja insert wolajaca funkcje ins
     * @param elem elemnt dodawany do drzewa
     */
    void insert(T elem) { root = ins(elem, root); }
    /**
     * Funkcja search woalajca funkcje isElem
     * @param elem element szukany
     * @return Czy znalazlo element czy nie
     */
    bool search(T elem) { return isElem(elem,root); }
    /**
     * Funkcja wolajaca funkcje toS
     * @return
     */
    string draw() { return toS(root); }
    /**
     * Funcja liczaca minimalna wartosc elementu prawej galezi
     * @param w wskaznik na obecny wezel
     * @return Minimalna wartosc w prawej galezi
     */
    T findmin( TreeElem<T>* w)
    {
      T mval=w->elem;
      while(w->left!=NULL)
      {
        mval=w->left->elem;
        w=w->left;
      }
      return mval;
    }
    /**
     * Funkcja wolajaca funkcje del
     * @param elem
     */
    void delete1(T elem)
    {
      del(elem,root);
    }
};
