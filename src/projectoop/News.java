package projectoop;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private String title;
    private String text;
    private Date date;
    private Manager sender;
}

