public class SelectionSort {

  

  public static void main(String[] args) {

    
    double[] myList = {5.0, 4.4, 1.9, 2.9, 3.4, 3.5};



    
    System.out.println("My list before sort is: ");

    printList(myList);



    
    selectionSort(myList);



    
    System.out.println();

    System.out.println("My list after sort is: ");

    printList(myList);

  }



  

  static void printList(double[] list) {

    for (int i = 0; i < list.length; i++)

      System.out.print(list[i] + "  ");

    System.out.println();

  }



  

  static void selectionSort(double[] list) {

    for (int i = list.length - 1; i >= 1; i--) {

      
      double currentMax = list[0];

      int currentMaxIndex = 0;



      for (int j = 1; j <= i; j++) {

        if (currentMax < list[j]) {

          currentMax = list[j];

          currentMaxIndex = j;

        }

      }



      
      if (currentMaxIndex != i) {

        list[currentMaxIndex] = list[i];

        list[i] = currentMax;

      }

    }

  }

}