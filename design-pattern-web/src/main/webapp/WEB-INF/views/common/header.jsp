<%@ page contentType="text/html; charset=utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


        <!-- Begin Navbar -->
<div class="navbar navbar-static">
   <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/"/>"><b>HSDc Design Pattern System</b></a>
      <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="glyphicon glyphicon-chevron-down"></span>
      </a>
    </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">  
          <!-- <li><a href="${pageContext.request.contextPath }/queryOrders">Query Member Orders</a></li>
          <li><a href="#">List All Orders</a></li> -->
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Creational Pattern</a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath }/bd">Builder Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/fm">Factory Method Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/pt">Prototype Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/sg">Singleton Pattern</a></li>
              
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Strutural Pattern</a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath }/bg">Bridge Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/cp">Composite Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/dec">Decorator Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/fw">Flyweight Pattern</a></li>
              
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Behavioural Pattern</a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath }/cmd">Command Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/it">Interpreter Pattern</a></li>
              <li><a href="#">Iterator Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/md">Mediator Pattern</a></li>
              <li><a href="${pageContext.request.contextPath }/tm">Template Method Pattern</a></li>
              
            </ul>
          </li>
        </ul>
        <ul class="nav pull-right navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-search"></i></a>
            <ul class="dropdown-menu" style="padding:12px;">
                <form class="form-inline">
     				<button type="submit" class="btn btn-default pull-right"><i class="glyphicon glyphicon-search"></i></button><input type="text" class="form-control pull-left" placeholder="Search">
                </form>
             </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> <i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="<c:url value="${pageContext.request.contextPath}/j_spring_security_logout" />">Logout</a></li>
              <li><a href="#">Profile</a></li>
              <li class="divider"></li>
              <li><a href="#">About</a></li>
             </ul>
          </li>
        </ul>
      </div>
    </div>
</div><!-- /.navbar -->

<!-- 
<header class="masthead">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <h1><a href="#" title="Scroll down for your viewing pleasure">Bootable Template</a>
          <p class="lead">2-column Theme + Layout for Bootstrap 3.</p></h1>
      </div>
      <div class="col-md-6">
        <div class="well pull-right">
          <img src="//placehold.it/280x100/E7E7E7">        
        </div>
      </div>
    </div>
  </div>
</header>
 -->
    
    
    
    
    

   
    