/**
 * Klasa elementu drzewa
 * @param elem wartosc elementu
 * @param left element na lewo od elem
 * @param right element na prawo od elem
 */
class TreeElem<T extends Comparable<T>> 
{                                       
  T elem;
  TreeElem<T> left;
  TreeElem<T> right;
  TreeElem(T elem)
  {
    this.elem=elem;
    left=null;
    right=null;
  }
  /**
   * draw() funkcja rysujaca drzewo
   * @return
   */
  public String draw(){return elem.toString();}
}
/**
 * Klasa Drzewa
 * @param root korzen drzewa
 */
public class Tree<T extends Comparable<T>> 
{
  private TreeElem<T> root;
  public Tree(){root=null;}
  /**
   * Funkcja insert wolajaca funkcje ins
   * @param elem elemnt dodawany do drzewa
   */
  public void insert(T elem) { root = ins(elem, root); }
  /**
   * Funkcja ins dodajaca do drzewa element elem
   * @param elem elemnt dodawany do drzewa
   * @param w wezel drzewa w ktormy obecnie sie znajdujemy
   * @return
   */
  private TreeElem<T> ins(T elem, TreeElem<T> w) 
  {
    if( w==null ) return new TreeElem<T>(elem);
    if( elem.compareTo(w.elem)<0 ) 
      w.left = ins(elem, w.left);
    else if( elem.compareTo(w.elem)>0)
      w.right = ins(elem, w.right);
    return w;
  }
  /**
   * Funkcja search woalajca funkcje isElem
   * @param elem element szukany
   * @return Czy znalazlo element czy nie
   */
  public boolean search(T elem) { return isElem(elem,root); }
  /**
   * Funkcja isElem sprawdzajaca czy dany element istnieje w drzewie
   * @param elem szukany element
   * @param w wezel w ktorym obecnie sie znajdujemy
   * @return Czy znalazlo element czy nie
   */
  private boolean isElem(T elem, TreeElem<T> w) 
  {
    if( w==null ) 
      return false;
    if( elem.compareTo(w.elem)==0 ) 
      return true;
    if( elem.compareTo(w.elem)<0) 
      return isElem(elem, w.left);
    else
      return isElem(elem, w.right);
  }
  /**
   * Funkcja wolajaca funkcje toS
   * @return
   */
  public String draw() { return toS(root); }
  /**
   * Funkcja rysujaca drzewa
   * @param w wezel drzewa w ktorym sie znajdujemy
   * @return Drzewo
   */
  private String toS(TreeElem<T> w) 
  { 
    if( w!=null )
      return "("+w.elem+":"+toS(w.left)+":"+toS(w.right)+")";
    return "()";
  }
  /**
   * Funcja liczaca minimalna wartosc elementu prawej galezi
   * @param w obecny wezel
   * @return Minimalna wartosc w prawej galezi
   */
  public T findmin( TreeElem<T> w)
  {
    T mval=w.elem;
    while(w.left!=null)
    {
      mval=w.left.elem;
      w=w.left;
    }
    return mval;
  }
  /**
   * Funkcja wolajaca funkcje del
   * @param elem
   */
  public void delete(T elem)
  {
    del(elem,root);
  }
  /**
   * Funkcja usuwajaca element
   * @param elem usuwany element
   * @param w obency wezel
   * @return drzewo bez elem
   */
  private TreeElem<T> del(T elem, TreeElem<T> w)//lisc lub node 2kids/1kid
  {
    if (w == null)
      return w;
    if (elem.compareTo(w.elem)<0)
      w.left = del(elem,w.left);
    else if (elem.compareTo(w.elem)>0)
      w.right = del(elem,w.right);
    else//"elem==w.elem" 
    {
      if (w.left == null&&w.right == null)
      {
        if(w.equals(Tree.this.root))
          Tree.this.root=null;
        w=null;
        return w;
      }
      else if (w.left == null)
      {
        if(w.equals(root))
          root=w.right;
        return w.right;
      }
      else if (w.right == null)
      {
        if(w.equals(root))
          root=w.left;
        return w.left;
      }
      w.elem = findmin(w.right);
      w.right = del(w.elem,w.right);
    }
    return w;
  }
}
