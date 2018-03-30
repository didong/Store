package cn.edu.imut.bean.dto;

/**
 * Created by di_dong on 2017/5/22.
 */
public class UserRequest {
    private String userName;//用户名
    private String passWord;//密码
    private String confirmPassWord;//确认密码
    private String nickName;//昵称
    private String email;//邮箱
    private String phoneNumber;//电话号码
    private String verificationCode;//验证码
    private String md5VerificationCode;//md5验证码
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getConfirmPassWord() {
        return confirmPassWord;
    }

    public void setConfirmPassWord(String confirmPassWord) {
        this.confirmPassWord = confirmPassWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getMd5VerificationCode() {
        return md5VerificationCode;
    }

    public void setMd5VerificationCode(String md5VerificationCode) {
        this.md5VerificationCode = md5VerificationCode;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", confirmPassWord='" + confirmPassWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", md5VerificationCode='" + md5VerificationCode + '\'' +
                '}';
    }
}
