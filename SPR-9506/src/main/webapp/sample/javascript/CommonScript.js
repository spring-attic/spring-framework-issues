function listFormValidation(conditions){
	for(i=0; i<conditions.length;i++){
		var condition = conditions[i];
		if(document.searchForm.searchCondition.value == condition)
		{
		    if(!PortalNumberCheck(document.searchForm.searchKeyword.value,".-")){
	               alert("You can enter only real number in search keyword field.");
	               document.searchForm.searchKeyword.focus();    
	               return false;
	        }
		}
	}		
	return true;
}

function setDefaultDate(dateVar) {
	if(""==dateVar.value){
		var date = new Date();
	    var day  = date.getDate();
	    var month = date.getMonth() + 1;
	    var year = date.getFullYear();
		dateVar.value = year+"-"+month+"-"+day;
	}
}	

function FormValidation(form){
     for(vi=0; vi<form.elements.length;vi++){
        var formField = form.elements[vi];
        var fieldType = formField.type;

        if(fieldType != 'hidden'){
            var fieldName = formField.name;
            var fieldValue = PortalTrim(formField.value);
            var num = formField.getAttribute("num");
            var fieldTitle = formField.getAttribute("fieldTitle");

            if(formField.getAttribute("required") != null && fieldType == "radio"){
                fieldValue = "";
                var wi = vi;
                while(form.elements[wi].type == "radio"){
                    if(form.elements[wi].checked == true){
                        fieldValue = form.elements[wi].value;
                    }
                    wi++;
                }
                form.elements[wi].value = fieldValue;
            }
            if(formField.getAttribute("required") != null && fieldValue == ""){
                alert(fieldTitle+" is a required field.");
                return PortalReturnFalse(formField);
            }
            if(formField.getAttribute("filter") != null && PortalSpecialCharCheck(fieldValue,formField.getAttribute("filter"))){
                alert("You can't enter characters as below " + "in " + fieldTitle+ " field." + "\n\n"+formField.getAttribute("filter"));
                return PortalReturnFalse(formField);
            }
            if(formField.getAttribute("maxLength") != null && formField.getAttribute("maxLength") >0 && !PortalMaxLengthCheck(fieldValue,formField.getAttribute("maxLength"))){
                alert(fieldTitle+" has over max length."+ "\n\n"  + "Max length of this field is (in case of English) : " + formField.getAttribute("maxLength"));
                return PortalReturnFalse(formField);
            }
            if(formField.getAttribute("minLength") != null && !PortalMinLengthCheck(fieldValue,formField.getAttribute("minLength"))){
                alert(fieldTitle+" has under min length."+ "\n\n"  + "Min length of this field is (in case of English) :  " + formField.getAttribute("minLength"));
                return PortalReturnFalse(formField);
            }
            if(num != null && fieldValue != ""){
                if(num == "" && !PortalNumberCheck(fieldValue,".-")){
                    alert("You can enter only real number in " + fieldTitle+" field.");
                    return PortalReturnFalse(formField);
                }else if(num == "i" && !PortalNumberCheck(fieldValue,"-")){
                    alert("You can enter only integer in " + fieldTitle+" field.");
                    return PortalReturnFalse(formField);
                }else if(num == "n" && !PortalNumberCheck(fieldValue,"")){
                    alert("You can enter only number in " + fieldTitle+" field.");
                    return PortalReturnFalse(formField);
                }else if(num != "" && num != "i"){
                    if(!PortalNumberCheck(fieldValue,".-")){
                        alert("You can enter only real number in " + fieldTitle+" field.");
                        return PortalReturnFalse(formField);
                    }
                    var oneTwo = num.split(".");
                    if(!fncNumLengthCheck(fieldValue,oneTwo[0],oneTwo[1])){
                        alert(fieldTitle+" field has invalid format.\n\n Max cipers of integer part : "+oneTwo[0]+" Down to max cipers decimal places : "+oneTwo[1]);
                        return PortalReturnFalse(formField);
                    }
                }
            }

            if(formField.getAttribute("fromNum") != null && PortalNumberCheck(fieldValue,"-.")){
                if(eval(formField.getAttribute("fromNum")) > eval(fieldValue)){
                    alert("You can enter a number over " + formField.getAttribute("fromNum") + " in " + fieldTitle + " field.");
                     return PortalReturnFalse(formField);
                }
            }
            if(formField.getAttribute("toNum") != null && PortalNumberCheck(fieldValue,"-.")){
                if(eval(formField.getAttribute("toNum")) < eval(fieldValue)){
                    alert("You can enter a number under " + formField.getAttribute("toNum") + " in " + fieldTitle + " field.");
                    return PortalReturnFalse(formField);
                }
            }

            if(formField.getAttribute("format") != null && fieldValue !=""){
                if(!PortalFormatMask(fieldValue, formField.getAttribute("format"))){
                    alert(fieldTitle+" has invalid format.\n\n Format : "+formField.getAttribute("format"));
                    return PortalReturnFalse(formField);
                }
            }

            if(formField.getAttribute("char") != null && !PortalCharValidation(formField.getAttribute("char"),fieldValue,fieldTitle)){
                    return PortalReturnFalse(formField);
            }

            if(formField.getAttribute("valCheck") != null && !PortalEtcValidation(formField, vi)){
                return PortalReturnFalse(formField);
            }

        } // hidden if
    } // end for
    return true;
}

function PortalCharValidation(char,fieldValue,fieldTitle){
    if(char.indexOf("s") >= 0 && PortalSpecialCharCheck(fieldValue, /[$\\@\\\#%\^\&\*\"\']/)){
        alert("You can't enter special characters in " + fieldTitle + " field.");
        return false;
    }
    if(char.indexOf("k") >= 0 && PortalCharCheck(fieldValue, "k")){
        alert("You can't enter korean language (hangul) in " + fieldTitle + " field.");
        return false;
    }
    if(char.indexOf("e") >= 0 && PortalCharCheck(fieldValue, "e")){
        alert("You can't enter english in " + fieldTitle + " field.");
        return false;
    }
    if(char.indexOf("n") >= 0 && PortalCharCheck(fieldValue, "n")){
        alert("You can't enter number in " + fieldTitle + " field.");
        return false;
    }
    return true;
}

function PortalEtcValidation(formField, index){
    var fieldName = formField.name;
    var fieldValue = PortalTrim(formField.value);
    var fieldTitle = formField.getAttribute("fieldTitle");

	if(formField.getAttribute("valCheck") != null && formField.getAttribute("valCheck").toUpperCase().indexOf("MAIL") > -1 && fieldValue !="" && !PortalEmailCheck(fieldValue) ){
        alert(fieldTitle+" has an invalid email address.\n\n"+" ex) sds@samsung.com");
        return false;
    }
	if(formField.getAttribute("valCheck") != null && formField.getAttribute("valCheck").toUpperCase().indexOf("URL") > -1 && fieldValue !="" && !PortalURLCheck(fieldValue) ){
        alert(fieldTitle+" has an invalid web address.\n\n"+" ex) www.samsungsds.co.kr");
        return false;
    }
	if(formField.getAttribute("valCheck") != null && formField.getAttribute("valCheck").toUpperCase().indexOf("PHONE") > -1 && fieldValue !="" && !PortalPhoneCheck(fieldValue) ){
        alert(fieldTitle+" has an invalid telephone number."+" ex) 02-202-0020");
        return false;
    }
	if(formField.getAttribute("valCheck") != null && formField.getAttribute("valCheck").toUpperCase().indexOf("DATE") > -1 && fieldValue !="" && !PortalDateCheck(fieldValue) ){
        alert(fieldTitle+" has an invalid date.\n\n"+" ex) 20051031");
        return false;
    }
	if(formField.getAttribute("valCheck") != null && formField.getAttribute("valCheck").toUpperCase().indexOf("JUMIN") > -1 && fieldValue !="" && !PortalJuminCheck(fieldValue) ){
        alert(fieldTitle+" has an invalid social security number.\n\n"+" ");
        return false;
    }

    return true;
}

function PortalTrim(str) {
    if(str == null)
        return '';
    var count = str.length;
    var len = count;
    var st = 0;

    while ((st < len) && (str.charAt(st) <= ' ')) {
        st++;
    }
    while ((st < len) && (str.charAt(len - 1) <= ' ')) {
        len--;
    }
    return ((st > 0) || (len < count)) ? str.substring(st, len) : str ;
}

function PortalMaxLengthCheck(formValue, maxlength){
    var temp;
    var bytes = 0;
    var len = formValue.length;

    for(ii=0; ii<len; ii++){
        temp = formValue.charAt(ii) ;

	if(escape(temp).length > 4){
	    bytes += 2;
	}else{
	    bytes++;
	}
    }
    if(maxlength >= bytes){
	return true;
    } else {
	return false;
    }
}

function PortalMinLengthCheck(formValue, minlength){
    var temp;
    var bytes = 0;
    var len = formValue.length;

    for(ii=0; ii<len; ii++){
        temp = formValue.charAt(ii) ;

	if(escape(temp).length > 4){
	    bytes += 2;
	}else{
	    bytes++;
	}
    }
    if(minlength <= bytes){
	return true;
    } else {
	return false;
    }

}

function PortalSpecialCharCheck(fieldValue, str) {
    var re=new RegExp(str);
    if(re.test(fieldValue))
        return true;

    return false;
}

function PortalSpecialCharCheck2(fieldValue, str) {
    var retCode = 0;
    for (sc = 0; sc < str.length; sc++) {
        var code = str.charCodeAt(sc);
        var ch = str.substr(sc,1).toUpperCase();

        code = parseInt(code);
        if(fieldValue.indexOf(ch) >= 0){
            return true;
        }
    }
    return false;
}

function PortalCharCheck(str, type){
    var retCode = 0;
    for (i = 0; i < str.length; i++) {
        var code = str.charCodeAt(i);
        var ch = str.substr(i,1).toUpperCase();

        code = parseInt(code);
        if (type=="k" && (ch < "0" || ch > "9") && ( ch < "A" || ch > "Z") && ((code > 255) || (code < 0))) {
            return true;
        }
        if (type=="e" && (ch >= "A") && (ch <= "Z")) {
            return true;
        }
        if (type=="n" && (ch >= "0" && ch <= "9")) {
            return true;
        }
    }
    return false;
}

function PortalNumberCheck(x,z){
    var cmp = "1234567890";
    var ifor;

    var return_value = true;

    len = x.length;

    if (z !=''){
        cmp = "1234567890"+z;
    }

    if (x == "" || x == null || len < 1){
        return_value = false;
    }else{
	for(ifor=0;ifor<len;ifor++){
            if(cmp.indexOf(x.substring(ifor,ifor+1))<0){
		return_value=false;
	    }
	}
    }
    return return_value;
}

function PortalFormatMask(fieldValue, format){

    var sStr = fieldValue;
    var ik;
    var jk=0;
    var tLen = sStr.length +1 ;
    if(fieldValue.length != format.length){
        return false;
    }

    for(ik=0; ik< sStr.length; ik++){
        if(format.charAt(jk)!="9" && format.charAt(jk)!="s"){
            if(sStr.charAt(ik) != format.charAt(jk)){
                return false;
            }
        }else{
            if(format.charAt(jk) =="9" && !isTemPositiveInteger(sStr.charAt(ik))){
                return false;
            }
            if(format.charAt(jk) =="s" && isTemPositiveInteger(sStr.charAt(ik))){
                return false;
            }

        }
        jk++;
    }
    return true;
}

function PortalReturnFalse(formField){
	try {
 		formField.focus();
	} catch (err) {
		// nothing
	}

    return false;
}


function PortalEmailCheck(fieldValue){
    if(fieldValue != "" && (fieldValue.indexOf('@') < 1 || fieldValue.indexOf('.') == -1)){
	return false;
    }
    return true;
}

function PortalURLCheck(fieldValue){
    if(fieldValue != "" &&fieldValue.indexOf('.') == -1){
	return false;
    }
    return true;
}

function PortalPhoneCheck(fieldValue){
    if(fieldValue != "" && fieldValue.indexOf('-')==-1){
    	return false;
    }else{
    	notN = false;
    	phones = fieldValue.split('-');
    	for(pc=0; pc < phones.length ; pc++){
    		if(isNaN(phones[pc])) {
    			notN = true;
    		}
    	}
    	if (notN == true || fieldValue.indexOf(".") >=0) {
    		return false;
    	}
    	return true;
    }
}

function PortalDateCheck(fieldValue){
	var pattern = /^((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))31)|(((0[1,3-9])|(1[0-2]))(29|30)))))$/;
	return (pattern.test(fieldValue)) ? true : false;
}

function PortalJuminCheck(fieldValue){
    var pattern = /^([0-9]{6})-?([0-9]{7})$/; 
	var num = fieldValue;
    if (!pattern.test(num)) return false; 
    num = RegExp.$1 + RegExp.$2;

	var sum = 0;
	var last = num.charCodeAt(12) - 0x30;
	var bases = "234567892345";
	for (var i=0; i<12; i++) {
		if (isNaN(num.substring(i,i+1))) return false;
		sum += (num.charCodeAt(i) - 0x30) * (bases.charCodeAt(i) - 0x30);
	}
	var mod = sum % 11;
	return ((11 - mod) % 10 == last) ? true : false;
}

function PortalEnterCheck(){
    if(event.keyCode==13) {
        return true;
    }
    return false;
}

function PortalTextLengthCheck(formField, maxlength){
    var formValue = formField.value;
    if(!PortalMaxLengthCheck(formValue, maxlength)){
	var count=0;
	for(var bytes=0; bytes < maxlength; bytes++,count++){
            var temp = formValue.charAt(count) ;
	    if(escape(temp).length > 4){
                if(bytes == eval(maxlength-1)){
                    count--;
                }else{
		    bytes++;
		}
	    }
	}
        var fieldTitle = formField.getAttribute("fieldTitle");
        alert ( fieldTitle+" has over max length."+ "\n\n"  + "Max length of this field is (in case of English) : " + maxLength);
	formField.value = formValue.substring(0, count);
	return PortalReturnFalse(formField);
    }
}

function fncNumLengthCheck(value, first, last){

    var value = PortalTrim(value);
    var temp = value.split(".");
    if(temp.length > 2) return false;

    if(value.length > 0){
        if(funCheckLength(temp[0])){
            if(temp[0].length <= first){
                if(temp[1] != null && temp[1].length > 0){
                    if(funCheckLength(temp[1])){
                        if(temp[1].length <= last){
                            return true;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }else return true;
}

    function funCheckLength(value){
        if(isTemSignedIntegers(value)){
            if(isTemPositiveInteger(value)){
                return true;
            }else return false;
        }else return false;
    }

    function isTemPositiveInteger(s){
        return (isTemSignedIntegers(s) && (parseInt (s) >= 0 ));
    }

    function isTemSignedIntegers(s){
        if(isTemEmpty(s))
            return false;

        var startPos = 0;

        if((s.charAt(0) == "-") || (s.charAt(0) == "+"))
            startPos = 1;
        return (isTemInteger(s.substring(startPos, s.length)))
    }

    function isTemEmpty(s){
        return ((s == null) || (s.length == 0));
    }

    function isTemInteger(s){
        var i;

        if(isTemEmpty(s))
            return false;

        for(i=0 ; i< s.length ; i++){
            var c = s.charAt(i);
            if(!isTemDigit(c)) return false;
        }

        return true;
    }

    function isTemDigit(c){
        return ((c >= "0") && (c <="9"))
    }
    
    function myValid(){
    	//alert('call myValid');
    	return true;
     }
    
    function confirmDelete(obj) {   
        var msg = "Are you sure you want to delete this " + obj + "?";
        ans = confirm(msg);
        if (ans) {
            return true;
        } else {
            return false;
        }
    }
