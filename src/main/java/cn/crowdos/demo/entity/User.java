package cn.crowdos.demo.entity;

import cn.crowdos.kernel.constraint.Condition;
import cn.crowdos.kernel.constraint.wrapper.DateCondition;
import cn.crowdos.kernel.constraint.wrapper.IntegerCondition;
import cn.crowdos.kernel.resource.AbstractParticipant;
import cn.crowdos.kernel.resource.ability;
import com.fasterxml.jackson.annotation.JsonFormat;


public class User extends AbstractParticipant {

    @ability
    private IntegerCondition userId;

    @ability
    @JsonFormat(pattern = "yyyy.MM.dd")
    private DateCondition activeTime;

    public User(IntegerCondition userId, DateCondition activeTime) {
        this.userId = userId;
        this.activeTime = activeTime;
        this.status = ParticipantStatus.AVAILABLE;
    }

    public IntegerCondition getUserId() {
        return userId;
    }

    public void setUserId(IntegerCondition userId) {
        this.userId = userId;
    }

    public DateCondition getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(DateCondition activeTime) {
        this.activeTime = activeTime;
    }

    @Override
    public boolean hasAbility(Class<? extends Condition> aClass) {
        return aClass == DateCondition.class;
    }

    @Override
    public Condition getAbility(Class<? extends Condition> aClass) {
        if (!hasAbility(aClass)) return null;
        return activeTime;
    }

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean admin;

    public User(){}

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String username, String password, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public User(int id, String firstName, String lastName, String username, String password, boolean admin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getAdmin() {
        return admin;
    }

    public String toString(){
        return "{ firstName = " + firstName +", lastName = " + lastName +
                ", username = " + username  + "}";
    }

}
