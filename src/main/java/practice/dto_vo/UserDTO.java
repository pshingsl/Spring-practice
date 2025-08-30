package practice.dto_vo;

/*
 * DTO
 * 단순히 데이터를 전송하기 위한 목적으로 사용됨
 * getter/setter 정도만을 가진다.(비즈니스 로직 포함 안됨)
 * */
public class UserDTO {
    private long id;
    private String username;
    private String email;
    private int age;

    public UserDTO(long id, String username, String email, int age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO: " +
                "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
