

<div class="container">
    <%@ include file="common/headera.jspf" %>
    <%@ include file="common/navigationa.jspf" %>
    <form action="login" method="get">
        <button class="btn btn btn-xs btn-warning btn-block" type="Submit">Go To Login Page</button>
    </form>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form:form autocomplete="off"  action="registration"
                  modelAttribute="user" method="post" class="form-horizontal"
                  role="form">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:label path="firstName" class="validation-message"></form:label>
                        <form:input type="text" path="firstName" placeholder="First name"
                               class="form-control" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <form:label path="lastName" class="validation-message"></form:label>
                        <form:input type="text" path="lastName"
                               placeholder="Last Name" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="text" path="email" placeholder="Email"
                               class="form-control" /> <form:label
                            path="email"
                            class="validation-message"></form:label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="text" path="username" placeholder="Username"
                                    class="form-control" /> <form:label
                            path="username"
                            class="validation-message"></form:label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input type="password" path="password"
                               placeholder="Password" class="form-control" /> <form:label
                            path="password"
                            class="validation-message"></form:label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block">Register User</button>
                    </div>
                </div>

                <span>${successMessage}</span>


            </form:form>
        </div>
    </div>
</div>