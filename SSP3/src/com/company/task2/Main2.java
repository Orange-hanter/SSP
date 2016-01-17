package com.company.task2;

import java.io.*;
import java.util.Scanner;

/**
 * Created by rushmash on 12/27/15.
 */
public class Main2 {

    public static void main(String[] args) throws Exception {
        PrintStream out = System.out;
        Scanner in = new Scanner(System.in);
        Integer ii = 0, ll = 0, nn = 0;

        for(int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    ii = Integer.parseInt(args[i+1]);
                    i++;
                    break;
                case "-l":
                    ll = Integer.parseInt(args[i+1]);
                    i++;
                    break;
                case "-n":
                    nn = Integer.parseInt(args[i+1].substring(0,args[i+1].length() -1 ));
                    i++;
                    break;
                case "-":
                    break;
                default:
                    in = new Scanner(new File(args[i]));
                    break;
            }
        }

        Integer index = 0, empyLines = 0;
        while(in.hasNext()) {
            String line = in.nextLine() + "\n";
            index++;
            if (line.equals("\n")) {
                empyLines++;
                if (empyLines == ll) {
                    index-=ll;
                    empyLines = 0;
                }
            } else {
                if (index % ii == 0) {
                    out.append(String.format("%" + nn + "d", index) + line );
                    continue;
                }
            }
            out.append(String.format("%" + nn + "s", " ") + line);
        }
    }
}
