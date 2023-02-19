package com.zayac.helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
   public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .auth().basic("bsuser_m2GR1Q", "QxMmzeCKGrzs3ux85j45")
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
