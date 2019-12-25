

var logindiv=document.getElementById("logindiv");
var registerdiv=document.getElementById("registerdiv");
if (toregister){
    var toregister=document.getElementById("toregister");
    toregister.onmouseover=function () {//去注册的颜色的变化
        this.style.color="#ff0000";
    };
    toregister.onmouseout=function () {
        this.style.color="#000";
    };
}
if (tologin){
    var tologin=document.getElementById("tologin");
    tologin.onmouseover=function () {//去登录的颜色变化
        this.style.color="#f00";
    };
    tologin.onmouseout=function () {
        this.style.color="#000";
    };
}
var username=document.getElementById("username");
var usermessage=document.getElementById("usermessage");
var password=document.getElementById("password");
var passmessage=document.getElementById("passmessage");
var loginbtn=document.getElementById("loginbtn");
loginbtn.onclick=function () {//登录验证
  var flag=true;
  if (!checkuser()) flag=false;
  if (!checkpass()) flag=false;
  return flag;
};
function checkuser() {
    if (username.value==""){
        usermessage.innerText="用户名不能为空";
        usermessage.style.color="#d00";
        usermessage.style.fontSize="14px";
        usermessage.style.lineHeight="40px";
        return false;
    } else{
        usermessage.innerText="";
        return true;
    }
}
function checkpass() {
    if (password.value==""){
        passmessage.innerText="密码不能为空";
        passmessage.style.color="#d00";
        passmessage.style.fontSize="14px";
        passmessage.style.lineHeight="40px";
        return false;
    } else {
        passmessage.innerText="";
        return true;
    }
}
var emailmessage=document.getElementById("emailmessage");
var registerbtn=document.getElementById("registerbtn");
registerbtn.onclick=function () {
  var flag=true;
  if (!checkuser2()) flag=false;
  if (!checkpass2()) flag=false;
  if (!checkemail()) flag=false;
  return false;
};

function checkemail() {
    if (email.value==""){
        emailmessage.innerText="邮箱不能为空";
        emailmessage.style.color="#d00";
        emailmessage.style.fontSize="14px";
        emailmessage.style.lineHeight="40px";
        return false;
    } else {
        emailmessage.innerText="";
        return true;
    }
}