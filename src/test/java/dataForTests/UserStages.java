package dataForTests;

import utils.User;

/**
 * Created by QaMac on 8/16/15.
 */
public class UserStages {

    public User publicNotConfirmedUser(){
        User user = new User();
        user.setEmail("georgiyNot_Verified@gmail.com");
        user.setPassword("03123781");
        return user;
    }

    public User publicConfirmedUser(){
        User user = new User();
        user.setEmail("georgiyOrgLess@gmail.com");
        user.setPassword("03123781");
        return user;
    }

    public User publicUserWithOrg(){
        User user = new User();
        user.setEmail("georgiyInOrg@gmail.com");
        user.setPassword("03123781");
        return user;
    }

    public User companyUserNotConfimed(){
        User user = new User();
        user.setEmail("georgiyNot_Verified@techamgic.co");
        user.setPassword("03123781");
        return user;
    }

    public User companyUserOrg_LessNoAssignedCompanies(){
        User user = new User();
        user.setEmail("georgiyOrgLessFirstDomain@techamgic.co");
        user.setPassword("03123781");
        return user;
    }

    public User companyUserOrg_LessWithAssigment(){
        User user = new User();
        user.setEmail("georgiyOrgLessWithAssigment@techmagic.co");
        user.setPassword("03123781");
        return user;
    }

    public User companyUserJoinAsViewer(){
        User user = new User();
        user.setEmail("georgiyAsViewer@techmagic.co");
        user.setPassword("03123781");
        return user;
    }
    public User companyUserJoinAsAuthor(){
        User user = new User();
        user.setEmail("georgiyAsAuthor@techmagic.co");
        user.setPassword("03123781");
        return user;
    }



    public User companyUserActiveInCompany(){
        User user = new User();
        user.setEmail("georgiyInOrg@techmagic.co");
        user.setPassword("03123781");
        return user;
    }










}
