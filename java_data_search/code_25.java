import java.util.ArrayList;
public class DB
{
  static  ArrayList<Beverage>  listProduct = new ArrayList<Beverage>();  
      public DB(){
                  
      }
       public void addproduct(Beverage p){
            listProduct.add(p);
       }
        
      public void deleteAll()
      {
                       int i=0;                                               
            while (i<listProduct.size()){
                Beverage z;
                if("Americano" == listProduct.get(i).getOrder()){
                    z = new Americano();
                }else if("Espresso" == listProduct.get(i).getOrder()){
                    z = new Espresso();
                }
                else if("Mocha" == listProduct.get(i).getOrder()){
                    z = new Mocha();
                }
                else if("Latte" == listProduct.get(i).getOrder()){
                    z = new Latte();
                }else if("Cappuchino" == listProduct.get(i).getOrder()){
                    z = new Cappuchino();
                }
                else if("fruit_tea" == listProduct.get(i).getOrder()){
                    z = new fruit_tea();
                }else if("Lemon_Iced_Tea" == listProduct.get(i).getOrder()){
                    z = new Lemon_Iced_Tea();
                }else if("Green_Tea" == listProduct.get(i).getOrder()){
                    z = new Cappuchino();
                }else if("Iced_Tea" == listProduct.get(i).getOrder()){
                    z = new Iced_Tea();
                }else if("Iced_Milk_Tea" == listProduct.get(i).getOrder()){
                    z = new Iced_Milk_Tea();
                }
                z = listProduct.get(i);
                listProduct.remove(z);
                i = i+1;
            }
        }
      
      public Beverage search(String pId){
        int i=0; 
                while (i<listProduct.size()){
            Beverage z ;
            if("Americano" == listProduct.get(i).getOrder()){
                    z = new Americano();
                }else if("Espresso" == listProduct.get(i).getOrder()){
                    z = new Espresso();
                }
                else if("Mocha" == listProduct.get(i).getOrder()){
                    z = new Mocha();
                }
                else if("Latte" == listProduct.get(i).getOrder()){
                    z = new Latte();
                }else if("Cappuchino" == listProduct.get(i).getOrder()){
                    z = new Cappuchino();
                }
                else if("fruit_tea" == listProduct.get(i).getOrder()){
                    z = new fruit_tea();
                }else if("Lemon_Iced_Tea" == listProduct.get(i).getOrder()){
                    z = new Lemon_Iced_Tea();
                }else if("Green_Tea" == listProduct.get(i).getOrder()){
                    z = new Cappuchino();
                }else if("Iced_Tea" == listProduct.get(i).getOrder()){
                    z = new Iced_Tea();
                }else if("Iced_Milk_Tea" == listProduct.get(i).getOrder()){
                    z = new Iced_Milk_Tea();
                }
            z = listProduct.get(i);
                     if (z.getId().equals(pId)) {
                System.out.println(z.getOrder() +" "+z.cost());
                return  z;
            }   
            i = i+1;
        }
        return  null;
      }

      public int printAll()
      {
           int i=0;                          
           System.out.println("รายการเครื่องดื่ม");
           int sum =0;
        while (i<listProduct.size()){
            Beverage z ;
            z = listProduct.get(i);
            System.out.println(z.getId()+" "+z.getOrder()+" "+z.cost());
            sum +=z.cost();
                        i = i+1;
                    }
                return sum;
        }
    }