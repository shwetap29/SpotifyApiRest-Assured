package com.bridgelabz;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class RestAssuredSpotify {
    String token = "";
    String userID = "";
    String playlistId = "";



    @BeforeMethod
    public void setUp() {
        token = "Bearer BQCnh13BEq6IlmBN2AtskKufJDhH7pAG6uCp6ksrbcMxLmh-Vhy8M5dCFVmR1X7ibFhqbCifP_oi7p7a4Y4PEBRcH8oLAg_Mip6t96CM91vO2tPLcGZp5YcWCRBzuZgI3Pe7HXcFIgMD0-LgTaCAxOGWw8-Ef_BfDQfB-lk9HomtsyisLOqEU5aXLjuAyw8VmxVDnEUP_aPsrape87YI8UISDAYxdxMqlpKipBFzy1N2xNmLTKHrqk5OYDu6fnE7zGarUrFGQZD24VSuUxh3_d7IbZl-zQeCTVmmyBQFEEAg";
    }

    //Gets current profile data
    @Test
    public void getUserProfile_GET_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/" +userID + "/");
        response.prettyPrint();
    }

    @Test
    public void getUserCurrentProfile_GET_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/" + userID + "/");
        response.prettyPrint();
    }

    @Test
    public void getCurrentUserPlaylist_GET_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/m"+ userID + "/playlists");
        response.prettyPrint();
    }

    @Test
    public void createNewPlaylist_POST_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body("{\"name\":\"New Playlist\",\"description\":\"New playlist description\",\"public\":false}")
                .when()
                .post("https://api.spotify.com/v1/users/" + userID + "/playlists");
        response.prettyPrint();
    }

    @Test
    public void searchItems_GET_REQUEST() {
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
    public void GetAudioAnalysisForTrack_GET_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("\thttps://api.spotify.com/v1/audio-analysis/2ekn2ttSfGqwhhate0LSR0");
        response.prettyPrint();
    }

    @Test
    public void addItem_POST_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .queryParams("uris","spotify:user:user_id" )
                .when()
                .post("https://api.spotify.com/v1/playlists/7wsjyvDnhC9IHgC7VheKFj/tracks?uris=spotify:playlist:7kfuJY4uVJ6l8VsWOkFU04");
        response.prettyPrint();
    }

    @Test
    public void createPlaylist_POST_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n  \"name\": \"NewHits\",\n  \"description\": \"New Songs\",\n  \"public\": True\n}")
                .when()
                .post("https://api.spotify.com/v1/users//playlists");
        response.prettyPrint();
    }

    @Test
    public void UpdatingPlaylistName_PUT_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body("{\"name\":\"DL\",\"description\":\"GirlSongs\",\"public\":false}")
                .when()
                .post("https://api.spotify.com/v1/playlists/" + playlistId + "/");
        response.prettyPrint();
    }
     @Test
     public void UploadPlaylistCover_PUT_REQUEST () {
         Response response  = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .header("Authorization", token)
            .when()
            .post(	"https://api.spotify.com/v1/playlists/" + playlistId +"/images");
        response.prettyPrint();
      }

    @Test
    public void ReorderPlaylistItems_PUT_REQUEST() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body("{\"range_start\":1,\"insert_before\":3,\"range_length\":2}")
                .when()
                .post("https://api.spotify.com/v1/playlists/" + playlistId +"/tracks");
        response.prettyPrint();
    }

}







