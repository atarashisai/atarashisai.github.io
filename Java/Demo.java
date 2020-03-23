/*
keywords: native, strictfp -- advanced topic, not covered
Classes: String, Integer, Double
*/


/* keyword: package */
package main;
/* keyword: import */
import java.util.*; // import everything in util
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* extends, implements */
public class Demo extends Object implements Serializable
{
    //Object is the default supper class of every class.
    //Serializable is required to have for ObjectI/OStream.
    private static final long serialVersionUID = 4232208634313834910L;

    /* program entry */
    static public void main(String[] arg)
    {
        Demo demo = new Demo();
        demo.keyword_try();
        demo.overload();
        demo.overload(1.2);
        demo.overload(1);
        demo.keyword_if(9);
        demo.keyword_switch('Y');
        //demo.error();
        demo.array();
        Demo.keyword_static();
        demo.hashTable();
        demo.hashMap();
        demo.hashSet();
        demo.thread();
        demo.nested_class();
        demo.shadowed_class();
        demo.objectIOstream("objectIOtest.txt");
        demo.fileRW("fileRWtest.txt", "Hello FileReader!");
        demo.bufferedRW("fileRWtest.txt", "Hello BufferedReader!");
        demo.keyword_super();
        demo.arrays(new int[] {5, 3, 4, 5, 1, 2, 5, 2});
        demo.keyword_enum(State.C);
        demo.generic_function(6);
        demo.varargs("int", 1, 1, 2, 3, 5, 8);
        //demo.socket();
        demo.tcp();
    }

    /*
    static final (constant)
    ======
    The order of "static, final, public" does not matter.
    */
    public static final int CONST_K = 0;
    public final static int CONST_C = 1;
    static final public int CONST_D = 2;

    /* static function */
    static void keyword_static()
    {
        //static can be called without instantiating
        Demo.StaticClass.static_field = "This is a static function";
        System.out.println(Demo.StaticClass.static_field);
        //Instantiate a static inner class.
        Demo.StaticClass obj = new Demo.StaticClass();
    }

    /* static class */
    static class StaticClass
    {
        // Global variable
        static String static_field;
    }

    // field variable
    /* public, private, protected, and friendly */
    // Only one modifier, public, private, or protected, is allowed.
    // none (friendly): this field/method can be accessed from any class in the same package.
    // public: can be accessed from anywhere.
    // private: can only be accessed only in this class.
    // (private field variables/functions are not inhered, so subclasses cannot access private part also)
    // protected: can be accessed in this class and subclasses.
    int field_frendly = 0;
    public int field_public = 1;
    private int field_private = 2;
    protected int field_protected = 3;


    /* volatile */
    public static volatile int var_volatile = 0; // volatile can only apply to field variable.

    /* transient */
    public transient int var_transient = 4; // transient can only apply to field variable.
    transient public int var = 5; // order does not matter.

    /* Constructor */
    public Demo()   // function name must be same as the class name
    {

    }

    // This is not a contractor
    public void Demo()
    {

    }

    /* overloading */
    void overload()
    {
        System.out.println("overload() is called");
    }
    void overload(int a)
    {
        System.out.println("overload(int a) is called");
    }
    void overload(double a)
    {
        System.out.println("overload(double a) is called");
    }
    //Same method name, different number/type of parameters. Do not consider return value.

    /* primitive data type */
    void primitive()
    {
        byte    var_byte   = 1;
        char    var_char   = 'a';
        int     var_int    = 1;
        long    var_long   = 1L;   // Integer is short type by default if the OS is 32bits.
        short   var_short  = 1;
        float   var_float  = 1.1f; // Decimal is double type by default.
        double  var_double = 1.1;
        boolean var_boolean = true; // Boolean can only be "true/false".
        // Primitive data types, except for boolean and char, are signed.
        // Java doesn't have unsigned number.
    }

    /* if ... else if ... else */
    void keyword_if(int var)
    {
        if (var > 0)
        {
            System.out.println(var + " is a positive number.");
        }
        else if (var < 0)
        {
            System.out.println(var + " is a negative number.");
        }
        else
        {
            System.out.println(var + " is zero.");
        }
    }

    /* switch case break default */
    void keyword_switch(char var)
    {
        switch (var)
        {
        case 'Y':
        case 'y':
            System.out.println("Y/y is entered");
            break;
        case 'N':
        case 'n':
            System.out.println("N/n is entered");
            break;
        default:
            System.out.println("This function only accepts 'y'/'n'.");
            System.out.println("Other character: " + var);
        }
    }

    /* while loop */
    void keyword_while(int var)
    {
        while (var > 0)
        {
            var--;
            System.out.println("> " + var);
        }
    }

    /* do while loop: will execute at least 1 time*/
    void keyword_while(boolean var)
    {
        do
        {
            System.out.println("The condition is " + var);
            var = false;
        }
        while (var);
    }

    /* for loop */
    void keyword_for(int size)
    {
        int var_inc, var_dec;
        // var_inc increases by 1 while var_dec decreases by 1.
        for (var_inc = 0, var_dec = size; var_inc <= size; var_inc++, var_dec--)
        {
            if (var_inc == var_dec)
            {
                continue;
            }
            else if (var_inc / 2 == var_dec)
            {
                break;
            }
            else
            {
                /* print, printf, println */
                System.out.print("> ");
                System.out.printf("inc = %d, dec = %d", var_inc, var_dec);
                System.out.println(";");
                // print doesn't add a new line to the end. It prints out what the string is.
                // printf is used to format the output.
                // println add a new line to the end automatically.
            }
        }
    }

    /* goto */
    void keyword_goto()
    {
        // This keyword is preserved but not used.
    }

    /* const */
    void keyword_const()
    {
        // This keyword is preserved but not used.
    }

    /* assert */
    void keyword_assert(int var)
    {
        //No effect unless the program is running with "java -ea ProgramName"
        //Parameter must be boolean type (true/false).
        assert(var == 0);
    }

    /* return */
    int keyword_return(int var)
    {
        return var;
    }

    /* new */
    Object keyword_new()
    {
        return new Object();
    }

    /* this */
    void keyword_this()
    {
        int var = 10;
        this.var = 20;
        System.out.printf(" local_var = %d\nglobal_var = %d\n", var, this.var);
    }

    /* instanceof */
    void keyword_instanceof()
    {
        Object obj = new Child();
        if (obj instanceof Parent)
        {
            System.out.println("obj is an instance of Parent");
        }
        if (obj instanceof Child)
        {
            System.out.println("obj is an instance of Child");
        } // Both are true because Child is a subclass of Parent.
        if (obj instanceof Demo)
        {
            System.out.println("obj is an instance of Demo");
        } // False
    }

    /* try, catch, finally */
    void keyword_try()
    {
        int arr[] = new int[3]; //array
        System.out.println("array 1: " + Arrays.toString(arr));
        try
        {
            arr[3] = 10; // 0, 1, 2, 3: Indexing is out of range.
            System.out.println("array 2: " + Arrays.toString(arr)); //Never executed
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
            // Error message is handled in an other thread so that
            // sometimes printStackTrace() happens first
            // sometimes println("Error handling") happens first.
            System.out.println("Error is caused on purpose");
        }
        finally
        {
            arr = new int[4];
            System.out.println("array 3: " + Arrays.toString(arr));
        }
    }
    /* synchronized */
    synchronized void keyword_synchronized()
    {
        //This is a synchronized method
        //When a thread is calling this function, no other thread can also call this function.
    }

    void keyword_synchronized(Object obj)
    {
        synchronized(obj)   //The parameter must be an object. It can be this.
        {
            //This is a synchronized block
            //The advantage of using synchronized block is
            //the programmer can choose which object to lock.
        }
    }
    void keyword_super()
    {
        Child obj = new Child();
        obj.override();
    }
    /* throws, throw, Error, Exception */
    public void error()
    {
        throw new Error("\n An error is caused on purpose\n");
    }
    public void exception() throws Exception
    {
        throw new Exception("\n An exception is caused on purpose\n");
    }
    // The difference between throw Error and throw Exception is that
    // the key word "throws" is required when throwing an exception.
    // The reason behind is programmers should handle the exceptions whenever they occur.
    // Errors are usually caused by hardware or virtual machine where programmers have no way to handle.
    // Therefore exceptions should be thrown, caught, and handled,
    // but errors should cause immediate exit.

    /* fixed size array */
    public void array()
    {
        long[] arr1 = new long[3]; // Elements are 0 by default.
        System.out.println("array 1: " + Arrays.toString(arr1)); //Print an array in readable form.

        arr1[0] = 10L;
        arr1[1] = 20L;
        arr1[2] = 30L;
        System.out.println("array 2: " + Arrays.toString(arr1));

        long[] arr2 = {0, 1, 2};
        // Unlike C/C++, the size in java is automatically calculated.
        // short can be assigned to long without explicitly casting.
        System.out.println("array 3: " + Arrays.toString(arr2));

        // In C, Programmer can only use this way to initialize array.
        // However, in Java programmer can do this:
        arr1 = new long[] {4, 5, 6, 7, 8, 9}; //Resize
        arr2 = new long[6];
        System.out.println("array 4: " + Arrays.toString(arr1));
        System.out.println("array 5: " + Arrays.toString(arr2));

        // Object array with initialization:
        Demo arr3[] =   //[] can be placed on either before or after the variable.
        {
            new Demo(), new Demo(), new Demo()
        };// The initialization can be placed within a { }.
        System.out.println("array 6: " + Arrays.toString(arr3));
        arr3 = new Demo[3]; // Rewrite the array. Elements are null(0) by default!!!
        System.out.println("array 7: " + Arrays.toString(arr2));

    }

    /* type casting */
    public void casting()
    {
        /* casting between primitive data */
        long var_long;
        short var_short = 20;
        var_long = (long) var_short; // short to long -- OK; long to short -- NO, it is not allow

        /* casting between class */
        Object obj = new Child();//"Object" is the supper class of every class.
        Child c = (Child) obj;
        Parent f = (Parent) obj;// Child to parent -- OK; Parent to child -- No.
        f = c; // Directly cast from child to parent.
    }

    /* nested class/inner class */
    void nested_class()
    {
        // Because class Temp is not static class,
        // it is not allowed to use "new Piece.Temp()" to create new object.
        Task p = new Task("");
        Task.Temp tmp1 = p.new Temp();
        // Or in short:
        Task.Temp tmp2 = new Task("").new Temp();
    }
    /* shadowed class/singleton */
    void shadowed_class()
    {
        Object obj1 = new Object();
        Object obj2 = new Object()
        {
            @Override
            public String toString()
            {
                return "Demo.var = " + Demo.this.var;
            }
        };
        System.out.println(obj1);
        System.out.println(obj2);

    }

    /* final function */
    public final void final_function()
    {
        // final function cannot be overridden.
    }

    // String can be converted from all primitive type and even Object
    // The same method is used to convert string to primitive type
    void valueOf()
    {
        int var_int = 10;
        String str;
        str = String.valueOf(var_int);
        System.out.println(str);

        Object var_obj = new Object();
        str = String.valueOf(var_obj);
        System.out.println(str);

        str = "988";
        var_int = Integer.valueOf(str);
        System.out.println(var_int);

        /* Table of Available valueOf()
         * [to\from] String Object int    short  long   byte   char   float  double boolean
         * ---------------------------------------------------------------------------------
         * String    X      O      O      X      O      X      O      O      O      O
         * ---------------------------------------------------------------------------------
         * Integer   O      X      O      X      X      X      X      X      X      X
         * Short     O      X      X      O      X      X      X      X      X      X
         * Long      O      X      X      X      O      X      X      X      X      X
         * Byte      O      X      X      X      X      O      X      X      X      X
         * Character X      X      X      X      X      X      O      X      X      X
         * Float     O      X      X      X      X      X      X      O      X      X
         * Double    O      X      X      X      X      X      X      X      O      X
         * Boolean   O      X      X      X      X      X      X      X      X      O
         *
         * The use of String.valueOf(char[]) should be avoided.
         * char[] arr = new char[5];
         * arr[0] = 'h';
         * arr[1] = 'i';
         * System.out.println(String.valueOf(arr)); // The actual print out is hi[][][]
         * This error is found in jdk-8u5 on windows 8.1
         * There is something wrong in lower implementation.
         *
         * */
    }

    /* enum */
    public enum State
    {
        A,
        B,
        C
    }
    void keyword_enum(State state)
    {
        State next = null;
        switch(state)
        {
        case A:
            next = State.B;
            break;
        case B:
            next = State.C;
            break;
        case C:
            next = State.A;
            break;
        default:
            System.out.println("This function only accepts tree states(State.A, State.B, State.C).");
            break;
        }
        System.out.println("next state is " + next);
    }
    /* Generic Function */
    <T> void generic_function(T obj)
    {
        System.out.println(obj.getClass());
    }
    /* Generic Class */
    class Generic_Class<T>
    {

    }
    /* Varargs */
    void varargs(String str, int ... input)
    {
        //The type of input is int[]
        //This function can accept multiple arguments
        //for example: varargs("int", 1,2,3,4) or varargs("int", 1,2)
        //The variable arguments should be placed at the end
        for (int i = 0; i < input.length; i++)
        {
            System.out.println(str + input[i]);
        }
    }
    /* Interface */
    public interface Interface
    {
        /* variable inside interface */
        public int CONST_1 = 0; // This is "static final" by default.
        public static int CONST_2 = 1;
        public final int CONST_3 = 2;
        public final static int CONST_4 = 3;
        //They all mean the same thing.
        //Only "static final" variable is allowed to define in interface.

        /* methods inside interface are automatically abstract */
        public abstract void foo();
        public void interface_function();
        // Only declaration, no definition.
    }

    public interface Family extends Interface
    {
        // Interface also allow to have inheritance.
    }

    public interface Species
    {

    }

    /* abstract */
    // The order of modifier does not matter: private abstract/abstract private
    private abstract class Parent
    {
        public Parent(String var_name)
        {
            System.out.printf("Parent(String var_name=%s) is called\n", var_name);
        }
        // Even though abstract class can have constructor, but abstract class cannot be instantiated.

        protected void override()
        {
            System.out.println("Function called from super class.");
        }
        public abstract int abstract_function();

        public String toString()
        {
            return "abstract supper class";
        }
    }

    /* extends (inheritance) */
    // Inheritance in java allow only at most 1 supper class and any number of interfaces.
    private class Child extends Parent implements Family, Species
    {
        public Child(String var_name)
        {
            /* super 1 */
            super(var_name); // Call the constructor from supper class.
        }
        public Child()
        {
            super("no-name");
        }
        // A class can have multiple constructors.

        /* override */
        @Override //Annotation. It is used as comment and does nothing.
        public void override()
        {
            // override is what
            // a function is already defined in supper class,
            // but it is re-implemented in child class.

            /* super 2 */
            super.override(); // Call a function from supper class. This function can be overridden.
        }


        @Override
        public void foo()
        {
            // Functions defined in interface are all abstract.
        }

        @Override
        public void interface_function()
        {
            // Functions defined in interface must be implemented.
        }

        @Override
        public int abstract_function()
        {
            //abstract functions must be implemented in non-abstract class.
            return 0;
        }

        // Functions from interface and abstract super class must be overridden.
        // Other functions are optional to override.
        @Override
        public String toString()
        {
            return "Subclass";
        }
    }
    /* DataInputStream, DataOuputStream, FileInputStream, and FileOutputStream */
    void dataIOstream(String filename)
    {

        try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBoolean(true);
            dos.writeChar('a');
            dos.writeByte(1);
            dos.writeFloat(1.12f);
            dos.writeDouble(2.24);
            dos.writeInt(16);
            dos.writeShort(32);
            dos.writeLong(64);
            dos.writeUTF("Hello World");
            dos.writeChars("bcd"); //This is not a string. There is no equivalent method in DataInputStream
            dos.close();

            FileInputStream fis = new FileInputStream(filename);
            DataInputStream dis = new DataInputStream(fis);
            boolean var_boolean = dis.readBoolean();
            char var_char = dis.readChar();
            byte var_byte = dis.readByte();
            float var_float = dis.readFloat();
            double var_double = dis.readDouble();
            int var_int = dis.readInt();
            int var_short = dis.readShort();
            long var_long = dis.readLong();
            String var_str = dis.readUTF();
            byte[] content = new byte[dis.available()];
            dis.read(content);
            String var_end = new String(content);
            dis.close();

            // Test
            System.out.printf("boolean = %s\nchar = %s\nbyte = %s\ndouble = %s\n",
                              var_boolean, var_char, var_byte, var_double
                             );
            System.out.printf("short = %s\nint = %s\nlong = %s\nstring = %s\n",
                              var_short, var_int, var_long, var_str
                             );
            System.out.printf("float = %s\nend = %s\n",
                              var_float, var_end
                             );
        }
        catch (FileNotFoundException e)
        {
            System.out.printf("Error: \"%s\" does not exit.\n", filename);
        }
        catch (IOException e)
        {
            System.out.println("Unable to write/read data.");
            e.printStackTrace();
        }

    }
    /* ObjectInputStream, ObjectOutputStream*/
    void objectIOstream(String filename)
    {
        // Object must "implements Serializable" for ObjectI/O
        try
        {
            tmp.var_trans = 100; //Set original transient variable to 100
            System.out.println("(Before) var = " + this.tmp.var_trans);
            System.out.println("(Before) field = " + this.tmp.field);
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();

            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Demo demo = (Demo) ois.readObject();
            ois.close();

            System.out.println("(After ) var = " + demo.tmp.var_trans); //transient variables become 0
            System.out.println("(After ) field = " + demo.tmp.field); //non-transient variables remain
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    //This object is used to test serializing inner class.
    Task.Temp tmp = new Task("").new Temp();

    /* FileWriter, FileReader */
    void fileRW(String filename, String content)
    {
        //Abstract file descriptor
        //Will create an empty file if file is missing.
        File file = new File(filename);
        try
        {
            FileWriter fw = new FileWriter(file);
            fw.write('H');//One char header used to test read()
            fw.write(content);
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileReader fr = new FileReader(filename);
            char header = (char)fr.read();
            //char[] buffer. The bad thing is it may be too big/too small.
            char buffer[] = new char[255];
            fr.read(buffer);
            fr.close();
            System.out.println("header = " + header + "\ncontent = " + String.valueOf(buffer));
            // Will not automatically create a file so FileNotFoundException may occur.
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /* BufferedWriter, BufferedReader */
    void bufferedRW(String filename, String content)
    {
        //Abstract file descriptor
        //Will create an empty file if file is missing.
        File file = new File(filename);
        try
        {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw); // Construct BufferedWriter from FileWriter
            bw.write("HEAD"); // 4 chars header used to tested readLine().
            // BufferedWriter is almost identical to FileWriter.
            bw.newLine();  // The only different is BufferedWriter provide newLine() method
            // which is used as separator.
            bw.write(content);
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            // Instead of use char, it is more convenient to use String in bufferedReader.
            String header = br.readLine();
            String buffer = br.readLine();
            fr.close();
            System.out.println("header = " + header + "\ncontent = " + buffer);
            // Will not automatically create a file so FileNotFoundException may occur.
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    void hashTable()
    {
        // Hashtable
        //1. is synchronized
        //2. does not allow null
        //3. guarantees the order of elements
        //4. implements Map
        //5. extends Dictionary
        //6. is capable to collection framework but has different standard
        //7. is replaced by ConcurrentHashMap

        Hashtable<Integer, Demo> table = new Hashtable<Integer, Demo>();
        Demo obj = new Demo();
        table.put(1, obj);
        table.put(2, obj);
        //table.put(3, null);
        // Hashtable does not allows null elements.
        table.get(2);
        System.out.println("Table: Size = " + table.size());
    }

    void hashMap()
    {
        // HashMap
        //1. is not synchronized
        //2. allows null
        //3. does not guarantee the order
        //4. implements Map
        //5. extends AbstractMap
        //6. is part of collection framework

        // Can't use int here. Generic parameters must be Class names
        HashMap<Integer, Demo> map = new HashMap<Integer, Demo>();
        Demo obj = new Demo();
        map.put(1, obj);
        map.put(2, obj);
        map.put(3, null);// HashMap allows null elements
        map.get(2);
        System.out.println("Map: Size = " + map.size());
        // Because the same object can have the different index,
        // duplicated object is allowed to store in HashMap.
    }

    void hashSet()
    {
        //HashSet
        //1. is a wrapper of HashMap (internally use HashMap)
        //2. implements Set

        // HashSet is same as HashMap except the key is automatically assigned as hashcode
        HashSet<Demo> set = new HashSet<Demo>();
        Demo obj = new Demo();
        set.add(obj);
        set.add(obj);
        set.add(null);//HashSet also allows null elements
        System.out.println("Set: Size = " + set.size());
        // Because the same object has the same hashcode,
        // there is no duplicated object stored in HashSet.
    }

    void vector()
    {
        //Vector
        //1. is synchronized
        //2. is part of collection framework
        //3. increases size by doubling
        //4. is slower than arrayList
        //5. is good for searching but bad for inserting new elements
        //6. implements Iterable, Collection, List, RandomAccess
        //7. uses array internally

    }
    void arrayList()
    {
        //ArrayList
        //1. is not synchronized
        //2. is part of collection framework
        //3. increases size by growing 50%+1
        //4. is faster than Vector
        //5. is good for searching but bad for inserting new elements
        //6. implements Iterable, Collection, List, RandomAccess
        //7. uses array internally

    }
    void linkedList()
    {
        //LinkedList
        //1. is not synchronized
        //2. is part of collection framework
        //3. increases size by 1
        //5. is good for inserting new elements but bad for searching
        //6. implements Iterable, Collection, List, Queue, Deque
        //7. uses linked list internally

    }
    void thread()
    {
        System.out.println(Thread.currentThread().getName() + " Begin");
        Thread th_a = new Thread(new Task("B"));
        Thread th_b = new SubThread("A");// SubThread is derived from Thread
        th_a.start();
        th_b.start();
        System.out.println(Thread.currentThread().getName() + " Terminate");
        try
        {
            th_a.join();
            th_b.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    // Must implements Runnable interface for threading
    class Task implements Runnable, Serializable
    {
        private String name;
        public Task(String name)
        {
            this.name = name;
        }
        @Override
        public void run()
        {
            System.out.println(name + " Start");
            for(int i = 0; i < 10; ++i)
            {
                System.out.println("> " + i + " " + name);
                try
                {
                    Thread.sleep((int) (Math.random() * 10));
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println(name + " Terminate");
        }
        class Temp implements Serializable
        {
            transient int var_trans = 20;
            int field = 30;
        }
    }
    // Another way to do threading is extending Thread class
    class SubThread extends Thread
    {
        public SubThread(String name)
        {
            super(name);
        }
        @Override
        public void run()
        {
            System.out.println(getName() + " Start");
            for(int i = 0; i < 5; ++i)
            {
                System.out.println("> " + i + " " + getName());
                try
                {
                    sleep((int) (Math.random() * 10));
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println(getName() + " Terminate");
        }
    }
    /* Socket */
    void socket()
    {
        // Start a server and a client
        TCPServer server = new TCPServer();
        Thread client = new Thread(new TCPClient());
        server.start();
        client.start();
        new Thread(new TCPServer()).start();
        new Thread(new TCPClient()).start();
        try
        {
            client.join();
            //wait for 4000ms to see the time out effect
            Thread.sleep(4000);
            //close the server and wait for its tasks finish.
            server.close();
            server.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    /* TCP
     * TCP setup a stable and permanent connection between client and server. */
    void tcp()
    {
        // Start a server
        TCPServer server = new TCPServer()
        {
            public void handle(Socket socket)
            {
                try
                {
                    BufferedReader net_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //PrintWriter gives abilities to handle a line of string
                    PrintWriter net_ex = new PrintWriter(socket.getOutputStream(), true);
                    String line;
                    while( !"bye".equals(line = net_in.readLine()) )
                    {
                        //An echo server send the same thing back to client
                        net_ex.println("Server received \"" + line + "\" from client (" + getName() + ").");
                    }
                    //A message that contains a keyword "bye" is used to tell the client to end connection.
                    net_ex.println("bye");
                    net_ex.close();
                    net_in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        };
        // Start a client
        Thread client = new Thread(new TCPClient()
        {
            public void handle(Socket socket)
            {
                try
                {
                    // Create I/O port for the client
                    PrintWriter    net_ex = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader net_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // Wait for user input
                    String result;
                    do
                    {
                        System.out.println("> ");
                        BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
                        // Send signal from terminal to server
                        net_ex.println(terminal.readLine());
                        net_ex.flush(); //flush method forces the buffer to be written out
                        // Get response from server
                        System.out.println("Server say : " + (result = net_in.readLine()));
                    }
                    while(result.indexOf("bye") == -1);
                    net_in.close();
                    net_ex.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        server.start();
        client.start();
        try
        {
            client.join();
            //wait for 4000ms to see the time out effect
            Thread.sleep(4000);
            //close the server and wait for its tasks finish.
            server.close();
            server.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    class TCPServer extends Thread
    {
        private ServerSocket serverSocket;
        private final static int port = 8000, maxConnexion = 3;
        private final static int timeout = 2000;
        private boolean running;
        public TCPServer()
        {
            running = true;
            try  //Open a server and setup its port number, max connection and time out period.
            {
                serverSocket = new ServerSocket(port, maxConnexion);
                serverSocket.setSoTimeout(timeout);
            }
            catch (IOException e)
            {
                System.out.println("Unable to start a server.");
                running = false;
            }
        }
        @Override
        public void run()
        {
            Socket socket = null;
            while(running)
            {
                System.out.println("Server is running");
                try
                {
                    //.accept() method pulls out a request from the queue
                    socket = serverSocket.accept();
                    if (socket != null) handle(socket);
                }
                catch (SocketTimeoutException e)
                {
                    System.out.println("Connexion time out");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    //Close the connection
                    if (socket != null)
                        try
                        {
                            socket.close();
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                }
            }
            //If the server is closed, close the socket
            try
            {
                if (serverSocket != null) serverSocket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("Server closed");
        }
        public void handle(Socket socket)
        {
            System.out.println("Accepted from " + socket.getInetAddress() + ":" + socket.getPort());
            //Start a new thread to handle an execution
            new SubThread(socket.getInetAddress() + ":" + socket.getPort()).start();
        }
        public void close()
        {
            running = false;
        }

    }
    class TCPClient implements Runnable
    {
        final static String host = "localhost";
        final static int port = 8000;
        @Override
        public void run()
        {
            Socket socket = null;
            try
            {
                socket = new Socket(host, port);
                handle(socket);
            }
            catch (UnknownHostException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if (socket != null) socket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Connection closed");
            }
        }
        public void handle(Socket socket)
        {

        }
    }
    /* Arrays */
    void arrays(int[] array)
    {
        /* toString */
        //also use deepToString for Object[].
        System.out.println("(original)" + Arrays.toString(array));
        /* copyOfRange */
        int[] copy = Arrays.copyOfRange(array, 2, 4);
        System.out.println("(copy from 2-4)" + Arrays.toString(copy));
        /* copyOf */
        copy = Arrays.copyOf(copy, copy.length * 2);
        System.out.println("(copy)" + Arrays.toString(copy));
        /* fill */
        Arrays.fill(copy, 8);
        System.out.println("(fill)" + Arrays.toString(copy));
        /* equals */
        //also use deepEquals for Object[].
        boolean eq = Arrays.equals(copy, new int[] {8, 8, 8, 8});
        System.out.println("(equals to [8,8,8,8])" + eq);
        /* hashCode */
        //also use deepHashCode for Object[].
        int hashcode = Arrays.hashCode(array);
        System.out.println("(hash code before sort)" + hashcode);
        /* sort */
        Arrays.sort(array);
        System.out.println("(sort)" + Arrays.toString(array));
        /* binarySearch (used only on sorted array) */
        int index = Arrays.binarySearch(array, 0, array.length, 1);
        System.out.println("(search for 1)index = " + index);

        hashcode = Arrays.hashCode(array);
        System.out.println("(hash code  after sort)" + hashcode);
        /* asList */
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 5);
        System.out.println("(asList)" + list);
    }
    /* split */
    void string_split()
    {
        String str = "//immoral :û���µ�///a/572///";
        String[] token = str.split("/");
        System.out.println(Arrays.toString(token));
    }
}