var system = {
	win : false,
	mac : false,
	xll : false
};
//检测平台
var p = navigator.platform;
system.win = p.indexOf("Win") == 0;
system.mac = p.indexOf("Mac") == 0;
system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
//跳转语句
if (system.win || system.mac || system.xll) {
	var el = document.getElementsByClassName("top-2");
	for (var i = 0; i < el.length; i++) {
		el[i].style.cssText = "height: 16%;";
	}
} else { //说明是手机端
	var el = document.getElementsByClassName("top-2");
	for (var i = 0; i < el.length; i++) {
		el[i].style.cssText = "height: 10%;";
	}
}