package Pages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginPojo {

    private boolean success;
    private int status;
    private String message;


    /*
     "id": "189",
    "createdAt": "2024-10-20T12:13:25.807Z" this is for creating request body  no need add
     */
    private int id;
    private String createdAt;
//---------------------------------------------------
    @JsonProperty("data") // Ensures the 'data' field in JSON maps to 'userData' in Java
    private UserData userData; // Changed field name to userData

    // Getters and setters for the fields
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    //---------------------------------------------------
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt=createdAt;
    }
    //---------------------------------------------------------

    public UserData getUserData() { // Updated method name to match JSON structure
        return userData;
    }

    public void setUserData(UserData userData) { // Updated method name to match JSON structure
        this.userData = userData;
    }

    // Nested UserData class
    public static class UserData {
        private String id;
        private String name;
        private String email;
        private String token;

        // Getters and setters for the UserData fields
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public String toString() {
            return "UserData [id=" + id +
                    ", name=" + name +
                    ", email=" + email +
                    ", token=" + token + "]";
        }
    }
}
