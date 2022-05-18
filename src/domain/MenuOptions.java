package domain;

import java.io.*;

public class MenuOptions {
    private static MenuOptions options = null;

    public static MenuOptions getMenuOptions() {
        if (options==null){
            options=new MenuOptions();
        }
        return options;
    }

    public Poobchis open(File file) throws PoobchisException {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            Poobchis poobchisito = (Poobchis) input.readObject();
            input.close();
            return poobchisito;
        } catch (FileNotFoundException e) {
            throw new PoobchisException( PoobchisException.FILE_NOT_FOUND);
        } catch (StreamCorruptedException e) {
            throw new PoobchisException( PoobchisException.CORRUPT_FILE);
        } catch (ClassNotFoundException e) {
            throw new PoobchisException( PoobchisException.CLASS_NOT_FOUND);
        } catch (InvalidClassException e) {
            throw new PoobchisException( PoobchisException.CLASS_NOT_ALLOWED);
        } catch (IOException e) {
            throw new PoobchisException( PoobchisException.IN_OUT);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PoobchisException( PoobchisException.CANT_OPEN);
        }
    }

    public void save(File file, Poobchis automata) throws PoobchisException  {
        ObjectOutputStream salida = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            salida = new ObjectOutputStream(fos);
            salida.writeObject(automata);
            salida.close();
        } catch (FileNotFoundException e) {
            throw new PoobchisException( PoobchisException.FILE_NOT_FOUND);
        } catch (InvalidClassException e) {
            throw new PoobchisException( PoobchisException.CLASS_NOT_ALLOWED);
        }catch (IOException e) {
            throw new PoobchisException( PoobchisException.IN_OUT);
        } catch (NullPointerException e) {
            throw new PoobchisException( PoobchisException.NO_SAVED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PoobchisException( PoobchisException.NO_SAVED);
        }
    }

}
