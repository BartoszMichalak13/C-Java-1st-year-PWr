class Small extends Exception{};
public class Main
{
   public static void main(String[] args)//ma pisac jak zle arg dla czwor i jak za malo arg
   {
      int n=0;
      char[] tab = args[n].toCharArray();
   
      /*
      int o=0;
      int c=0;
      int p=0;
      int s=0;
      */
      
      /*for(n=1; n<args.length; n++)//to jest teraz prob
      {
         try
         {
            int u=Integer.parseInt(args[n]);
            if(u<=0)
               throw new Small();
         }
         catch(NumberFormatException e)
         {
            System.out.println(args[n] + " - nie jest liczbą");
         }
         catch(Small e)
         {
            System.out.println(args[n] + " - nie jest dodatnie");
         }
         catch(Exception e)
         {
            System.out.println(args[n] + " - jest nie odpowiednie");
         }
      }
      */
      int j=1;
      for(int i=0; i<tab.length; i++)
      {
         if((j+1)>args.length)
         {
            System.out.println("Nie podano argumentów");         
            break;
         }
         if(tab[i]=='o')//koło
         {
            prob t = new prob();    
            if(t.proba(args[j])==true)
            {
               int m=Integer.parseInt(args[j]); 
               Figure kol = new Disc();
               System.out.println("Pole koła to: " + kol.Pole(m, 0));
               System.out.println("Obwód koła to: " + kol.Obw(m, 0));
            }
            j++;
         }
         else if(tab[i]=='c')//czworokąty
         {
            if(j+4>=args.length)
            {
               System.out.println("Podano za mało argumentów");
               break;
            }
            int w=0;
            prob t = new prob();    
            for(int k=0; k<5; k++)
            {
               if(t.proba(args[j+k])==true)
                  continue;
               else
                  w=1;
            }

            if(w!=1)
            {
               int b1=Integer.parseInt(args[j]);//czwrookąty
               int b2=Integer.parseInt(args[j+1]);
               int b3=Integer.parseInt(args[j+2]);
               int b4=Integer.parseInt(args[j+3]);
               int deg=Integer.parseInt(args[j+4]);
               if(deg>=180)
               {
                  System.out.println(deg + " - jest nie odpowiednie");
                  break;
               }
               //System.out.println("Bok 1: "+ b1 +"Bok 2: "+ b2 +"Bok 3: "+ b3 +"Bok 4: "+ b4 +"Deg: "+ deg);
               if(deg>90&&deg<180)//żeby liczyc sin 30 a nie 120
                  deg=deg-90;
               if(deg!=90&&(b1==b2&&b2==b3&&b3==b4))//romb
               {
                  Quad rom = new Rhombus();
                  System.out.println("Pole rombu to: " + rom.Pole(b1, deg));
                  System.out.println("Obw rombu to: " + rom.Obw(b1, 0));
               }
               else if(deg==90&&(b1==b2&&b2==b3&&b3==b4))//kwadrat
               {
                  Quad kw = new Square();
                  System.out.println("Pole kwadratu to: " + kw.Pole(b1, 0));
                  System.out.println("Obw kwadratu to: " + kw.Obw(b1, 0));
               }//prostokąt
               else if(deg==90&&((b1==b2&&b3==b4)||(b1==b3&&b2==b4)||(b1==b4&&b3==b2)))
               {
                  int m; 
                  if(b1==b2)
                     m=b3;
                  else if(b1==b3)
                     m=b2;
                  else if(b1==b4)
                     m=b2;
                  else 
                  {
                     System.out.println("To jest nie możliwe");
                     break;
                  }
                     
                  Quad pr = new Rectangle();
                  System.out.println("Pole prostokąta to: " + pr.Pole(b1, m));
                  System.out.println("Obw prostokąta to: " + pr.Obw(b1, m));
               }
               else 
                  System.out.println("Podano nieodpowiednie argumenty");
            }
            j=j+5;
         }
         else if(tab[i]=='p')//pięciokąt
         {
            
            prob t = new prob();    
            if(t.proba(args[j])==true)
            {
               int m=Integer.parseInt(args[j]);
               Figure Pen = new Pentagon();
               System.out.println("Pole pięciokąta to: " + Pen.Pole(m, 0));
               System.out.println("Obw pięciokąta to: " + Pen.Obw(m, 0));
            }
            j++;
         }
         else if(tab[i]=='s')//sześciokąt
         {
            prob t = new prob();    
            if(t.proba(args[j])==true)
            {
               int m=Integer.parseInt(args[j]);
               Figure Hex = new Hexagon();
               System.out.println("Pole sześciokąta to: " + Hex.Pole(m, 0));
               System.out.println("Obw sześciokąta to: " + Hex.Obw(m, 0));
            }
            j++;
         }
         else 
            System.out.println("Podano nieprawidłową figurę :" + tab[i]);
      }
   }
}
