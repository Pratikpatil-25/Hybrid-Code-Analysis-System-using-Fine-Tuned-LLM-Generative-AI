import java.util.Scanner;
public class os{
    public static void main(String[] args){
        String Question1 = "Explain any 4 Commands of Linux?";
        System.out.println(Question1);
                                        int answer=0;
        while (answer!=5) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter your choice:");
                try {
                    answer = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        continue;}
            }
            switch (answer) {
                        case 1 :
                        System.out.println("\nThe command 'ls' is used to display all the file names, including hidden ones.");
                        break;
                        case 2 :
                        System.out.println("\nThe command 'cd' stands for Change Directory");
                        System.out.println("- It allows you to move from one directory to another within the same filesystem hierarchy.\n" + "- You can use it with either absolute paths like /home/user\n"+ "(which starts at root level), \nor relative paths which start from wherever "+ "you currently are,\ne.g.,../Documents/. ");
                        break;
                        case 3 :
                        System.out.println("\nThe'mkdir' command creates a new directory inside an existing parent directory using its name as argument:\nmkdir <directory_name>");
                        break;
                        case 4 :
                        System.out.println("\nThe 'rm' command removes specified files or folders:"+ "\nrmdir [options]... DIRECTORY...\nremove [-f | --force] [--interactive | --no-preserve-root]\n[-r -R,--recursive][--help]");
                        break;
                        default:
                        System.out.println("Invalid input! Please enter valid number between 1 & 4 inclusive!");
                        break;
                        }}
                        public static void main() throws Exception{
                            
                            Menu menu=new Menu();
                            Scanner scanner= new Scanner(System.in);
                            while(!menu.isExit){
                                try{
                                    int choice = Integer.parseInt((scanner.nextLine()));
                                    if (!menu.isValidChoice(choice))
                                    throw new IllegalArgumentException("Invalid input, please enter a valid number.");
                                    throw new IllegalArgumentException("Invalid input!");
                                    switch (choice) {
                                                                                case -1:                                        menu.setExitStatus(true);                                        return;                                        return;                                        case 0:                                                                                break;
                                        case 1:                                                                                break;
                                        
                                        }
                                        }catch(NumberFormatException e){
                                            continue;} catch (IllegalArgumentException ex) {                                                System.out.println("\nPlease enter a valid integer value.");
                                                } catch (IllegalArgumentException ex) {                                                    } catch (IllegalArgumentException ex) {
                                                        System.err.println(ex.getMessage());
                                                        }}
                                                        public boolean getExitStatus(){
                                                            return this._isExited;}
                                                            private void setExitStatus(boolean flag){
                                                                _isExited =flag ;}
                                                                
                                                                class MenuOption{
                                                                    String name;
                                                                    int number;
                                                                    Runnable action;
                                                                    MenuOption(String n,int num,Runnable act){
                                                                        public MenuOption(String n,int num,Runnable act){
                                                                            public MenuOption(String n,int num,Runnable act){

                                                                                public MenuOption(String n,int num,Runnable act){
                                                                                    MenuOption(String n,int num,Runnable act){
                                                                                                                                                                                                                                                                        
                                                                


    }
    
 }









// If you are writing a multi-threaded program in Java, it is important to be aware of the possibility of deadlocks. There are several tools available to help you prevent deadlocks, such as deadlock avoidance algorithms and deadlock detection algorithms.