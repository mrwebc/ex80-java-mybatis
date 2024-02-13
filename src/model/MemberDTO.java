package model;

import java.io.Serializable;
import java.util.Date;

public class MemberDTO implements Serializable {

  private String memberid;
  private String name;
  private int pw;
  private String phone;
  private String email;
  private Date regtime;
  
  @Override
  public String toString() {
    return "MemberDTO [memberid=" + memberid + ", name=" + name + ", pw=" + pw + ", phone=" + phone + ", email=" + email + ", regtime=" + regtime
        + "]";
  }

  public String getMemberid() {
    return memberid;
  }

  public void setMemberid(String memberid) {
    this.memberid = memberid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPw() {
    return pw;
  }

  public void setPw(int pw) {
    this.pw = pw;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getRegtime() {
    return regtime;
  }

  public void setRegtime(Date regtime) {
    this.regtime = regtime;
  }
  
}
