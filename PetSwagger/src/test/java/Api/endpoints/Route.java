package Api.endpoints;
/*website url:  https://petstore.swagger.io/
/1-create user(post):https://petstore.swagger.io/v2/user
2- Get user ny name:https://petstore.swagger.io/v2/user/{{username}}
3- update user(put): https://petstore.swagger.io/v2/user/{{username}}
4-delete user: https://petstore.swagger.io/v2/user/{{username}}
 */

public class Route {
    public static String baseUrl="https://petstore.swagger.io/v2";
    //user
    public static String postUrl=baseUrl+"/user";
    public static String getUrl=baseUrl+"/user/{username}";
    public static String updateUrl=baseUrl+"/user/{username}";
    public static String deleteUrl=baseUrl+"/user/{username}";
    //store
    //pet

}
