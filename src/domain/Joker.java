package domain;

import java.awt.*;
import java.util.Random;

public class Joker extends Box{

    private String movePlus5 = "Plus5";
    private String moveMenus5 = "Menus5";

    public Joker() {
        super();
    }

    public Joker(Color color) {
        super(color);
    }

    /**
     * @return random wildcard  movePlus5 | moveMenus5
     */
    @Override
    public String getWildcard(){
        String[] myWildCard = {movePlus5,moveMenus5};
        Random r = new Random();
        int randomitem = r.nextInt(myWildCard.length);
        String randomElement = myWildCard[randomitem];
//        System.out.println(randomElement + "JM");
        return randomElement;
    }

}
