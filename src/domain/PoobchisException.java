package domain;

public class PoobchisException extends Exception {
    public final static String NULL = "Building option";
    public final static String NO_SAVED = "The file was not saved successfully";
    public final static String NO_EXPORTED = "The file was not exported successfully";
    public final static String NO_IMPORTED = "The file was not imported successfully";
    public final static String FILE_NOT_FOUND = "The file was not found";
    public final static String CORRUPT_FILE = "The file is corrupt";
    public final static String CLASS_NOT_FOUND = "The class in the file was not found";
    public final static String CLASS_NOT_ALLOWED = "The class in the file is not allowed";
    public final static String IN_OUT = "There was a problem in the reading/writing of this file";
    public final static String CANT_OPEN = "The file cannot be open";

    public PoobchisException(String message){
        super(message);
    }
//    public PoobchisException(String message, int errLine, String errWord){
//        super(message + ", error in line: " + errLine + ", in word: " + errWord);
//    }
}
