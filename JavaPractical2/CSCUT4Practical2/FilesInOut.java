import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FilesInOut {

    public static void main(String[] args) {
        // Check that the arguments are valid and store values for parsing.
        String[] tags = checkArguments(args);
        String flag = "", input, output;
        // Check that the length of the arguments is at the minimum number.
        if (tags.length == 2) {
            // Assume the input file to be the first value.
            input = tags[0];
            // Assume the output file to be the second value.
            output = tags[1];
            // Check if either input or output incorrectly contain a flag.
            if (input.matches("-+.")||output.matches("-+.")) {
                System.out.println("Invalid flag and file combination.\nFormat should be: [-htu] [input] [output]");
                System.exit(0);
            }
        } else {
            // Assume the flag is the first value, input is the second and the output is the third.
            flag = tags[0];
            input = tags[1];
            output = tags[2];
            // Check if either input or output incorrectly contain a flag.
            if (input.matches("-+.")||output.matches("-+.")) {
                System.out.println("Invalid flag and file combination.\nFormat should be: [-htu] [input] [output]");
                System.exit(0);
            }
        }

        // Read the input file and write to the output file in an optionally given format.
        readAndWrite(flag,input,output);
    } // main

    /**
     * This method will read an input file and write to an output file in an optionally given format (flag),
     * if no flag is given the Title Case is assumed.
     * @param flag is the optional format to put the output file in.
     * @param input is the name of the file to read.
     * @param output is the name of the desired output file.
     */
    private static void readAndWrite(String flag, String input, String output) {
        // Initialise the variable data.
        String data = "";
        // Check if the flag is set to HTML mode.
        if (flag.compareTo("-h") == 0) {
            // Replace the extension of the given file with .html
            output = output.replaceAll("\\..+", ".html");
            // Set the base html into data, ready for formatting.
            data = "<head>\n" +
                    "<style>\n" +
                    "table, th, td {\n" +
                    "  border: 1px solid black;\n" +
                    "  padding: 7px;" +
                    "}\n" +
                    "</style>\n" +
                    "</head>" +
                    "<table style=\"background-color:#b488f2\">" +
                    "\n<tr><th>Name</th><th>Birthday</th></tr>" +
                    "%s</table>";
        }

        // Try to read the input file.
        try {
            File inputFile = new File(input);
            Scanner scan = new Scanner(inputFile);
            // Used to convert dates into the correct format.
            SimpleDateFormat string = new SimpleDateFormat("ddMMyyyy");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dateToParse;

            // Iterate through the input file and read in each line.
            while (scan.hasNextLine()) {
                String contents = scan.nextLine();
                // Find the date and store it.
                String date = contents.replaceAll("[^0-9]", "");
                // Check that the date is valid, if not an exception will be thrown.
                dateToParse = string.parse(date);
                // Find the name and store it.
                String name = contents.replaceAll("[^a-zA-Z]", " ");
                // Check the state of the flag and fulfil its requirements.
                if (flag.compareTo("-u") == 0) {
                    // Upper case flag, so set name to UPPER CASE.
                    data += fullNameToUpperCase(name) + "\t" + simpleDateFormat.format(dateToParse) + "\n";
                } else if (flag.compareTo("-h") == 0) {
                    // HTML flag, so set data into html format.
                    data = data.replace("%s", ("\n<tr><td>" + toTitleCase(name.replaceAll("  +", "")) + "</td><td>" + simpleDateFormat.format(dateToParse) + "</td></tr>%s"));
                } else {
                    // Otherwise set name to Title Case.
                    data += toTitleCase(name) + "\t" + simpleDateFormat.format(dateToParse) + "\n";
                }
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

        // Replace any trailing format marks with empty space, as full file has been read so nothing is left to format.
        data = data.replaceAll("%s", "");

        // Try to write to the given output file.
        try {
            PrintWriter printWriter = new PrintWriter(output);
            printWriter.write(data);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method checks that the arguments passed to it are valid, and will continue to ask the user
     * for valid arguments until they are correctly supplied.
     * @param arguments are the command line arguments passed to the main method.
     * @return a string array of input and output (and optional flag).
     */
    private static String[] checkArguments(String[] arguments) {
        // Initialise the desired variables.
        String input = "", output = "", flag = "";
        // Check that the correct number of minimum arguments are passed.
        if (arguments.length < 2) {
            // Let the user know that they provided insufficient arguments.
            System.out.println("Make sure you have included arguments.");

            // Iterate until valid arguments are supplied.
            boolean noFiles = true;
            while (noFiles) {
                try {
                    // Get the input file name.
                    System.out.println("Enter input file:\t");
                    Scanner scanner = new Scanner(System.in);
                    String inputFileName = scanner.next();
                    // Check that the file does not exist or is not a directory.
                    File inputFile = new File(inputFileName);
                    if (!inputFile.exists() || inputFile.isDirectory()) {
                        throw new FileNotFoundException();
                    }
                    // Store the input file name as a valid input file.
                    input = inputFileName;
                    // Get the output file name.
                    System.out.println("Enter output file:\t");
                    String outputFileName = scanner.next();
                    // Check if the file already exists or is a directory.
                    File outputFile = new File(outputFileName);
                    if (outputFile.exists() || outputFile.isDirectory()) {
                        throw new FileAlreadyExistsException(outputFileName);
                    }
                    // Store the output file name as a valid output file.
                    output = outputFileName;
                    // Get the desired format of the output file.
                    System.out.println("Which format do you want?\nHTML[h] or Titlecase[t] or Uppercase[u]:\t");
                    String checkFlag = scanner.next().toUpperCase();
                    // Check that the format flag is valid.
                    if (checkFlag.compareTo("U") == 0) {
                        flag = "-u";
                    } else if (checkFlag.compareTo("H") == 0) {
                        flag = "-h";
                    } else if (checkFlag.matches("[^HTU]")) {
                        throw new NoSuchElementException();
                    }
                    // Since no errors have been thrown, we now have all valid values, hence iteration can stop.
                    noFiles = false;
                } catch (FileNotFoundException e) {
                    System.out.println("Please provide a valid file name.");
                } catch (FileAlreadyExistsException e) {
                    System.out.println("This file already exists, please try another output name.");
                } catch (NoSuchElementException e) {
                    System.out.println("That flag is invalid.");
                }
            }
            // Return the valid values in a string array.
            return new String[] {flag,input,output};
        } else if (arguments.length == 2) {
            // If just 2 arguments are supplied, assume that neither contain a flag.
            input = arguments[0];
            output = arguments[1];
            return new String[] {input, output};
        } else {
            // Otherwise assume that the arguments passed are in the format: [flag] [input] [output]
            flag = arguments[0];
            input = arguments[1];
            output = arguments[2];
            return new String[] {flag,input,output};
        }
    }

    /**
     * This method takes a string as input and converts it to UPPER CASE.
     * @param input is a string to be converted to UPPER CASE.
     * @return the input in UPPER CASE form.
     */
    private static String fullNameToUpperCase(String input) {
        // Split the input by spaces and store as a string array.
        String[] fullName = input.split(" +");
        // Check if the array is larger than 2 values (i.e. Middle Name is included.)
        if (fullName.length > 2) {
            // Collect the middle name initial, and set it as uppercase and append a full stop.
            String temp = fullName[1];
            temp = temp.toUpperCase() + ".";
            fullName[1] = temp;
            input = String.join(" ", fullName);
        }
        // Return the value in UPPER CASE.
        return input.toUpperCase();
    }

    /**
     * This method takes a string as input and converts it to Title Case.
     * @param input is a string to be converted to Title Case.
     * @return the input in Title Case form.
     */
    private static String toTitleCase(String input) {
        // Split the input by spaces and store as a string array.
        String[] fullName = input.split(" +");
        // Check if the array is larger than 2 values (i.e. Middle Name is included.)
        if (fullName.length > 2) {
            // Collect the middle name initial, and set it as uppercase and append a full stop.
            String temp = fullName[1];
            temp = temp.toUpperCase() + ".";
            fullName[1] = temp;
            input = String.join(" ", fullName);
        }

        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        // Set the input to a character array and iterate over it.
        for (char c : input.toCharArray()) {
            // Check if the character is a space.
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {         // Check if character is not a space (hence any other character).
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            // Add the result to the string builder.
            titleCase.append(c);
        }
        // Return the value in Title Case.
        return titleCase.toString();
    }

} // FilesInOut
