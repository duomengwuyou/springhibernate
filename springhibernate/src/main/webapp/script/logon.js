function fun(){
	if(checkField()== true){
		userlogon();
	}
}

//提交表单
function userlogon() 
{ 
	document.getElementById("form1").action="logon";
	document.getElementById("form1").submit();
} 


function checkField(){
 var usernameValue = document.getElementById("username").value; 
 var passwordValue = document.getElementById("password").value; 
 usernameValue = usernameValue.replace(/\s/gi,"");
 passwordValue = passwordValue.replace(/\s/gi,"");
 if(usernameValue != "" && passwordValue != ""){ 
     return true;
 }else if(usernameValue == "" || passwordValue == ""){
	 alert("用户名和密码不能为空");
	 return false;
 }
}
