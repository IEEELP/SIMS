var date=new Date();
var welcome=document.getElementsByClassName("welcomemessage")[0];
welcome.innerHTML="欢迎使用本系统，今天是"+date.toLocaleDateString();
welcome.style.backgroundColor="#94aef3";

var usermanner=document.getElementById("usermanner");
var userul=document.getElementById("userul");
usermanner.setAttribute("flag","1");//设置标志
usermanner.onclick=function () {//点击改变背景
    if (usermanner.getAttribute("flag") == "1") {
        usermanner.style.backgroundImage = "url('../img/menufolderactive.jpg')";
        userul.style.display="block";
        usermanner.setAttribute("flag", "0");
    } else if (usermanner.getAttribute("flag") == "0") {
        usermanner.style.backgroundImage = "url('../img/menufolder.jpg')";
        userul.style.display="none";
        usermanner.setAttribute("flag", "1");
    }
};