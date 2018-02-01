<%--
  Created by IntelliJ IDEA.
  User: srinath
  Date: 1/8/2018
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="container">
    <div class="wrapper">
        <!-- end container -->
        <%@ include file="common/headera.jspf" %>
        <div>
            <form action="registration" method="get">
                <button class="btn btn-xs btn-warning btn-block" type="Submit">Go To Registration Page</button>
            </form>

            <%--<img src="/images/login.jpg" class="img-responsive center-block" width="300" height="300" alt="Logo" />--%>
            <form action="login" method="POST" class="form-signin">
                <h3 class="form-signin-heading">Welcome</h3>
                <br/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="text" id="email" name="email" placeholder="email"
                       class="form-control"/> <br/>
                <input type="password" placeholder="Password"
                       id="password" name="password" class="form-control"/> <br/>

                <c:if test="{param.error}">
                    <div align="center">
                        <p>Email or Password invalid, please verify</p>
                    </div>
                </c:if>
                <c:if test="{param.logout}">
                    <div align="center">
                        <p style="font-size: large">You have been logged out</p>
                    </div>
                </c:if>
                <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">Login
                </button>
            </form>

        </div>
    </div>
    <%@ include file="common/footera.jspf" %>
</div>
