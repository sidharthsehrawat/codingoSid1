package folder1.mmt;


public class AddUser implements AddUserInterface{
    @Override
    public User add(User user, UserDetail userDetail) {
        User userDeatils = new User();
        userDeatils.setUserName(userDetail.getName());
        userDeatils.setUserId(userDetail.getUserId());
        userDeatils.setEmail(userDetail.getEmail());
        userDeatils.setMobile(userDetail.getMobile());
        return userDeatils;
    }


}
