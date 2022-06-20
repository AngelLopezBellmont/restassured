

//import com.jayway.jsonpath.JsonPath;
//import com.jayway.jsonpath.JsonPathException;
//import com.jayway.jsonpath.JsonPath.*;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class jsonpath_demos {

    @Test
    public void a_jsonpath_with_slashes() {
        Utils utils = new Utils();
        System.out.println("json: " + utils.myjson_1 );
        JsonPath jsonPath = new JsonPath(utils.myjson_1);
        System.out.println("jsonPath: " + jsonPath.prettyPrint());
        System.out.println("data    : " + jsonPath.get("data"));
        System.out.println("id      : " + jsonPath.get("data.id"));
    }
    @Test
    public void b_jsonpath_with_slashes() {
        Utils utils = new Utils();
        //System.out.println("json: " + utils.myjson_1 );
        JsonPath jsonPath = new JsonPath(utils.myjson_1);

        System.out.println("get(key0_0) : " + jsonPath.get("key0_0"));
        System.out.println("node1.key1_1 : " + jsonPath.get("node1.key1_1"));
        System.out.println("node1.key1_2 : " + jsonPath.get("node1.key1_2"));
        System.out.println("node1.key1_2 : " + jsonPath.get("$.node1[key1_2]"));
        //System.out.println("node1.key1_3 : " + jsonPath.get("node1.key1_3"));

        System.out.println("getString(key0_0): " + jsonPath.getString("key0_0"));

        System.out.println("$.key0_1 : " + jsonPath.getString("$.key0_1"));
        System.out.println("get('$') : " + jsonPath.get("$"));
        //System.out.println("get('$') : " + jsonPath.get("$.[key0.1]")); //not works
        //System.out.println("getJsonObject('$.demo') : " + jsonPath.getJsonObject("$.demo0")); //null

    }

    @Test
    public void c_jsonpath_with_slashes() {
        Utils utils = new Utils();
        //System.out.println("json: " + utils.myjson_1 );
        JsonPath rs_myJsonPath = new JsonPath(utils.myjson_1);
        System.out.println("get('') : " + rs_myJsonPath.get(""));
        System.out.println("get('') : " + rs_myJsonPath.get("demo0"));
        //String s = rs_myJsonPath.toString();
        //String s_jsonpath = rs_myJsonPath.getString("");

    }


}

