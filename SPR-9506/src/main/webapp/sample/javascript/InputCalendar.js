document.writeln('<div id="minical" onmouseover="caledarOver()" onmouseout="calendarOut()" style="background: buttonface; margin:2; border: 1 solid buttonshadow; width:160; display:none; position:absolute; z-index:1">');
document.writeln('<div id="cal"></div>');
document.writeln('</div>');
var target;
var stime;
var calendar;
var targetObj;

function popUpCalendar(obj, division) {
	
	//var now = obj.value.split(division);
	var now = obj.value.split(division);
	target = obj;	
	targetObj = obj;

	var top = document.body.clientTop + GetObjectTop(obj);
	var left = document.body.clientLeft + GetObjectLeft(obj);
//	calendar = document.all.minical;
	calendar = document.getElementById("minical");
	calendar.style.top = top + obj.offsetHeight + "px";
	calendar.style.left = left + 110 + "px";
	calendar.style.display = '';
	
	if (now.length == 3) {		
		showCalendar(now[0],now[1],now[2], division);					
	} else {
		now = new Date();
		showCalendar(now.getFullYear(), now.getMonth()+1, now.getDate(), division);
	}
}

function GetObjectTop(obj)
{
	if (obj.offsetParent == document.body)
		return obj.offsetTop;
	else
		return obj.offsetTop + GetObjectTop(obj.offsetParent);
}

function GetObjectLeft(obj)
{
	if (obj.offsetParent == document.body)
		return obj.offsetLeft;
	else
		return obj.offsetLeft + GetObjectLeft(obj.offsetParent);
}




function showCalendar(sYear, sMonth, sDay, division) {
	var Months_day = new Array(0,31,28,31,30,31,30,31,31,30,31,30,31);
	//var Weekday_name = new Array("일", "월", "화", "수", "목", "금", "토");
	var intThisYear = new Number(), intThisMonth = new Number(), intThisDay = new Number();
	document.getElementById("cal").innerHTML = "";
	datToday = new Date();													// 현재 날자 설정
	
	intThisYear = parseInt(sYear);
	intThisMonth = parseInt(sMonth);
	intThisDay = parseInt(sDay);
	
	if (intThisYear == 0) intThisYear = datToday.getFullYear();				// 값이 없을 경우
	if (intThisMonth == 0) intThisMonth = parseInt(datToday.getMonth())+1;	// 월 값은 실제값 보다 -1 한 값이 돼돌려 진다.
	if (intThisDay == 0) intThisDay = datToday.getDate();
	
	switch(intThisMonth) {
		case 1:
				intPrevYear = intThisYear -1;
				intPrevMonth = 12;
				intNextYear = intThisYear;
				intNextMonth = 2;
				break;
		case 12:
				intPrevYear = intThisYear;
				intPrevMonth = 11;
				intNextYear = intThisYear + 1;
				intNextMonth = 1;
				break;
		default:
				intPrevYear = intThisYear;
				intPrevMonth = parseInt(intThisMonth) - 1;
				intNextYear = intThisYear;
				intNextMonth = parseInt(intThisMonth) + 1;
				break;
	}
	intPPyear = intThisYear-1;
	intNNyear = intThisYear+1;

	NowThisYear = datToday.getFullYear();										// 현재 년
	NowThisMonth = datToday.getMonth()+1;										// 현재 월
	NowThisDay = datToday.getDate();											// 현재 일
	
	datFirstDay = new Date(intThisYear, intThisMonth-1, 1);						// 현재 달의 1일로 날자 객체 생성(월은 0부터 11까지의 정수(1월부터 12월))
	intFirstWeekday = datFirstDay.getDay();										// 현재 달 1일의 요일을 구함 (0:일요일, 1:월요일)
	
	intSecondWeekday = intFirstWeekday;
	intThirdWeekday = intFirstWeekday;
	
	datThisDay = new Date(intThisYear, intThisMonth, intThisDay);				// 넘어온 값의 날자 생성
	intThisWeekday = datThisDay.getDay();										// 넘어온 날자의 주 요일

	//varThisWeekday = Weekday_name[intThisWeekday];								// 현재 요일 저장
	
	intPrintDay = 1;																// 달의 시작 일자
	secondPrintDay = 1;
	thirdPrintDay = 1;

	Stop_Flag = 0;
	
	if ((intThisYear % 4)==0) {													// 4년마다 1번이면 (사로나누어 떨어지면)
		if ((intThisYear % 100) == 0) {
			if ((intThisYear % 400) == 0) {
				Months_day[2] = 29;
			}
		} else {
			Months_day[2] = 29;
		}
	}
	intLastDay = Months_day[intThisMonth];										// 마지막 일자 구함

	Cal_HTML = "<table id='Cal_Table' border='0' bgcolor='#f4f4f4' cellpadding='1' cellspacing='1' width='100%' onmouseover='doOver(event)' onmouseout='doOut(event)' style='font-size : 12;font-family:굴림;'>";
	Cal_HTML += "<tr align='center' bgcolor='#f4f4f4'>";
	Cal_HTML += "<td colspan='7' align='center'>";
	Cal_HTML += "<a style='cursor:pointer !important; cursor:hand;' onclick='showCalendar("+intPPyear+","+intThisMonth+","+intThisDay+",\""+division+"\");'>◀</a>";
	Cal_HTML += "&nbsp;&nbsp;<a style='cursor:pointer !important; cursor:hand;' onclick='showCalendar("+intPrevYear+","+intPrevMonth+","+intThisDay+",\""+division+"\");'>&lt;</a> ";
	Cal_HTML += intThisYear +"년 "+ intThisMonth +"월";
	Cal_HTML += " <a style='cursor:pointer !important; cursor:hand;' onclick='showCalendar("+intNextYear+","+intNextMonth+","+intThisDay+",\""+division+"\");'>&gt;</a>";
	Cal_HTML += "&nbsp;&nbsp;<a style='cursor:pointer !important; cursor:hand;' onclick='showCalendar("+intNNyear+","+intThisMonth+","+intThisDay+",\""+division+"\");'>▶</a>";
	Cal_HTML += "</td></tr>";
	Cal_HTML += "<tr align='center' bgcolor='#87B3D6' style='color:#2065DA;' >";
	Cal_HTML += "<td style='padding-top:3px;'><font color='black'>일</font></td><td style='padding-top:3px;'><font color='black'>월</font></td><td style='padding-top:3px;'><font color='black'>화</font></td><td style='padding-top:3px;'><font color='black'>수</font></td><td style='padding-top:3px;'><font color='black'>목</font></td><td style='padding-top:3px;'><font color='black'>금</font></td><td style='padding-top:3px;'><font color='black'>토</font></td>";
	Cal_HTML += "</tr>";
		
	for (intLoopWeek=1; intLoopWeek < 7; intLoopWeek++) {						// 주단위 루프 시작, 최대 6주
		Cal_HTML += "<tr align='right' bgcolor='white'>"
		for (intLoopDay=1; intLoopDay <= 7; intLoopDay++) {						// 요일단위 루프 시작, 일요일 부터
			if (intThirdWeekday > 0) {											// 첫주 시작일이 1보다 크면
				Cal_HTML += "<td>";
				intThirdWeekday--;
			} else {
				if (thirdPrintDay > intLastDay) {								// 입력 날짝 월말보다 크다면
					Cal_HTML += "<td>";
				} else {														// 입력날짜가 현재월에 해당 되면
					Cal_HTML += "<td onclick='parent.calendarClick(this);' title='"+intThisYear + "-" +  day2(intThisMonth).toString() + "-" + day2(thirdPrintDay).toString()+"' style=\"cursor:pointer !important; cursor:hand;border:1px solid white;";
					if (intThisYear == NowThisYear && intThisMonth==NowThisMonth && thirdPrintDay==intThisDay) {
						Cal_HTML += "background-color:#C6F2ED;";
					}
					
					switch(intLoopDay) {
						case 1:													// 일요일이면 빨간 색으로
							Cal_HTML += "color:red;";
							break;
						//case 7:
						//	Cal_HTML += "color:blue;"
						//	break;
						default:
							Cal_HTML += "color:black;";
							break;
					}
					
					Cal_HTML += "\">"+thirdPrintDay;
					
				}
				thirdPrintDay++;
				
				if (thirdPrintDay > intLastDay) {								// 만약 날짜 값이 월말 값보다 크면 루프문 탈출
					Stop_Flag = 1;
				}
			}
			Cal_HTML += "</td>";
		}
		Cal_HTML += "</tr>";
		if (Stop_Flag==1) break;
	}
	Cal_HTML += "</table>";
	document.getElementById("cal").innerHTML = Cal_HTML;

	// 달력 출력이 완료되면 iframe의 크기를 재조정한다.
//	var Cal_Table = document.getElementById("minical").Cal_Table;
//	window.resizeTo(158, Cal_Table.offsetHeight);

}

	function doOver(event) {
		if (window.event) 
			event = window.event; 
         var srcElement = event.srcElement? event.srcElement : event.target; 

		cal_Day = srcElement.title;
		if (cal_Day.length > 7) {
			srcElement.style.borderTopColor = "buttonhighlight";
			srcElement.style.borderLeftColor = "buttonhighlight";
			srcElement.style.borderRightColor = "buttonshadow";
			srcElement.style.borderBottomColor = "buttonshadow";
		}
	}

	function doOut(event) {
		if (window.event) 
			event = window.event; 
		
		var srcElement = event.srcElement? event.srcElement : event.target; 
		cal_Day = srcElement.title;
		
		if (cal_Day.length > 7) {
			srcElement.style.borderColor = "white";
		}
	}

	function day2(d) {																// 2자리 숫자료 변경
		var str = new String();
		
		if (parseInt(d) < 10) {
			str = "0" + parseInt(d);
		} else {
			str = "" + parseInt(d);
		}
		return str;
	}
	
	function caledarOver() {
		window.clearTimeout(stime);
	}

	function calendarOut() {
		stime=window.setTimeout("calendar.style.display='none';", 200);
	}
	
	function calendarClick(e) {
		cal_Day = e.title;
		if (cal_Day.length > 6) {
			targetObj.value = cal_Day;
		}	
		calendar.style.display='none';
	}
