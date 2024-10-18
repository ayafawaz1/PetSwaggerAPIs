package Api.endpoints;

import Api.POJO.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//perform CRUD operations
public class User_endpoints {

    public static Response createNewUser(User POJO)
    {
        Response response=
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(POJO)
                .when()
                .post(Route.postUrl);
        return response;
    }

    public static Response GetUser(String userName)
    {
        Response response= given()
                        .pathParam("username",userName)
                        .when()
                        .get(Route.getUrl);
        return response;
    }

    public static Response UpdateUser(String userName, User POJO)
    {
        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParam("username",userName)
                        .body(POJO)
                        .when()
                        .put(Route.updateUrl);
        return response;
    }

    public static Response DeleteUser(String userName)
    {
        Response response=
                given()
                        .pathParam("username",userName)
                        .when()
                        .delete(Route.deleteUrl);
        return response;
    }

}
