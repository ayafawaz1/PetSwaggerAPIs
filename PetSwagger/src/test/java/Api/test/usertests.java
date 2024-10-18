package Api.test;

import Api.POJO.User;
import Api.endpoints.User_endpoints;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//add more validation in every testcase
public class usertests {
    Faker faker;
    User userpojo;
     @BeforeClass
    public void prepareData()
{
    faker=new Faker();
    userpojo=new User();
    userpojo.setId(faker.idNumber().hashCode());
    userpojo.setUsername(faker.name().username());
    userpojo.setFirstName(faker.name().firstName());
    userpojo.setLastName(faker.name().lastName());
    userpojo.setEmail(faker.internet().safeEmailAddress());
    userpojo.setPassword(faker.internet().password(8,15));
    userpojo.setPhone(faker.phoneNumber().cellPhone());

}

@Test(priority = 1)
    public void createUser()
{
    Response response=User_endpoints.createNewUser(userpojo);
    response.then().log().all();
    Assert.assertEquals(response.getStatusCode(),200);
}
 @Test (dependsOnMethods = "createUser",priority = 2)
    public void ReadUserData()
 {
     String userName=userpojo.getUsername();
     Response response= User_endpoints.GetUser(userName);
     response.then().log().all();
     Assert.assertEquals(response.getStatusCode(),200);
 }

@Test(dependsOnMethods ="ReadUserData",priority = 3)
 public void UpdateUserData()
 {
     //will update only password
     userpojo.setPassword(faker.internet().password(8,15));
     String userName=userpojo.getUsername();
     Response response=User_endpoints.UpdateUser(userName,userpojo);
     response.then().log().all();
    // response.then().log().body().statusCode(200);  chai assert
     Assert.assertEquals(response.getStatusCode(),200); //testNG assert
     //check data after updating:
     Response responseAfterUpdateData= User_endpoints.GetUser(userName);
     responseAfterUpdateData.then().log().all();
     Assert.assertEquals(responseAfterUpdateData.getStatusCode(),200);

 }

 @Test(priority = 4)
    public void DeletingUser()
 {
     String userName=userpojo.getUsername();
     Response response=User_endpoints.DeleteUser(userName);
     Assert.assertEquals(response.getStatusCode(),200);
 }













}
