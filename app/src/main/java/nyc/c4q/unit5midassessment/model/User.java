package nyc.c4q.unit5midassessment.model;

import java.util.jar.Attributes;

/**
 * Created by Shant on 1/24/2018.
 */

public class User {

    private Name name;
    private Location location;
    private String email;
    private String dob;
    private String cell;
    private Picture picture;

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getCell() {
        return cell;
    }

    public Picture getPicture() {
        return picture;
    }
}
