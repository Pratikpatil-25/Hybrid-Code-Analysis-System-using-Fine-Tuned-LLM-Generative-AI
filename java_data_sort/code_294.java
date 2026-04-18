public class ContactsDB
{
    public static String[]  contactNames = new String[10];
    public static long[]    phoneNumbers = new long[10];
    public static int entries = 0;

    public static void printArrays()
    {	
		    }
    public static boolean isFull()
    {
		    }
    public static void addEntry(String name, long number)
    {
            }

    public static String findName(long number)
    {
            }

    public static void sortByName()
    {
                    }

    public static void sortByNumber()
    {
            }

    public static String superFindName(long number)
    {
		    }

    public static boolean isSorted()
    {           return true;
    }

    public static void main(String[] args)
    {
        System.out.println("Populating arrays...");
        addEntry("Mick", 19672022);
        addEntry("Peter", 19671970);
        addEntry("Jeremy", 19671971);
        addEntry("John", 19972022);
        addEntry("Christine", 19702022);
        addEntry("Dave", 19721973);
        addEntry("Lindsey", 19742018);
        addEntry("Stevie", 19742922);
        addEntry("Bekka", 19931995);
        addEntry("Neil", 20182022);
        addEntry("Guy", 20202022);	
        System.out.println("\nOriginal arrays");
        printArrays();
        System.out.println("\nArrays sorted by name");
        sortByName();
        printArrays(); System.out.println();
        System.out.println( "Testing findName(19672022) [Mick] : "
                + findName(19672022));
        System.out.println( "Testing findName(19931995) [Bekka] : "
                + findName(19931995));
        System.out.println( "Testing findName(19702022) [Christine] : "
                + findName(19702022));
        System.out.println( "Testing findName(123456789) [New number] : "
                + findName(123456789));
        System.out.println();
        System.out.println( "Testing superFindName(19972022) [John] : "
                + superFindName(19972022));
        System.out.println( "Testing superFindName(19742922) [Stevie] : "
                + superFindName(19742922));
        System.out.println( "Testing superFindName(19742018) [Lindsey] : "
                + superFindName(19742018));
        System.out.println( "Testing superFindName(987654321) [New number] : "
                + superFindName(987654321));
        System.out.println("\nArrays after using superFindName (sorted by number)");
        printArrays();
    }

}