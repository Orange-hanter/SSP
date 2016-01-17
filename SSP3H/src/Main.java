import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main
{
    public  enum Flag { c, d, u }

    public static void uniq( Flag flag, boolean caseInsensitive, String inputFileName, String outputFileName )
    {
        boolean stdInput = inputFileName.equals("");
        boolean stdOutput = outputFileName.equals("");

        try
        {
            PrintStream stream = stdOutput ? System.out : new PrintStream( new File( outputFileName ) );

            Scanner scanner;
            if( stdInput )
                scanner = new Scanner( System.in );
            else
                scanner = new Scanner( new File( inputFileName ) );
            HashMap<String, Integer> map = new HashMap<>();
            while( scanner.hasNextLine() )
            {
                String line = scanner.nextLine();
                if( stdInput && line.equals( "@exit@" ) )
                    break;
                if( caseInsensitive )
                    line = line.toLowerCase();
                map.put( line, map.getOrDefault( line, 0 ) + 1 );
            }
            for( Map.Entry<String, Integer> entry : map.entrySet() )
            {
                String string = null;
                if( flag == Flag.c ) // Перед каждой строкой выводить число повторений
                    string = "" + entry.getValue() + " " + entry.getKey();
                else if( flag == Flag.d && entry.getValue() > 1 ) // Выводить те строки, которые повторяются на входе
                    string = entry.getKey();
                else if( flag == Flag.u && entry.getValue() == 1 ) // Выводить те строки, которые не повторяются на входе
                    string = entry.getKey();

                if( string != null )
                    stream.println( string );
            }
        }
        catch( FileNotFoundException e ){System.out.print( "file not found" ); return;}
    }

    public static void main(String[] args)
    {
        if( /*args.length == 0 || */args.length > 4 )
        {
            System.out.print( "Invalid args" );
            return;
        }

        String inputFileName = "", outputFileName = "";
        boolean caseInsensitive = false, err = false, flagSet = false;
        Flag flag = Flag.u;

        for( String arg : args )
        {
            if( arg.equals( "-c" ) )
            {
                if( flagSet || inputFileName != "" ){System.out.print("Invalid args"); return;}
                flag = Flag.c;
                flagSet = true;
            }
            else if( arg.equals( "-d" ) )
            {
                if( flagSet || inputFileName != "" ){System.out.print("Invalid args"); return;}
                flag = Flag.d;
                flagSet = true;
            }
            else if( arg.equals( "-u" ) )
            {
                if( flagSet || inputFileName != "" ){System.out.print("Invalid args"); return;}
                flag = Flag.u;
                flagSet = true;
            }
            else if( arg.equals( "-i" ) )
            {
                if( inputFileName != "" ){System.out.print("Invalid args"); return;}
                caseInsensitive = true;
            }
            else
            {
                if( inputFileName == "" )
                    inputFileName = arg;
                else if( outputFileName == "" )
                    outputFileName = arg;
                else{System.out.print("Invalid args"); return;}
            }
        }
        uniq(flag, caseInsensitive, inputFileName, outputFileName);
    }
}
