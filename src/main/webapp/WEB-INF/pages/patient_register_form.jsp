<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<style type="text/css">
   .file
   {
      height:40px;
      width:250px;
      background-color: pink;
      border:2px dotted blue;
      padding-top:20px;
      padding-left: 10px;
      border-radius: 10px;
       
   }
   input
   {
      width:250px;
      height:22px;
      border-radius: 5px;
   }
   input:hover
   {
       border:1px solid red;
   }
   .container
   {
       background-color: #8B9DC3;
       margin-left: 300px;
       margin-right:300px;
       padding-top: 20px;
       padding-bottom: 20px;
       font-size: 20px;
       border-radius: 10px;
       border:1px solid blue;
        
   }
   h2
   {
      text-align: center;
      color:red;
   }
   td
   {
      padding-left: 10px;
   }
   .sub
   {
       width: 120px;
       height:25px; 
       background-color: green;
       border:none;
       border-radius: 5px;
       color: white;
   }
   .can
   {
       width: 120px;
       height:25px; 
        background-color: maroon;
       border:none;
       border-radius: 5px;
       color: white;
   }
   #file-id:hover {
	border:none;
}
</style>
</head>
<body>
 <h2>Patient Registration Form</h2>
 <div class="container">
     <form action="register" method="post" enctype="multipart/form-data">
     <table align="center">
    <tr>
      <td>Name :</td>
      <td><input type="text" name="name" placeholder="Enter your name"/></td>
      <td>Age :</td>
      <td><input type="text" name="age" placeholder="Enter your age"/></td>
    </tr>
    <tr>
      <td>Address :</td>
      <td><input type="text" name="address" placeholder="Enter your address"/></td>
      <td>Aadhar No :</td>
      <td><input type="text" name="aadhar" placeholder="Enter your aadhar"/></td>
    </tr>
    <tr>
      <td>Mobile No :</td>
      <td><input type="text" name="mobNo" placeholder="Enter your mobile no"/></td>
      <td>Pincode :</td>
      <td><input type="text" name="pincode" placeholder="Enter your pincode"/></td>
    </tr>
    <tr>
      <td>Email :</td>
      <td><input type="email" name="email" placeholder="Enter your email"/></td>
      <td>Upload Previous Report :</td>
      <td>
        <div class="file">
           <input type="file" name="file"  id="file-id" multiple="multiple"/>
        </div>
      </td>
    </tr>
  </table><br>
  <center>
			<input type="submit" value="Register" class="sub">
			<input type="reset" value="Reset" class="can"> 
  </center><br>
 </form>
 
 </div>
 
 <h3 style="text-align: center"><a href="./">Home</a></h3>
</body>
</html>