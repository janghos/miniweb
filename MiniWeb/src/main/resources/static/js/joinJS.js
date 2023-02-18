$(function(){
	var chkNum = 0 ;
	// 취소
	$(".cencle").on("click", function(){
		
		location.href = "/member/login";
				    
	})
	
	//폼 빈값 입력해야함 
	$("#submit").on("click", function(){
		if($("#me_id").val()==""){
			alert("아이디를 입력해주세요.");
			$("#me_id").focus();
			return false;
		}
		if($("#me_pw").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#me_pw").focus();
			return false;
		}

		if($("#me_email").val()==""){
			alert("이메일  입력해주세요.");
			$("#me_email").focus();
			return false;
		}


	});
	
	// 아이디 중복 체크
	$("#checkId").click(function(){
    
    let me_id = $("#me_id").val();
     
    $.ajax({
        type:'post', //post 형식으로 controller 에 보내기위함!!
        url:"/member/checkId", // 컨트롤러로 가는 mapping 입력
        data: {"me_id":me_id}, // 원하는 값을 중복확인하기위해서  JSON 형태로 DATA 전송
        success: function(data){             
            if(data == "N"){ // 만약 성공할시
                result = "사용 가능한 아이디입니다.";
                $("#result_checkId").html(result).css("color", "green");
                $("#me_pw").trigger("focus");
                chkNum +=1;
                	let idval = $('#me_id').val()
        			let idvalcheck = /^[a-z0-9]+$/
    				if (!idvalcheck.test(idval) || idval.length<6){
	        			alert('아이디는 영소문자,숫자로 구성된 6글자 이상으로 조합하시오.')
	            		$('#me_id').focus()
	            		result="아이디는 영소문자,숫자로 구성된 6글자 이상으로 조합하시오.";
                     	$("#result_checkId").html(result).css("color","red");
                     	$("#me_id").val("").trigger("focus");
						
        			}
    			
         	}
         	else{ // 만약 실패할시
         		 alert("이미 사용중인 아이디입니다.ㅅㄱ");
            	 result="이미 사용중인 아이디입니다.";
                 $("#result_checkId").html(result).css("color","red");
                 $("#me_id").val("").trigger("focus");
         }
             
     },
        error : function(error){alert(error);}
		});    
	});
	
	function email() {
		const email = $("#user_email").val();
		const middle = $("#middle").text();
		const address = $("#email_address").val();
		if(email != "" && address != "") {
			$("#me_email").val(email+middle+address);
		}
	};

    $("#user_email").change(
		function(){
			email();	
	});
	
	$("#email_address").change(
		function(){
			email();	
	});

	
    // 이메일 중복 체크
	$("#checkEmail").click(function(){
    
    let me_email = $("#me_email").val();
    let email_test = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(!email_test.test(me_email)){
		alert("올바른 이메일 형식이 아닙니다. 다시 입력해주세요.")
		$("#me_email").val("");
		$("#user_email").val("");
		$("#email_address").val("");
		result = "이메일 형식이 올바르지 않습니다..";
		$("#result_checkEmail").html(result).css("color", "red");
		return false;
	}
    $.ajax({
        type:'post', //post 형식으로 controller 에 보내기위함!!
        url:"/member/checkEmail", // 컨트롤러로 가는 mapping 입력
        data: {"me_email":me_email}, // 원하는 값을 중복확인하기위해서  JSON 형태로 DATA 전송
        success: function(data){             
            if(data == "N"){ // 만약 성공할시
                result = "사용 가능한 이메일입니다.";
                $("#result_checkEmail").html(result).css("color", "green");
                $("#me_phone").trigger("focus");
                chkNum += 1;	
         	}
         	else{ // 만약 실패할시
         		 alert("이미 사용중인 이메일입니다.ㅅㄱ");
            	 result="이미 사용중인 이메일입니다.ㅅㄱ";
                 $("#result_checkEmail").html(result).css("color","red");
                 $("#user_email").val("").trigger("focus");
				 $("#email_address").val("");
         }
             
     },
        error : function(error){alert(error);}
    });
      
    });
	if(chkNum = 2) {
	$("#submit").attr("disabled", false);
	}
	else{ 
		alert("중복 확인 해주세요" );
	}
})	



