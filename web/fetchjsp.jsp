<%-- 
    Document   : fetchjsp
    Created on : 3 Jul, 2016, 12:49:34 AM
    Author     : RAJAT DUBEY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE> </TITLE>
          <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
               nav li a 
           {
	      background: #000000;
	      border-right: 1px solid #00ffff;
	      color: #00ffff;
	      display: block;
	      float:left;
	      font: 400 13px/1.4 'Cutive', Helvetica, Verdana, Arial, sans-serif;
	      padding: 20px;
	      text-align: center;
	      text-decoration:none;
	       text-transform: uppercase;
	       width: 160px;
             }
              nav li a:hover
              {
	         background: #fbb;
               }
            .footer-style1
               {
                 width: 1310px;
                  height: 30px;
                 border: 1px solid #800000;
                 background:red;
                color:white;
               }
            .login
           {
              margin-top: 45px;
              margin-bottom: 45px;
              height:280px;
              width:470px;
              margin-left: 404px;             
              border:2px #aaa solid;
              padding:10px;
              
              background-color:brown;
           }
            input
            {
              background: #E1FFE1;
              border:1px #CCC solid;
               padding:5px;
            }  
   h1
{
       position:absolute;
       top:80px;
       center:0;
       width:100%;
       color:#000000;
}
#primary_nav_wrap
{
	margin-top:15px
}

#primary_nav_wrap ul
{
	list-style:none;
	position:relative;
	float:left;
	margin:0;
	padding:0
}

#primary_nav_wrap ul a
{
	display:block;
	color:silver;
	text-decoration:none;
	font-weight:700;
	font-size:16px;
	line-height:32px;
	padding:0 30px;
	font-family:"HelveticaNeue","Helvetica Neue",Helvetica,Arial,sans-serif;
                  
}

#primary_nav_wrap ul li
{
	position:relative;
	float:left;
	margin:0;
	padding:0
}

#primary_nav_wrap ul li.current-menu-item
{
	background:#ddd
}

#primary_nav_wrap ul li:hover
{
	background:#f6f6f6
}

#primary_nav_wrap ul ul
{
	display:none;
	position:absolute;
	top:100%;
	left:0;
	background:#fff;
	padding:0
}

#primary_nav_wrap ul ul li
{
	float:none;
	width:200px
}

#primary_nav_wrap ul ul a
{
	line-height:120%;
	padding:10px 15px
}

#primary_nav_wrap ul ul ul
{
	top:0;
	left:100%
}

#primary_nav_wrap ul li:hover > ul
{
	display:block
}
 #main
			   {
			  font:bold 30px tahoma;
			 text-align:center;
			 padding:40px;
			 padding-bottom:100px;
			   
			   }
			   article footer
			   {
			   padding-top:40px;
			   }
  
        </style>
    </HEAD>

    
         <body style="margin:0;background-color:cream">
        <div>
            <table>
                <tr>
                    <td colspan="2"><img src="12.JPG"alt="" width="219px" height="205px" ></td></div><div>
                    <td colspan="3" ><img src="24.jpg"alt="" width="1100px" height="205px"/> </td><h1><center>WELCOME TO MESS MANAGEMENT PORTAL</center></h1> </div> 
                </tr>
            </table>
        </div>

        <% 
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mess","root","tsunadesama");
             String id=request.getParameter("uid");
            Statement statement = connection.createStatement() ;
            String s="select * from userdetails where id='"+id+"'";
            ResultSet resultset = 
                statement.executeQuery(s); 
        %>
        
         
<div style="background-color:#DEB887">
        <TABLE BORDER="1" align="center" style="width:500px; height:100px; background-color:brown">
            
            <TR>
                <TH>ID</TH>
                <TH>Name</TH>
                <TH>Food Type</TH>
                <TH>Amount</TH>
                <TH>User</TH>
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString(1) %></td>
                <TD> <%= resultset.getString(2) %></TD>
                <TD> <%= resultset.getString(5) %></TD>
                <TD> <%= resultset.getString(6) %></TD>
                <TD> <%= resultset.getString(9) %></TD>
            </TR>
            <% } %>
            
        </TABLE>
</div>
             <div>
          <section id="main">
               <article>
               <div>
                 <table>
                   
                   
                
                    <footer>    <input type="button" name="Back" value="Home" style="color:red; width: 125px;height: 50px; background-color: #DEB887" onclick="window.location.href='index.html' " >
  <input type="button" name="Back" value="Back" style="color:red; width: 125px;height: 50px; background-color: #DEB887" onclick="window.location.href='Adminsign.html' " >
	
</footer>
			 </article>
           </section>
           
        </div>
    </BODY>
</HTML>
