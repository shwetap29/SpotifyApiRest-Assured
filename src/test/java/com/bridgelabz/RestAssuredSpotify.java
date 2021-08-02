package com.bridgelabz;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredSpotify {
    String token = "";
    String userID = "";
    String playlistID = "";


    @BeforeMethod
    public void setUp() {
        token = "Bearer BQBrcMGR0wpenRoYJMXqlRGz2wt9cZwtWOeuXEjQRHAlDJC8Yv_UG5L7rkMd7x1PTqSitIoD1n_BakuzqpqfdLTeDfuG7ADkQptAZnc7lvDtHLwVDZL4qeGNCdCO2pc94Q14GGnAk2N8NPclYnEm4ebkm10ZEw36J7fdNWMmp7-OvC46htnvDD3pcwgMDnKdhkmfBGD6cIgSDRQRAV2deYTGmqBXoEsVXTfbdc6dHSXk4nwaWhOWevboFmJUeKaBX86BvCPcC22HvC46OBZiqGhloY4Qw1R632feytELfC9q";}

    @Test
        public void getUserProfile_GET_REQUEST () {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .get("https://api.spotify.com/v1/users/31rtrtc6epfncgl47fdknuimzjaa");
            response.prettyPrint();
        }

        @Test
        public void getUserCurrentProfile_GET_REQUEST () {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .get("https://api.spotify.com/v1/me");
            response.prettyPrint();
            userID = response.path("id");
            System.out.println("UserID :" + userID);

        }
        @Test
        public void getCurrentUserPlaylist_GET_REQUEST () {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .get("https://api.spotify.com/v1/me/playlists");
            response.prettyPrint();
        }

        @Test
        public void createNewPlaylist_POST_REQUEST () {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", token)
                    .body("{\"name\":\"Bollywood Hits\",\"description\":\"Bollywood Songs\",\"public\":\"false\"}")
                    .when()
                    .post("https://api.spotify.com/v1/users/31rtrtc6epfncgl47fdknuimzjaa/playlists");
            response.prettyPrint();
        }

        @Test
        public void searchItems_GET_REQUEST () {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .get("https://api.spotify.com/v1/search?q=dua%20lipa&type=artist");
            response.prettyPrint();
            response.then().statusCode(200);
        }

        @Test
        public void addItem_POST_REQUEST () {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .post("https://api.spotify.com/v1/playlists/7wsjyvDnhC9IHgC7VheKFj/tracks?uris=spotify:playlist:7kfuJY4uVJ6l8VsWOkFU04");
            response.prettyPrint();
        }

    }

