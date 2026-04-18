import java.util.Arrays;


public class FindingShipments {
    

    public static void main(String[] args){
        int[][]  matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 5;
        System.out.println(searchShipment(matrix, target));


        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        target = 10;
        System.out.println(searchShipment(matrix, target));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        target = 1;
        System.out.println(searchShipment(matrix, target));

        matrix = new int[][]{{1, 2, 3}};
        target = 2;
        System.out.println(searchShipment(matrix, target));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        target = 9;
        System.out.println(searchShipment(matrix, target));


    }
    public static boolean searchShipment(int[][] matrix, int target){

        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        int end = (rows * columns)-1;

        while(start <= end){

            int mid = start + (end - start)/2;
            int midValue = matrix[mid / columns][mid % columns];

            if(midValue == target){
                return true;
            }else if(target > midValue){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }

        return false;
    }
}