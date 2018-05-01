package yuanxiu;
import org.junit.*;
import io.restassured.RestAssured;
///import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class test_login {
	
	@BeforeClass
	public static void setSSL() {
		RestAssured.useRelaxedHTTPSValidation();
	}
	@Test
	public void login_invaliduser() {
		Map< String,Object> map3 = new HashMap< String,Object>();
		map3.put("userName", "18666666666");
		map3.put("password", "1111111");
		given()
		        .params(map3)
		.when()
		        .post("https://zhiren.yundaojishu.com/api/user/login")
		.then()
		        .statusCode(200)
		        .body("message", equalTo("账号不存在"));
	}
	@Test
	public void login_invalidpasswd() {
		Map< String,Object> map3 = new HashMap< String,Object>();
		map3.put("userName", "18676689172");
		map3.put("password", "1111111");
		given()
		        .params(map3)
		.when()
		        .post("https://zhiren.yundaojishu.com/api/user/login")
		.then()
		        .statusCode(200)
		        .body("message", equalTo("密码不正确"));
	}
	
	@Test
	public void get_key() {
		Map< String,Object> map4 = new HashMap< String,Object>();
		map4.put("JSESSIONID", "0BBF3549EF6741D2084D1436386120B1");
		map4.put("cookie.sign", "17529755F37FED02B875A8337B9015C1CDD36862C67B1010E342B8142B78CBA40CF41C20B77D31CD");
		map4.put("cookie.time", "81CBA8863809BD4B600194A8FE6E6F8B");
		given()
		       .cookies(map4)
		.when()
		       .get("https://zhiren.yundaojishu.com/api/user/get_key_public")
		.then()
		       .statusCode(200);
	}
	public static void main() {

 
	}

}
