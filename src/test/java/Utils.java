import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Utils {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws IOException, ParseException {
        Utils utils = new Utils();
        utils.getUserCredentials(0);
        System.out.println(utils.getEmail());
        System.out.println(utils.getPassword());
    }

    public void getUserCredentials(int position) throws IOException, ParseException {
        String fileName = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) object;
        JSONObject jsonObject = (JSONObject) jsonArray.get(position);
        setEmail((String) jsonObject.get("email"));
        setPassword((String)jsonObject.get("password"));
    }
}
