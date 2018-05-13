function judgeLogin() {
	// 判断用户是否已经登录
	var showtip = $('#showtip');
	showtip.empty();
	if (localStorage.username) {
		var text = '<li>欢迎您,' + localStorage.username + '</li>'
				+ '<li><a href="#" onclick="logout()">注销</a></li>';
	} else {
		var text = '<li><a href="login-page.html">登录</a></li>'
				+ '<li><a href="reg-page.html">注册</a></li>';
	}
	showtip.append(text);
}

function logout() {
	if (confirm("您确定要退出么？")) {
		localStorage.username = '';
		judgeLogin();
	}

}


function getExplorerInfo() {
    var explorer = window.navigator.userAgent.toLowerCase();
    //ie 
    if (explorer.indexOf("msie") >= 0) {
        var ver = explorer.match(/msie ([\d.]+)/)[1];
        return { type: "IE", version: ver };
    }
        //firefox 
    else if (explorer.indexOf("firefox") >= 0) {
        var ver = explorer.match(/firefox\/([\d.]+)/)[1];
        return { type: "Firefox", version: ver };
    }
        //Chrome
    else if (explorer.indexOf("chrome") >= 0) {
        var ver = explorer.match(/chrome\/([\d.]+)/)[1];
        return { type: "Chrome", version: ver };
    }
        //Opera
    else if (explorer.indexOf("opera") >= 0) {
        var ver = explorer.match(/opera.([\d.]+)/)[1];
        return { type: "Opera", version: ver };
    }
        //Safari
    else if (explorer.indexOf("Safari") >= 0) {
        var ver = explorer.match(/version\/([\d.]+)/)[1];
        return { type: "Safari", version: ver };
    }
}

//获取操作系统名称
function osType(){  
    var sUserAgent = navigator.userAgent;   
    var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows");   
    var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh") || (navigator.platform == "MacIntel");   
    if (isMac) return "Mac";   
    var isUnix = (navigator.platform == "X11") && !isWin && !isMac;   
    if (isUnix) return "Unix";   
    var isLinux = (String(navigator.platform).indexOf("Linux") > -1);   
    var bIsAndroid = sUserAgent.toLowerCase().match(/android/i) == "android";  
    if (isLinux) {  
    if(bIsAndroid) return "Android";  
    else return "Linux";   
    }  
    if (isWin) {   
    var isWin2K = sUserAgent.indexOf("Windows NT 5.0") > -1 || sUserAgent.indexOf("Windows 2000") > -1;   
    if (isWin2K) return "操作系统：Win2000";   
    var isWinXP = sUserAgent.indexOf("Windows NT 5.1") > -1 || sUserAgent.indexOf("Windows XP") > -1  
    sUserAgent.indexOf("Windows XP") > -1;   
    if (isWinXP) return "操作系统：WinXP";   
    var isWin2003 = sUserAgent.indexOf("Windows NT 5.2") > -1 || sUserAgent.indexOf("Windows 2003") > -1;   
    if (isWin2003) return "操作系统：Win2003";   
    var isWinVista= sUserAgent.indexOf("Windows NT 6.0") > -1 || sUserAgent.indexOf("Windows Vista") > -1;   
    if (isWinVista) return "操作系统：WinVista";   
    var isWin7 = sUserAgent.indexOf("Windows NT 6.1") > -1 || sUserAgent.indexOf("Windows 7") > -1;   
    if (isWin7) return "操作系统：Win7";   
    var isWin8 = sUserAgent.indexOf("windows nt6.2") > -1 || sUserAgent.indexOf("Windows 8") > -1;  
    if (isWin8) return "操作系统：Win8";      
    }  
    return "操作系统：win10";   
} 


//添加评论
function addComment(data){
	 $.ajax({
		 url:"comment/add",
		type:"POST",
		data:data,
		dataType:"json",
		success:function(data){
			//alert(data.msg);
		},
		error:function(){
			
		}
	 })
}


//获取当前时间
function getNowDateFormat(){
	var nowDate = new Date();
	var year = nowDate.getFullYear();
	var month = filterNum(nowDate.getMonth()+1);
	var day = filterNum(nowDate.getDate());
	var hours = filterNum(nowDate.getHours());
	var min = filterNum(nowDate.getMinutes());
	var seconds = filterNum(nowDate.getSeconds());
	return year+"-"+month+"-"+day+" "+hours+":"+min+":"+seconds;
}

function filterNum(num){
	if(num < 10){
		return "0"+num;
	}else{
		return num;
	}
}