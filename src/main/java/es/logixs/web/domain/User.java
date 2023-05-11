package es.logixs.web.domain;

public class User {
    private String objectid;
    private String name;
    private String lastName;
    private String email;


    public User(String objectid) {
        this.objectid = objectid;
    }

    public User() {
    }

    public User(String objectid, String name, String lastName, String email) {
        this.objectid = objectid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((objectid == null) ? 0 : objectid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (objectid == null) {
            if (other.objectid != null)
                return false;
        } else if (!objectid.equals(other.objectid))
            return false;
        return true;
    }

    
}
