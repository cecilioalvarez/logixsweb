package es.logixs.web.dto;

import es.logixs.web.domain.User;

public class UserDTO {

    private String objectId;
    private String name;
    private String lastName;
    private String email;

    
    public UserDTO() {
    }
    public UserDTO(String objectId, String name, String lastName, String email) {
        this.objectId = objectId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }


    public UserDTO(User user) {
        this.objectId = user.getObjectId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();

        
    }
    public String getObjectId() {
        return objectId;
    }
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public User getUser() {

        return new User (this.getObjectId(),this.getName(),this.getLastName(),this.getEmail());
    }
}
