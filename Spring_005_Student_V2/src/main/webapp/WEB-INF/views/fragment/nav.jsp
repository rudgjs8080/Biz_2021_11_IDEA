<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    nav li.login {
        maargin-left : auto;
    }
</style>
<script>
    $(function (){
        $("li.student").on("click", function(){
            location.href = `${rootPath}/st/list`
        })
        $("li.home").on("click", function (){
            location.href = `${rootPath}/`
        })
        $("li.score").on("click", function (){
            location.href = `${rootPath}/score/list`
        })
        $("li.login").on("click", function (){
            location.href = `${rootPath}/member/login`
        })
    })
</script>
<nav>
    <ul>
        <li class="home">HOME</li>
        <li class="student">학생정보</li>
        <li class="score">성적일람표</li>
        <li class="login">로그인</li>
    </ul>
</nav>