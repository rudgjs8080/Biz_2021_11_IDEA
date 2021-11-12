<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>
<script>
    $(function (){

        // 입력박스에서 tab을 누르거나 마우스를 다른 곳으로 클릭했을 때
        // lost focus
        $("input#username").on("blur", function (){
            // ID 중복검사
            $.ajax({
                url: "${rootPath}/member/idcheck",
                data : {username:$(this).val()}
            })
            .done(function(result){
                if(result){
                    // alert("이미 사용중인 ID")
                    $("div.input_error").text(
                        "이미 사용중인 ID 입니다"
                    )
                    $(this).focus()
                } else {
                    // alert("사용가능한 ID ")
                    $("div.input_error").text(
                        "사용가능한 ID 입니다"
                    ).css("color", "blue")
                    $("#password").focus()
                }
            })
        })

        $("button.btn_join_ok").on("click", function (){
            const username = $("#username")
            const password = $("#password")
            const re_passworod = $("#re_password")

            if(username.val() === ""){
                alert("사용자 이름은 필수항목입니다")
                username.focus()
                return false
            }
            if(password.val() === ""){
                alert("사용자 비밀번호는 필수항목입니다")
                password.focus()
                return false
            }
            if(re_passworod.val() ===""){
                alert("비밀번호를 한 번 더 입력해주세요")
                re_passworod.focus()
                return false
            }
            if(password.val() !== re_passworod.val()){
                alert("비밀번호 재확인이 일치하지 않습니다")
                password.val("")
                re_passworod.val("")
                password.focus()
                return false
            }
            $("form.join").submit()
        })
    })
</script>
<form:form cssClass="join" method="POST">
    <div>
        <input name="username" id="username" placeholder="사용자 이름"/>
    </div>
    <div class="input_error">

    </div>
    <div>
        <input name="password" id="password" placeholder="비밀번호" type="password"/>
    </div>
    <div>
        <input name="re_password" id="re_password" placeholder="비밀번호 확인" type="password"/>
    </div>
    <div>
        <button class="btn btn_join_ok">회원 가입 신청</button></div>


</form:form>